package lab1.config;


import lab1.dao.QuestionnaireCSVDao;
import lab1.dao.QuestionnaireDao;
import lab1.dao.StudentConsoleDao;
import lab1.dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class DaoConfig {

    @Bean
    public StudentDao studentDao() { return new StudentConsoleDao(); }

    @Bean
    public QuestionnaireDao questionnaireDao() { return new QuestionnaireCSVDao(); }


}
