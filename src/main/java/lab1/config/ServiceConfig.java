package lab1.config;

import lab1.dao.QuestionnaireCSVDao;
import lab1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class ServiceConfig {
    @Autowired DaoConfig daoConfig;

    @Bean
    public StudentService studentService() { return new StudentServiceImpl(daoConfig.studentDao()); }

    @Bean
    public QuestionnaireService questionnaireService() { return  new QuestionnaireServiceImpl(daoConfig.questionnaireDao()); }

    @Bean
    public InquirerService inquirerService() {return  new InquirerServiceImpl(); }

    @Bean
    public  ScoringService scoringService() { return  new ScoringServiceImpl(); }

}
