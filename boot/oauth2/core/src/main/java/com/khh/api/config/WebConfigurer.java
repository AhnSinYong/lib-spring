package com.khh.api.config;

import com.khh.api.config.properties.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Optional;

//거의 여기서 config할것이 거의 없다. WebMvcConfigurerAdapter 에서 할것이 많다.
@Configuration
public class WebConfigurer {
	@Value("#{'${spring.mvc.locale?:ko_KR}'}")
	Locale locale = null;
	@Value("#{'${spring.messages.basename?:classpath:/messages/message}'}")
	String messagesBasename = null;
	@Value("#{'${spring.messages.encoding?:UTF-8}'}")
	String messagesEncoding = null;
	@Value("#{'${spring.messages.cache-seconds?:-1}'}")
	int messagesCacheSeconds;
//	@Value("#{systemProperties['mongodb.port'] ?: 27017}")
//	private String mongodbPort;
//	@Value("#{config['mongodb.url'] ?: '127.0.0.1'}")
//	private String mongodbUrl;
//	@Value("#{aBean.age ?: 21}")
	private int age;
	@Autowired
	ProjectProperties projectProperties;

	//다국어 https://justinrodenbostel.com/2014/05/13/part-4-internationalization-in-spring-boot/
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(locale);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		if(null!=projectProperties && null!=projectProperties.getLocaleChange() && null!=projectProperties.getLocaleChange().getParamName()) {
			lci.setParamName(projectProperties.getLocaleChange().getParamName());
		}else{
			lci.setParamName("long");
		}
		return lci;
	}

	//message source
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(messagesBasename);                //"classpath:/messages/message"
		messageSource.setDefaultEncoding(messagesEncoding);
		messageSource.setCacheSeconds(messagesCacheSeconds);
		return messageSource;
	}

	@Bean
	public MessageSourceAccessor getMessageSourceAccessor(){
		ReloadableResourceBundleMessageSource m = messageSource();
		return new MessageSourceAccessor(m);
	}

}
