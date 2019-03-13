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
    @Value("${questionare}")
    public String questionareName;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public AppLanguage locale() {
        return new AppLanguage("en");
    }

    @Bean
    public ConsoleUtil consoleUtil() {
        return  new ConsoleUtil(locale(), messageSource());
    }

}
