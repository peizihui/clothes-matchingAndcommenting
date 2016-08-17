package cn.clothes.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

import cn.clothes.config.BdbConfig;
import cn.clothes.config.BdbEnvConfig;
import cn.clothes.config.ConfigFactory;


/**
 * bdb初始�? * @author zhaofeng
 *
 */
public abstract class AbstractBdbServer {
	
	private static final Log log =Log.getLogger(AbstractBdbServer.class);
	/**
	 * bdb配置信息
	 */
	protected static final BdbConfig bdbConfig = ConfigFactory.getInstance().getBdbConfig();
	protected static final BdbEnvConfig bdbEnvConfig = ConfigFactory.getInstance().getBdbEnvConfig();
	
	/**
	 * bdb引擎
	 */
	protected static DatabaseConfig databaseConfig = null;	
	protected static EnvironmentConfig environmentConfig = null;
	
	static {
		databaseConfig = new DatabaseConfig();
		databaseConfig.setAllowCreate(bdbConfig.isAllowCreate());		//无数据库时自动创建数据库
		databaseConfig.setTransactional(bdbConfig.isTransactional());		//默认不开启事�?		databaseConfig.setDeferredWrite(bdbConfig.isDeferredWrite());		//延迟写入  延迟写入的特征减少IO的操作，sync的时间点为：1：手动调用database.sync方法 2：达到缓存上�?3：checkpoint（尚未理解什么意思）
		databaseConfig.setReadOnly(bdbConfig.isReadOnly());
		databaseConfig.setSortedDuplicates(bdbConfig.isSortedDuplicates());
		databaseConfig.setExclusiveCreate(bdbConfig.isExclusiveCreate());

		environmentConfig = new EnvironmentConfig();
		environmentConfig.setAllowCreate(bdbEnvConfig.isAllowCreate());		//自动创建文件
		environmentConfig.setTransactional(bdbEnvConfig.isTransactional());	//关闭事务
		environmentConfig.setCacheSize(bdbEnvConfig.getCacheSize());		//设置缓存大小
		environmentConfig.setTxnNoSyncVoid(bdbEnvConfig.isTxnNoSyncVoid());
		environmentConfig.setLockTimeout(bdbEnvConfig.getLockTimeout(), TimeUnit.MILLISECONDS);
		
		environmentConfig.setConfigParam("je.log.fileMax",bdbEnvConfig.getFileMax()); 
		environmentConfig.setConfigParam("je.maxMemoryPercent", bdbEnvConfig.getMaxMemoryPercent());
		environmentConfig.setConfigParam("je.log.faultReadSize",bdbEnvConfig.getFaultReadSize());   //默认�?��读多�?
		environmentConfig.setConfigParam("je.checkpointer.bytesInterval",bdbEnvConfig.getCheckpointer());// 缓存中脏数据大小阈�?，超过这个阈值，写一次log
		environmentConfig.setTxnTimeout(bdbEnvConfig.getTxnTimeout(), TimeUnit.MILLISECONDS);
	
	}
	
	 /**
     * 保存数据
     *
     * @param key
     * @param value
     * @return
     */
    protected boolean save(Database bdb, byte[] key, byte[] value) {
        boolean result = false;
        DatabaseEntry databaseKey = new DatabaseEntry(key);
        DatabaseEntry databaseValue = new DatabaseEntry(value);
        OperationStatus status = bdb.put(null, databaseKey, databaseValue);
        if (OperationStatus.SUCCESS == status) {
            result = true;
        } else {
            log.error("save data error .the result of save is {0} KEY:{1} VALUE:{2}",
                    status.name(), new String(key), new String(value));
        }
        return result;
    }

    /**
     * 查找数据
     *
     * @param key
     * @return
     */
    protected byte[] get(Database bdb, byte[] key) {
        DatabaseEntry databaseKey = new DatabaseEntry(key);
        DatabaseEntry databaseValue = new DatabaseEntry();
        OperationStatus status = bdb.get(null, databaseKey, databaseValue, LockMode.DEFAULT);
        if (OperationStatus.SUCCESS == status) {
            return databaseValue.getData();
        } else {
            log.error("get data error .the result of get is {0}  KEY:{1}",
                    status.name(), new String(key));
            return null;
        }
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    protected boolean delete(Database bdb, byte[] key) {
        boolean result = false;
        DatabaseEntry databaseKey = new DatabaseEntry(key);
        DatabaseEntry databaseValue = new DatabaseEntry();
        OperationStatus status = bdb.delete(null, databaseKey);
        if (OperationStatus.SUCCESS == status) {
            result = true;
        } else {
            log.error("delete data error .the result of delete is {0} KEY:{1}",
                    status.name(), new String(key));
        }
        return result;
    }

    /**
     * @param bdb
     * @param count
     * @return
     */
    protected List<byte[]> get(Database bdb, int count) {
        List<byte[]> result = new ArrayList<byte[]>(count);
        Cursor cursor = bdb.openCursor(null, null);
        DatabaseEntry databaseKey = new DatabaseEntry();
        DatabaseEntry databaseValue = new DatabaseEntry();
        int k = 0;
        while (cursor.getNext(databaseKey, databaseValue, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
            k++;
            result.add(databaseValue.getData());
            if (k == count) break;
        }
        cursor.close();
        return result;
    }

    /**
     * 关闭数据�?     *
     * @param bdb
     */
    protected void close(Database... bdb) {
        for (Database d : bdb) {
            d.close();
            d.getEnvironment().cleanLog();
            d.getEnvironment().close();

        }

    }

    /**
     * 判断key是否存在
     *
     * @param db
     * @param key
     * @return
     */
    protected boolean exist(Database db, byte[] key) {
        DatabaseEntry databaseKey = new DatabaseEntry(key);
        DatabaseEntry databaseValue = new DatabaseEntry();

        OperationStatus status = db.get(null, databaseKey, databaseValue, LockMode.DEFAULT);
        if (status == OperationStatus.SUCCESS) {
            if (databaseValue.getData() != null)
                return true;
        }
        return false;

    }

    /**
     * 查询总数
     *
     * @param db
     * @return
     */
    protected long count(Database db) {
        long count = 0;
        count = db.count();
        return count;
    }
	
	public static File clearBdb(String directoryPath)
	{
		if(null==directoryPath||directoryPath.trim().length()<=0)
		{
			log.error("directoryPath is null.");
			throw new IllegalArgumentException("directoryPath is null.");
		}
		File directoryFile = new File(directoryPath);
		if(directoryFile.exists())
		{
			clearBdb(directoryFile);
		}
		directoryFile.mkdirs();
		return directoryFile;
	}
	
	private static void clearBdb(File file){
		if(file.isDirectory()){
			File[] listFiels = file.listFiles();
			if(listFiels.length>0)
			{
				for (File childFile : listFiels) {
					clearBdb(childFile);
				}
			}
			file.delete();
		}else{
			file.delete();
		}
	}
}

