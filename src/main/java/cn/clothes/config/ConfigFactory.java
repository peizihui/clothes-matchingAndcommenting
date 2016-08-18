package cn.clothes.config;

import java.util.Map;




/**
 * 读取配置
 * @author chenlongquan
 *
 */

public class ConfigFactory {



	private static ConfigFactory instance = null;

	private static final byte[] sync = new byte[0];
	

	
	/**
	 * bdb 配置
	 */
	private BdbConfig bdbConfig;
	private BdbEnvConfig bdbEnvConfig;
	
	public static ConfigFactory getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (sync) {
			if (instance == null) {
				instance = new ConfigFactory();
			}
		}

		return instance;
	}
	
	private ConfigFactory(){
		Map<String, Map<String, String>> read = ConfigXmlReader.read(ConfigFactory.class.getClassLoader().getResource("setup-config.xml").getFile());
		//dataStorageConfig = new DataStorageConfig().initConfig(read.get("log"));
		bdbConfig = new BdbConfig().initConfig(read.get("bdbConfig"));
		bdbEnvConfig = new BdbEnvConfig().initConfig(read.get("bdbEnvConfig"));
	//	jsonStorageConfig = new JsonStorageConfig().initConfig(read.get("log"));
	}
	

	
	
	public BdbConfig getBdbConfig(){
		return bdbConfig;
	}
	
	public BdbEnvConfig getBdbEnvConfig(){
		return bdbEnvConfig;
	}
}
