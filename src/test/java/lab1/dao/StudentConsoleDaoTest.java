package lab1.dao;

import lab1.config.GenericConfig;
import lab1.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GenericConfig.class})
class StudentConsoleDaoTest {

    @Spy GenericConfig genericConfig;

    @Test
    void load() {
        Mockito.when(genericConfig.consoleUtil().readString()).thenReturn("name").thenReturn("lastname");
        StudentDao studentDao = new StudentConsoleDao(genericConfig.consoleUtil());

        Student student = studentDao.load();
        assertTrue(student.getFirstName().equals("name"));
        assertTrue(student.getLastName().equals("lastname"));
    }
}