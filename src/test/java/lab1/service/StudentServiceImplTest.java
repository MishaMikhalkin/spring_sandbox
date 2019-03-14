package lab1.service;

import lab1.dao.StudentConsoleDao;
import lab1.dao.StudentDao;
import lab1.domain.Student;
import org.junit.Test;
import org.mockito.Mockito;


public class StudentServiceImplTest {

    @Test
    public void register() {
        Student compare = new Student("firstname", "lastname");
        StudentDao studentMockDao = Mockito.mock(StudentConsoleDao.class);
        Mockito.when(studentMockDao.load()).thenReturn(compare);
        StudentService studentService = new StudentServiceImpl(studentMockDao);
        Student student = studentService.register();
        assert(student.equals(compare));
    }
}