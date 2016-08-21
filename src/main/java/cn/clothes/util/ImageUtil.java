package cn.clothes.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.codec.binary.Base64;


/**
 * 图片处理工具类
 * @author clq
 * @date 2015年4月30日
 */
public final class ImageUtil {
	private BufferedImage image;
	
	private ImageUtil(BufferedImage image) {
		image.getWidth();
		this.image = image;
	}
	
	/**
	 * 从InputStream 读取图片,这个方法不会关闭InputStream
	 * @author clq
	 * @date 2015年4月30日
	 * @param input InputStream
	 * @return
	 * @throws IOException
	 */
	public static ImageUtil read(InputStream input) throws IOException{
		return new ImageUtil(ImageIO.read(input));
	}
	
	/**
	 * 从文件读取图片
	 * @author clq
	 * @date 2015年4月30日
	 * @param input 一个图片文件
	 * @return
	 * @throws IOException
	 */
	public static ImageUtil read(File input) throws IOException{
		return new ImageUtil(ImageIO.read(input));
	}
	
	/**
	 * 从文件读取图片,这个方法不会关闭ImageInputStream
	 * @author clq
	 * @date 2015年4月30日
	 * @param input ImageInputStream
	 * @return
	 * @throws IOException
	 */
	public static ImageUtil read(ImageInputStream input) throws IOException{
		return new ImageUtil(ImageIO.read(input));
	}
	
	/**
	 * 从BufferedImage中构造ImageUtil
	 * @author clq
	 * @date 2015年4月30日
	 * @param input 图片对象
	 * @return
	 * @throws IOException
	 */
	public static ImageUtil read(BufferedImage input) throws IOException{
		return new ImageUtil(input);
	}
	
