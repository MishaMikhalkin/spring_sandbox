package lab1.dao;

import lab1.domain.Student;
import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentConsoleDaoTest {

    @Configuration
    static class ConsoleUtilConfiguration {
        @Bean
        public ConsoleUtil consoleUtil() {
            return Mockito.mock(ConsoleUtil.class);
        }

    }

    @Autowired
    ConsoleUtil consoleUtil;

    @Test
    public void load() {
        Mockito.when(consoleUtil.readString()).thenReturn("name").thenReturn("lastname");
        StudentDao studentDao = new StudentConsoleDao(consoleUtil);

        Student student = studentDao.load();
        assert(student.getFirstName().equals("name"));
        assert(student.getLastName().equals("lastname"));
    }
}