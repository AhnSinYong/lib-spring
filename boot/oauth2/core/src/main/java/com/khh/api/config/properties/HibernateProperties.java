package com.khh.api.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@ConfigurationProperties(prefix = "hibernate")
@Component
@Data
public class HibernateProperties {

	String mappingLocations;
	String[] packagesToScan;
	String[] annotatedPackages;
	private Properties properties;
}
