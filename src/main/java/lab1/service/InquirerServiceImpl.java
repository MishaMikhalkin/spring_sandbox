package lab1.service;

import lab1.domain.*;
import lab1.util.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InquirerServiceImpl implements InquirerService {
    @Override
    public Result makeInquirer(Student student, Questionnaire questionnaire) {

        Result result = new Result();
        result.setStudent(student);
        result.setQuestionnaire(questionnaire);
        QuestionItem questionItem;
        float resultSum = 0;
        List<AnswerItem> answerItems = new ArrayList<>();
        for (int i = 0;  i < questionnaire.getQuestionItemList().size(); i++) {
            questionItem = questionnaire.getQuestionItemList().get(i);
            ConsoleUtil.printLocalizedString("insertquestion",
                    new String[] {Integer.toString(i),
                            Integer.toString(questionnaire.getQuestionItemList().size()),
                            questionItem.getQuestion()});

            for (int j = 0; j<questionItem.getAnswerItems().size();j++) {
                ConsoleUtil.printLocalizedString("insertpropanswer", new String[] {
                        Integer.toString(j),
                        questionItem.getAnswerItems().get(j).getAnswer()
                });
            }
            ConsoleUtil.printLocalizedString("insertanwser",null);
            //TODO check input (for int and for value)

            int ans =  ConsoleUtil.readInt();
            answerItems.add(questionItem.getAnswerItems().get(ans));
            resultSum = resultSum + ans;
        }
        result.setResult(resultSum);
        result.setAnswers(answerItems);

        return result;
    }
}
