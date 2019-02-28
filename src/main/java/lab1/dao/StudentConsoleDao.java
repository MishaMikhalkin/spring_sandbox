package lab1.dao;

import lab1.domain.Student;

import java.util.Scanner;

public class StudentConsoleDao implements StudentDao {

    @Override
    public Student load() {


        String firstName = null;
        String lastName = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя студента:");
        firstName = sc.nextLine();
        System.out.println("Введите фамилию студента:");
        lastName = sc.nextLine();


        return new Student(firstName, lastName);
    }


}
