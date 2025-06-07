package genericutility;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author SonuPrasaad
 */
public class JavaUtility {
	/**
	 * This method is used to capture the current system date and time and replace : with -.
	 * @return
	 */
	public String getSystemTime()
	{
		 return LocalDateTime.now().toString().replace(":", "-");
	}
	
	/**
	 * This method is used to return random numbers within 1000.
	 * @return random numbers
	 */
	public int generateRandom()
	{
		Random num = new Random();
		return num.nextInt(1000);
	}
}
