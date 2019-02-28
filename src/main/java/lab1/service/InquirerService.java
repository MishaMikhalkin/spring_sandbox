package lab1.service;

import lab1.domain.Questionnaire;
import lab1.domain.Result;
import lab1.domain.Student;

public interface InquirerService {
    public Result makeInquirer(Student student, Questionnaire questionnaire);
}
