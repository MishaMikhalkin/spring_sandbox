package lab1.service;

import lab1.dao.StudentDao;
import lab1.domain.Student;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student register() {
        return studentDao.load();
    }
}
