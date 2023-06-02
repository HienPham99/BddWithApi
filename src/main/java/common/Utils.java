package common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
	/**
	 * This is a class which contain all common handlings related to selenium
	 * Including: read/write files: csv, json,Excel, word....; capture evidences;....
	 * 
	 */
	
	//Cắt chuỗi từ 1 ký tự nào đó bất kỳ đến cuối String
	public static String getSubStringFromCharacter(String originalStr, String fromCharacter) {
		int startIndex = originalStr.indexOf(":") + 1; //get text lấy dấu 2 chấm (:)
		//int endIndex = fullText.length() - 1 ;//get text cuối cùng
		String result = originalStr.substring(startIndex);
		return result;
		
	}
	//Load config file
	public static Properties loadConfigFile(String configFileName) {
		Properties prop=new Properties();
		try (InputStream fis = new FileInputStream("src/main/resources/" + configFileName)){
			prop.load(fis);
		}
		catch (Exception e) {
			System.out.println();
			e.printStackTrace();				
		}
		return prop;
	}
	
}
