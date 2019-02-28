package lab1.domain;


import java.util.List;

public class Questionnaire {

    private final String name;

    private final List<QuestionItem> questionItemList;


    public Questionnaire(String name, List<QuestionItem> questionItemList) {
        this.name = name;
        this.questionItemList = questionItemList;
    }

    public String getName() {
        return name;
    }

    public List<QuestionItem> getQuestionItemList() {
        return questionItemList;
    }
}
