package lab1.service;

import lab1.dao.StudentMockDao;
import lab1.domain.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @Test
    void register() {
        Student compare = new Student("firstname", "lastname");
        StudentMockDao studentMockDao = new StudentMockDao(compare);
        StudentServiceImpl studentService = new StudentServiceImpl(studentMockDao);
        Student student = studentService.register();
        assertTrue(student.equals(compare));
    }
}