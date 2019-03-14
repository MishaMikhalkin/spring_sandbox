package lab1.config;

import lab1.dao.QuestionnaireDao;
import lab1.dao.StudentDao;
import lab1.domain.Questionnaire;
import lab1.runner.RunnerService;
import lab1.runner.RunnerServiceImpl;
import lab1.service.*;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class ServiceConfig {

    @Autowired StudentDao studentDao;

    @Autowired QuestionnaireDao questionnaireDao;

    @Autowired ConsoleUtil consoleUtil;


    @Bean
    public StudentService studentService() { return new StudentServiceImpl(studentDao); }

    @Bean
    public QuestionnaireService questionnaireService() { return  new QuestionnaireServiceImpl(questionnaireDao); }

    @Bean
    public RunnerService inquirerService() { return  new RunnerServiceImpl(studentService(), questionnaireService(), scoringService(),
            consoleUtil); }

    @Bean
    public  ScoringService scoringService() { return  new ScoringServiceImpl(); }

}
