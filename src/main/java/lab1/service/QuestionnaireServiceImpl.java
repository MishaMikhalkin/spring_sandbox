package lab1.service;

import lab1.dao.QuestionnaireDao;
import lab1.domain.Questionnaire;

public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDao questionnaireDao;

    public QuestionnaireServiceImpl(QuestionnaireDao provider) {
        questionnaireDao = provider;
    }


    @Override
    public Questionnaire findByName(String name) throws Exception{
        try {
            return questionnaireDao.findByName(name);
        } catch (Exception e) {
            throw e;
        }
    }
}
