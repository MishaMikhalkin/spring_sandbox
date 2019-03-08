package lab1.service;

import lab1.domain.*;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InquirerServiceImpl implements InquirerService {
    @Autowired
    private ConsoleUtil consoleUtil;

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
            consoleUtil.printLocalizedString("insertquestion",
                    new String[] {Integer.toString(i),
                            Integer.toString(questionnaire.getQuestionItemList().size()),
                            questionItem.getQuestion()});

            for (int j = 0; j<questionItem.getAnswerItems().size();j++) {
                consoleUtil.printLocalizedString("insertpropanswer", new String[] {
                        Integer.toString(j),
                        questionItem.getAnswerItems().get(j).getAnswer()
                });
            }
            consoleUtil.printLocalizedString("insertanwser",null);
            //TODO check input (for int and for value)

            int ans =  consoleUtil.readInt();
            answerItems.add(questionItem.getAnswerItems().get(ans));
            resultSum = resultSum + ans;
        }
        result.setResult(resultSum);
        result.setAnswers(answerItems);

        return result;
    }
}
