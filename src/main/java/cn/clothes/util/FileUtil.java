package cn.clothes.util;

import java.io.File;

import org.springframework.web.context.ContextLoader;

public class FileUtil {
	public static String getRootPath() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
	}
	
	/**
	 * 
	 * @param fileName
	 * @param mkdir
	 * @return
	 */
	public static File getImagePath(String fileName, boolean ... mkdir) {
		String path = getRootPath() + "/temp/" + fileName;
		File file = new File(path);
		
		if(mkdir.length > 0 && mkdir[0] && !file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
}
