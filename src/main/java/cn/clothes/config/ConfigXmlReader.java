package cn.clothes.config;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 提取XML文件，将XML数据数据结果提取至Maps对象中
 * @author chenlongquan
 *
 */
public class ConfigXmlReader {
	static Logger log = Logger.getLogger(ConfigXmlReader.class);

	/**
	 * 读取XML数据，并将数据写入至Map对象中，以方便后续使用
	 * @param xmlPath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, String>> read(String xmlPath) {
		Map<String, Map<String, String>> configs = new HashMap<String, Map<String, String>>();
		SAXReader reader = new SAXReader(); // 使用SAXReader方式读取XML文件
		Document doc = null;
		try {
			doc = reader.read(new File(xmlPath));
		} catch (DocumentException e) {
			log.error("[ConfigFactory.initConfig] read config xml error ", e);
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		Iterator<Element> it1 = root.elementIterator();
		while (it1.hasNext()) {
			Element e1 = it1.next();
			String configName = e1.getName();
			Map<String, String> config = new HashMap<String, String>();
			Iterator<Element> it2 = e1.elementIterator("property");
			while (it2.hasNext()) {
				Element e2 = it2.next();
				String name = e2.attributeValue("name");
				String value = e2.attributeValue("value");
				config.put(name, value);
			}
			configs.put(configName, config);
		}
		return configs;
	}

}
