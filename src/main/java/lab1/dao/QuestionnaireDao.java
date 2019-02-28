package lab1.dao;

import lab1.domain.Questionnaire;

public interface QuestionnaireDao {

    Questionnaire findByName(String name) throws Exception;

}
