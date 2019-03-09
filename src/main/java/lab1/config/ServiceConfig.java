package lab1.config;

import lab1.runner.RunnerService;
import lab1.runner.RunnerServiceImpl;
import lab1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class ServiceConfig {
    @Autowired DaoConfig daoConfig;

    @Autowired GenericConfig genericConfig;

    @Bean
    public StudentService studentService() { return new StudentServiceImpl(daoConfig.studentDao()); }

    @Bean
    public QuestionnaireService questionnaireService() { return  new QuestionnaireServiceImpl(daoConfig.questionnaireDao()); }

    @Bean
    public RunnerService inquirerService() { return  new RunnerServiceImpl(studentService(), questionnaireService(), scoringService(),
            genericConfig.consoleUtil()); }

    @Bean
    public  ScoringService scoringService() { return  new ScoringServiceImpl(); }

}
