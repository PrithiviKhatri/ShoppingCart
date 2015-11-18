package  mum.edu.shoppingcart.util;

import java.io.File;
import java.io.FileInputStream;


public class Utility {


	/**
	 * This method reads file from given path and converts into byte value.
	 */
	public static byte[] getImageFromPath(String path) {
		// save image into database
		File file = new File(path);
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}
}
