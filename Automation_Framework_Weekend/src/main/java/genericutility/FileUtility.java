package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author SonuPrasaad
 */
public class FileUtility {
	/**
	 * This method is used to read data from property file and return the value based on the key.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/commondata.properties");
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}
}
