package cn.clothes.util;

import java.io.File;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.Environment;


/**
 * description:处理客户端穿过来的网页
 * @author zhaofeng
 *
 */
public class BdbHtmlPoolServer extends AbstractBdbServer {
	private final Log log = Log.getLogger(BdbHtmlPoolServer.class);
	private final String POOL_NAME = "Cassandra_HtmlPool";
	private static Database bdb = null;
	private ClassCatalog catalog = null;
	private EntryBinding<String> entryBinding = null;
	
	private static BdbHtmlPoolServer instance = null;
	private static final byte[] sync = new byte[0];
	
	public static BdbHtmlPoolServer getInstance() {
		if(instance != null){
			return instance;
		}
		synchronized (sync) {
			if(instance == null){
				instance = new BdbHtmlPoolServer();
			}
		}
		return instance;
	}
	
	private BdbHtmlPoolServer() {		
		String dirPath;
		File dbdFile = null;
		
		dirPath = bdbConfig.getBdbSavePath() + POOL_NAME; 	// 数据存储目录
		//dbdFile = AbstractBdbServer.clearBdb(dirPath);		//保证每次重启，对库进行重新创建
		
		dbdFile = new File(dirPath);
        if (!dbdFile.exists()) {
        	dbdFile.mkdirs();
        }
		
		Environment environment = new Environment(dbdFile, environmentConfig);
		bdb = environment.openDatabase(null, POOL_NAME, databaseConfig);
	}
	/**
     * 保存数据
     *
     * @param key
     * @param value
     * @return
     */
    public boolean saveData(byte[] key, byte[] value) {
        return super.save(bdb, key, value);
    }
    
    /**
     * 获取对象
     * @param key
     * @return
     */
    public String getClientResultBen(byte[] key){
    	byte[] bs = super.get(bdb, key);
    	if(bs != null) {
    		return new String(bs);
    	}else{
    		return null;
    	}
    }
    /**
     * 根据key删除数据
     * @param key
     * @return
     */
    public boolean deleteData(byte[] key){
    	return super.delete(bdb, key);
    }
	
	public void close(){
		bdb.close();
		bdb.getEnvironment().cleanLog();
		bdb.getEnvironment().close();
	}
	
	public static void main(String[] args) { 
		BdbHtmlPoolServer instance = BdbHtmlPoolServer.getInstance();
		instance.getClientResultBen("1213".getBytes());
	}
	
}
