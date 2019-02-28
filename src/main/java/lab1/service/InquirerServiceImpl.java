package lab1.service;

import lab1.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InquirerServiceImpl implements InquirerService {
    @Override
    public Result makeInquirer(Student student, Questionnaire questionnaire) {
        Scanner sc = new Scanner(System.in);

        Result result = new Result();
        result.setStudent(student);
        result.setQuestionnaire(questionnaire);
        QuestionItem questionItem;
        float resultSum = 0;
        List<AnswerItem> answerItems = new ArrayList<>();
        for (int i = 0;  i < questionnaire.getQuestionItemList().size(); i++) {
            questionItem = questionnaire.getQuestionItemList().get(i);
            System.out.println("Вопрос " + i + " из " + questionnaire.getQuestionItemList().size() + ": " + questionItem.getQuestion());
            for (int j = 0; j<questionItem.getAnswerItems().size();j++) {
                System.out.println("  Ответ " + j + ": " + questionItem.getAnswerItems().get(j).getAnswer());
            }
            System.out.println("Введите номер ответа:");
            //TODO check input (for int and for value)
            int ans = sc.nextInt();
            answerItems.add(questionItem.getAnswerItems().get(ans));
            resultSum = resultSum + ans;
        }
        result.setResult(resultSum);
        result.setAnswers(answerItems);

        return result;
    }
}
