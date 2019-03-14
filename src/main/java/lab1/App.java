/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab1;

import lab1.config.DaoConfig;
import lab1.config.GenericConfig;
import lab1.config.ServiceConfig;
import lab1.domain.Result;
import lab1.runner.RunnerService;
import lab1.util.ConsoleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Console;


@Configuration
@ComponentScan
@PropertySource("classpath:message.properties")

public class App {


    final static Logger logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);


        logger.info("logger app");
        RunnerService inquirerService = context.getBean(RunnerService.class);
        ConsoleUtil consoleUtil = context.getBean(ConsoleUtil.class);

        try {
            Result result = inquirerService.makeInquirer("name");
            inquirerService.printResult(result);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

    }
}
