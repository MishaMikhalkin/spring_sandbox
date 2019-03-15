package lab1.config;


import lab1.dao.QuestionnaireCSVDao;
import lab1.dao.QuestionnaireDao;
import lab1.dao.StudentConsoleDao;
import lab1.dao.StudentDao;
import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class DaoConfig {

    @Value("${questionFilePrefix}") public String questionFilePrefix;
    @Value("${answerFilePrefix}")  public String  answerFilePrefix;
    @Value("${fileNameFormat}")  public String  fileNameForma;
    @Bean
    public StudentDao studentDao(ConsoleUtil consoleUtil) { return new StudentConsoleDao(consoleUtil); }

    @Bean
    public QuestionnaireDao questionnaireDao(AppLanguage appLanguage, ConsoleUtil consoleUtil) {
        return new QuestionnaireCSVDao(questionFilePrefix, answerFilePrefix, fileNameForma,
                appLanguage, consoleUtil); }


}
