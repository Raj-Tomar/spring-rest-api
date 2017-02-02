package com.raj.app.configuration;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyUtilConfigurer extends PropertyPlaceholderConfigurer {

	private String propertiesfileName;
	private final String APP_HOME = "APP_HOME";

	private Properties appProperties = new Properties();

	private final String PROPERTIES_FILE = File.separator;// + "APP_HOME" + File.separator;

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	public String fetchApplicationHomePath() {
		String ucm_home_path = System.getProperty(APP_HOME);
		if (ucm_home_path == null) {
			logger.info("Not able to get system property " + APP_HOME + ". Trying to get from system environment.");
			ucm_home_path = System.getenv(APP_HOME);
		}
		if (ucm_home_path == null) {
			throw new RuntimeException(
					"UCM/Request-Dumper Home system/envrionment property is not sepecified as a JVM arg; use the: ["
							+ APP_HOME + "] "
							+ "to define it. E.g., -APP_HOME=/home/APP_HOME or set as environment variable.");
		} else {
			return ucm_home_path;
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String propertiesFilePath = null;
		try {
			String ucm_home = fetchApplicationHomePath();
			propertiesFilePath = ucm_home + PROPERTIES_FILE + getFileName();
			logger.info("Reading properties file: " + propertiesFilePath);

			appProperties.load(new FileInputStream(propertiesFilePath));

			setProperties(appProperties);
		} catch (IOException ex) {
			logger.error("Unable to read properties file at " + propertiesFilePath);
		}
		super.postProcessBeanFactory(beanFactory);
	}

	@Override
	protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
	}

	public void setFileName(String fileName) {
		this.propertiesfileName = fileName;
	}

	public String getFileName() {
		return propertiesfileName;
	}

}
