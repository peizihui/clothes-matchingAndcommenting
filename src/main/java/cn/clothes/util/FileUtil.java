package cn.clothes.util;

import java.io.File;

public class FileUtil {
	public static String getRootPath() {
		return null;
	}
	
	/**
	 * 
	 * @param fileName
	 * @param mkdir
	 * @return
	 */
	public static File getImagePath(String fileName, boolean ... mkdir) {
		String path = "temp/" + fileName;
		File file = new File(path);
		
		if(mkdir.length > 0 && mkdir[0] && !file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
}
