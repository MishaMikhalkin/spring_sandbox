package lab1.runner;

import lab1.config.DaoConfig;
import lab1.config.ServiceConfig;
import lab1.domain.Result;
import lab1.service.QuestionnaireService;
import lab1.service.ScoringService;
import lab1.service.StudentService;
import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.Assert.*;

@TestPropertySource("/test.properties")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RunnerServiceImplTest.ConsoleUtilConfiguration.class, ServiceConfig.class, DaoConfig.class})
public class RunnerServiceImplTest {
    @Configuration
    static class ConsoleUtilConfiguration {

        @Bean
        public MessageSource applicationProperties() {
            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
            messageSource.setDefaultEncoding("UTF-8");
            return messageSource;
        }

        @Bean
        @Primary
        public AppLanguage locale() {
            return new AppLanguage("en");
        }

        @Bean
        @Primary
        public ConsoleUtil consoleUtil() {
            return Mockito.mock(ConsoleUtil.class);
        }

    }

    @Autowired
    ConsoleUtil consoleUtil;

    @Autowired
    StudentService studentService;
    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    ScoringService scoringService;

    private RunnerService runnerService;


    @BeforeEach
    public void init() {
        Mockito.when(consoleUtil.readString()).thenReturn("2").thenReturn("3");
        Mockito.when(consoleUtil.readInt()).thenReturn(1).thenReturn(1);
        runnerService = new RunnerServiceImpl(studentService, questionnaireService, scoringService, consoleUtil);
    }


    @Test
    public void makeInquirer() throws Exception {
        try {
            Result result = runnerService.makeInquirer("name");
            assertTrue(result.getAnswers().size() == 2);
        } catch (Exception e) {
            throw e;
        }

    }

    @Test
    public void calculateScore() throws Exception {
        try {
            Result result = runnerService.makeInquirer("name");
            result = runnerService.calculateScore(result);
            assertTrue(result.getScore().equals("A"));
        } catch (Exception e) {
            throw e;
        }

    }

}
