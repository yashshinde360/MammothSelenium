package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties properties;

	public Properties init_prop() {
		FileInputStream input;
		properties = new Properties();
		try {
			input = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				properties.load(input);
			} catch (IOException e) {
				// to catch exception while loading data
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// to catch exception for config.properties file
			e.printStackTrace();
		}
		return properties;

	}

}
