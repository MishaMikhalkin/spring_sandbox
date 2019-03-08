package lab1.dao;

import lab1.domain.Student;
import lab1.util.ConsoleUtil;

public class StudentConsoleDao implements StudentDao {

    @Override
    public Student load() {
        ConsoleUtil.printLocalizedString("insertfn", null);
        String firstName = ConsoleUtil.readString();
        ConsoleUtil.printLocalizedString("insertln", null);
        String lastName = ConsoleUtil.readString();

        return new Student(firstName, lastName);
    }


}