	/**
	 * 从一个字节数据读取图片
	 * @author clq
	 * @date 2015年4月30日
	 * @param input 字节数据
	 * @return
	 * @throws IOException
	 */
	public static ImageUtil read(byte[] input) throws IOException{
		try (ByteArrayInputStream inputs = new ByteArrayInputStream(input)){
			ImageUtil imageUtil = new ImageUtil(ImageIO.read(inputs));
			return imageUtil;
		
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * 从base64的字符串数据读取图片
	 * @author clq
	 * @date 2015年4月30日
	 * @param input base64的字符串数据
	 * @return
	 * @throws IOException
	 */
	public static ImageUtil read(String input) throws IOException {
		try (ByteArrayInputStream inputs = new ByteArrayInputStream(Base64.decodeBase64(input))) {
			return new ImageUtil(ImageIO.read(inputs));

		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * 获取图片信息
	 * @author clq
	 * @date 2015年4月30日
	 * @return
	 */
	public BufferedImage getImage(){
		return image;
	}
	
	/**
	 * 转换成base64编码的字符串
	 * @author clq
	 * @date 2015年4月30日
	 * @param formatName 图片的格式,不带后缀名
	 * @return base64编码的字符串
	 * @throws IOException
	 */
	public String toBase64(String formatName) throws IOException {
		try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
			ImageIO.write(image, formatName, output);
			return new String(Base64.encodeBase64(output.toByteArray()));

		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * 缩放图片
	 * @param newWidth 高度
	 * @param newHeight 宽度
	 * @param bb 比例不对时是否需要补白
     * @return 
	 */
	public ImageUtil resize(int newWidth, int newHeight, boolean bb) {
		double ratio = 0.0; // 缩放比例
		Image itemp = image.getScaledInstance(newHeight, newWidth, BufferedImage.SCALE_SMOOTH);
		
		// 计算比例
		if ((image.getHeight() > newWidth) || (image.getWidth() > newHeight)) {
			if (image.getHeight() > image.getWidth()) {
				ratio = (new Integer(newWidth)).doubleValue() / image.getHeight();
			} else {
				ratio = (new Integer(newHeight)).doubleValue() / image.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
			itemp = op.filter(image, null);
			image = (BufferedImage) itemp;
		}
		
		if (bb) {
			BufferedImage image = new BufferedImage(newHeight, newWidth, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, newHeight, newWidth);
			if (newHeight == itemp.getWidth(null))
				g.drawImage(itemp, 0, (newWidth - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
			else
				g.drawImage(itemp, (newHeight - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
			g.dispose();
			itemp = image;
			image = (BufferedImage) itemp;
		}
		
		return this;
	}
	
	/**
	 * 获取图片的宽度
	 * @author clq
	 * @date 2015年4月30日
	 * @return
	 */
	public int getWidth(){
		return image.getWidth();
	}
	
	/**
	 * 获取图片的高度
	 * @author clq
	 * @date 2015年4月30日
	 * @return
	 */
	public int getHeight(){
		return image.getHeight();
	}
	
	/**
	 * 获取图片的实际类型
	 * @author clq
	 * @date 2015年4月30日
	 * @param bytes 字节数组
	 * @return
	 */
	public static ImageType getMediaType(byte[] bytes){
		byte[] buffer = Arrays.copyOf(bytes, 8);
		
		if (buffer[0] == 'G' && buffer[1] == 'I' && buffer[2] == 'F'
				&& buffer[3] == '8' && (buffer[4] == '7' || buffer[4] == '9')
				&& buffer[5] == 'a') {
			return ImageType.GIF;
		}

		if ((buffer[0] == 0x42) && (buffer[1] == 0x4d)) {
			return ImageType.BMP;
		}

		if ((buffer[0] == (byte) 137 && buffer[1] == (byte) 80
				&& buffer[2] == (byte) 78 && buffer[3] == (byte) 71
				&& buffer[4] == (byte) 13 && buffer[5] == (byte) 10
				&& buffer[6] == (byte) 26 && buffer[7] == (byte) 10)) {
			return ImageType.PNG;
		}

		return ImageType.JPG;
	}
	
	/**  
     * 图像切割
     * @param x                       目标切片起点x坐标 
     * @param y                      目标切片起点y坐标 
     * @param destWidth              目标切片宽度 
     * @param destHeight             目标切片高度 
     */  
    public ImageUtil abscut(int x, int y, int destWidth, int destHeight) {  
		int srcWidth = image.getWidth(); // 源图宽度
		int srcHeight = image.getHeight(); // 源图高度
		
		if (srcWidth >= destWidth && srcHeight >= destHeight) {
			Image dest = image.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
			// 四个参数分别为图像起点坐标和宽高
			ImageFilter cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
			Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(dest.getSource(), cropFilter));
			BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			
			Graphics g = tag.getGraphics();
			g.drawImage(img, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			image = tag;
		}
		
		return this;
    }
	
    /**
     * 把图片写入到文件
     * @author clq
     * @date 2015年4月30日
     * @param formatName 图片格式
     * @param output 目标文件
     * @throws IOException
     */
	public void transferTo(String formatName, File output) throws IOException {
		output.getParentFile().mkdirs();
		ImageIO.write(image, formatName, output);
	}
	
	/**
	 * 把图片写入到输出流,这个方法不会关闭流
	 * @author clq
	 * @date 2015年4月30日
	 * @param formatName 图片格式
	 * @param output 目标流
	 * @throws IOException
	 */
	public void transferTo(String formatName, OutputStream output) throws IOException {
		ImageIO.write(image, formatName, output);
	}
	
	/**
	 * 把图片写入到输出到ImageOutputStream,这个方法不会关闭流
	 * @author clq
	 * @date 2015年4月30日
	 * @param formatName 图片格式
	 * @param output 目标流
	 * @throws IOException
	 */
	public void transferTo(String formatName, ImageOutputStream output) throws IOException {
		ImageIO.write(image, formatName, output);
	}
	
	
	public static void main(String[] args) throws IOException{
		ImageUtil base64 = ImageUtil.read("F:\\201606151921\\C.jpg");
		System.out.println(base64);
		/*String img = "D:/photo/ss.txt";
		try {
			FileInputStream in =new FileInputStream(img);
			byte[] byts = new byte[in.available()];
			in.read(byts);
			in.close();
			System.out.println(new String(byts));
			ImageType imgType = ImageType.JPEG;
			
				ImageUtil.read(new String(byts)).transferTo(imgType.getType(), new File("D:/photo/ssss.jpg"));;
			} catch (IOException e) {
				e.printStackTrace();
			}*/
	}
}
