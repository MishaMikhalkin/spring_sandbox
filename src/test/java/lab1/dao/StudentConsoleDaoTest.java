package lab1.dao;

import lab1.domain.Student;
import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class StudentConsoleDaoTest {

    @Configuration
    static class ConsoleUtilConfuguration {

        @Bean MessageSource messageSource () {
            return Mockito.mock(MessageSource.class);
        }

        @Bean AppLanguage language() {
            return new AppLanguage("ru");
        }

        @Bean
        public ConsoleUtil consoleUtil() {
            return Mockito.spy(new ConsoleUtil(language(), messageSource()));
        }

    }

    @Autowired
    ConsoleUtil consoleUtil;

    @Test
    public void load() {
        Mockito.when(consoleUtil.readString()).thenReturn("name").thenReturn("lastname");
        StudentDao studentDao = new StudentConsoleDao(consoleUtil);

        Student student = studentDao.load();
        assertTrue(student.getFirstName().equals("name"));
        assertTrue(student.getLastName().equals("lastname"));
    }
}