package lab1.dao;

import lab1.domain.Student;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentConsoleDao implements StudentDao {
    private ConsoleUtil consoleUtil;


    @Autowired
    public StudentConsoleDao(ConsoleUtil consoleUtil) {
        this.consoleUtil = consoleUtil;
    }

    @Override
    public Student load() {
        consoleUtil.printLocalizedString("insertfn", null);
        String firstName = consoleUtil.readString();
        consoleUtil.printLocalizedString("insertln", null);
        String lastName = consoleUtil.readString();

        return new Student(firstName, lastName);
    }


}
