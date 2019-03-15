package lab1.service;

import lab1.dao.StudentDao;
import lab1.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

public interface StudentService {

    Student register();

}
