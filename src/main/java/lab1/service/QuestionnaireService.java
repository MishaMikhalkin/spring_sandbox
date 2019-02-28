package lab1.service;

import lab1.domain.Questionnaire;

public interface QuestionnaireService {

    Questionnaire findByName(String name) throws Exception;
}
