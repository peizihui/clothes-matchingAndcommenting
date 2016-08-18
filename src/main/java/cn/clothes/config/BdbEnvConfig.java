package cn.clothes.config;

import java.util.Map;

import jodd.typeconverter.Convert;

/**
 * @description: BDB环境参数配置
 * 
 */
public class BdbEnvConfig{
	/**
	 * 是否自动创建
	 */
	private boolean allowCreate;
	
	/**
	 * 是否开始事务
	 */
	private boolean transactional;
	
	/**
	 * 
	 */
	private long cacheSize;
	
	private boolean txnNoSyncVoid;
	
	/**
	 * 以秒为单位
	 */
	private int lockTimeout;
	
	/**
	 * 存储文件大小
	 */
	private String fileMax;
	
	/**
	 *  占用JVM百分比
	 */
	private String maxMemoryPercent;
	
	private String faultReadSize;
	
	private String checkpointer;
	
	private int txnTimeout;

	public boolean isAllowCreate() {
		return allowCreate;
	}

	public void setAllowCreate(boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	public boolean isTransactional() {
		return transactional;
	}

	public void setTransactional(boolean transactional) {
		this.transactional = transactional;
	}

	public long getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(long cacheSize) {
		this.cacheSize = cacheSize;
	}

	public boolean isTxnNoSyncVoid() {
		return txnNoSyncVoid;
	}

	public void setTxnNoSyncVoid(boolean txnNoSyncVoid) {
		this.txnNoSyncVoid = txnNoSyncVoid;
	}

	public int getLockTimeout() {
		return lockTimeout;
	}

	public void setLockTimeout(int lockTimeout) {
		this.lockTimeout = lockTimeout;
	}


	public int getTxnTimeout() {
		return txnTimeout;
	}

	public void setTxnTimeout(int txnTimeout) {
		this.txnTimeout = txnTimeout;
	}

	public void setFileMax(String fileMax) {
		this.fileMax = fileMax;
	}

	public void setMaxMemoryPercent(String maxMemoryPercent) {
		this.maxMemoryPercent = maxMemoryPercent;
	}

	public void setFaultReadSize(String faultReadSize) {
		this.faultReadSize = faultReadSize;
	}

	public void setCheckpointer(String checkpointer) {
		this.checkpointer = checkpointer;
	}

	public String getFileMax() {
		return fileMax;
	}

	public String getMaxMemoryPercent() {
		return maxMemoryPercent;
	}

	public String getFaultReadSize() {
		return faultReadSize;
	}

	public String getCheckpointer() {
		return checkpointer;
	}
	public BdbEnvConfig initConfig(Map<String, String> config) {
		allowCreate = Convert.toBooleanValue(config.get("allowCreate"));
		transactional = Convert.toBooleanValue(config.get("transactional"));
		cacheSize = Convert.toLongValue(config.get("cacheSize"));
		txnNoSyncVoid = Convert.toBooleanValue(config.get("txnNoSyncVoid"));
		lockTimeout = Convert.toIntValue(config.get("lockTimeout"));
		fileMax = config.get("fileMax");
		maxMemoryPercent = config.get("maxMemoryPercent");
		faultReadSize = config.get("faultReadSize");
		checkpointer = config.get("lockTimeout");
		txnTimeout = Convert.toIntValue(config.get("txnTimeout"));

		return this;
	}
}