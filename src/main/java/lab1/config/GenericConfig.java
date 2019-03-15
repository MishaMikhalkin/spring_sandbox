package lab1.config;

import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class GenericConfig {

    @Bean
    public MessageSource applicationProperties() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:application");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public AppLanguage locale(@Value("${language}") String language) {
        return new AppLanguage(language);
    }

    @Bean
    public ConsoleUtil consoleUtil(AppLanguage locale, MessageSource messageSource) {
        return  new ConsoleUtil(locale, messageSource);
    }

}
