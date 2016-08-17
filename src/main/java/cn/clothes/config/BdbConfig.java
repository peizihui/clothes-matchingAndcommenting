package cn.clothes.config;

import java.util.Map;

import jodd.typeconverter.Convert;

/**
 * @description: BDB数据库使用配置
 * 
 */
public class BdbConfig{
	/**
	 * 是否自动创建
	 */
	private boolean allowCreate;
	
	/**
	 * 是否开始事务
	 */
	private boolean transactional;
	
	private boolean deferredWrite;
	
	private boolean readOnly;
	
	private boolean sortedDuplicates;
	
	private boolean exclusiveCreate;
	
	/**
	 * bdb存放路径
	 */
	private String bdbSavePath;

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

	public boolean isDeferredWrite() {
		return deferredWrite;
	}

	public void setDeferredWrite(boolean deferredWrite) {
		this.deferredWrite = deferredWrite;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isSortedDuplicates() {
		return sortedDuplicates;
	}

	public void setSortedDuplicates(boolean sortedDuplicates) {
		this.sortedDuplicates = sortedDuplicates;
	}

	public boolean isExclusiveCreate() {
		return exclusiveCreate;
	}

	public void setExclusiveCreate(boolean exclusiveCreate) {
		this.exclusiveCreate = exclusiveCreate;
	}
	public String getBdbSavePath() {
		return bdbSavePath;
	}

	public void setBdbSavePath(String bdbSavePath) {
		this.bdbSavePath = bdbSavePath;
	}

	public BdbConfig initConfig(Map<String, String> config) {
		allowCreate = Convert.toBooleanValue(config.get("allowCreate"));
		transactional = Convert.toBooleanValue(config.get("transactional"));
		deferredWrite = Convert.toBooleanValue(config.get("deferredWrite"));
		readOnly = Convert.toBooleanValue(config.get("readOnly"));
		sortedDuplicates = Convert.toBooleanValue(config.get("sortedDuplicates"));
		exclusiveCreate = Convert.toBooleanValue(config.get("exclusiveCreate"));
		bdbSavePath = config.get("bdbSavePath");

		return this;
	}
}