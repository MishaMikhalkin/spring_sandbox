package lab1.dao;

import lab1.domain.Questionnaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireCSVDaoTest {

    @Test
    void findByName() {
        QuestionnaireCSVDao questionnaireCsvDao = new QuestionnaireCSVDao();
        try {
            Questionnaire questionnaire = questionnaireCsvDao.findByName("name");

            assertTrue(questionnaire.getQuestionItemList().size() == 2);
            assertTrue(questionnaire.getName().equals("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}