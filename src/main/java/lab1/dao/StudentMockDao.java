package lab1.dao;

import lab1.domain.Student;

public class StudentMockDao implements StudentDao {
    private final Student student;

    public StudentMockDao(Student mock) {
        student = mock;
    }

    @Override
    public Student load() {
        return student;
    }
}
