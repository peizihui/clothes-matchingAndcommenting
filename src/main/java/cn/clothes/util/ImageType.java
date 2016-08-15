package cn.clothes.util;

/**
 * 图片类型
 * @author clq
 * @date 2015年2月27日
 */
public enum ImageType {

	/**
	 * png图片
	 */
	PNG("image/png", "png"),
	/**
	 * jpg图片
	 */
	JPG("image/jpg", "jpg"),
	/**
	 * jpg图片
	 */
	JPEG("image/jpeg", "jpeg"),
	/**
	 * bmp图片
	 */
	BMP("image/bmp", "bmp"),
	/**
	 * gif图片
	 */
	GIF("image/gif", "gif"),
	/**
	 * 未知的文件类型
	 */                                                                                                   
	UNKNOW(null, null);
	
	private String type;
	private String media;
	
	ImageType(String media, String type){
		this.media = media;
		this.type = type;
	}
	
	/**
	 * 获取图片类型
	 * @author clq
	 * @date 2015年2月27日
	 * @return
	 */
	public String getType(){
		return this.type;
	}
	
	/**
	 * 获取图片的Media
	 * @author clq
	 * @date 2015年6月10日
	 * @return
	 */
	public String getMedia(){
		return this.media;
	}
}
