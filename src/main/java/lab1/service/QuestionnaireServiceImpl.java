package lab1.service;

import lab1.dao.CSVProvider;
import lab1.domain.Questionnaire;

public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final CSVProvider csvProvider;

    public QuestionnaireServiceImpl(CSVProvider provider) {
        csvProvider = provider;
    }


    @Override
    public Questionnaire findByName(String name) throws Exception{
        try {
            return csvProvider.findByName(name);
        } catch (Exception e) {
            throw e;
        }
    }
}
