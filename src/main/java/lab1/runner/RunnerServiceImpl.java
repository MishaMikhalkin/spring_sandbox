package lab1.runner;

import lab1.domain.*;
import lab1.service.QuestionnaireService;
import lab1.service.ScoringService;
import lab1.service.StudentService;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RunnerServiceImpl implements RunnerService {
    private StudentService studentService;
    private QuestionnaireService questionnaireService;
    private ConsoleUtil consoleUtil;

    private ScoringService scoringService;

    @Autowired
    public RunnerServiceImpl(StudentService studentService, QuestionnaireService questionnaireService,
                             ScoringService scoringService, ConsoleUtil consoleUtil) {
        this.studentService = studentService;
        this.questionnaireService = questionnaireService;
        this.consoleUtil = consoleUtil;
        this.scoringService = scoringService;
    }

    @Override
    public Result makeInquirer(String questionnaireName) throws Exception {
        Student student = studentService.register();
        Questionnaire questionnaire = questionnaireService.findByName(questionnaireName);
        Result result = new Result();
        result.setStudent(student);
        result.setQuestionnaire(questionnaire);
        QuestionItem questionItem;
        float resultSum = 0;
        List<AnswerItem> answerItems = new ArrayList<>();
        for (int i = 0; i < questionnaire.getQuestionItemList().size(); i++) {
            questionItem = questionnaire.getQuestionItemList().get(i);
            consoleUtil.printLocalizedString("insertquestion",
                    new String[]{Integer.toString(i),
                            Integer.toString(questionnaire.getQuestionItemList().size()),
                            questionItem.getQuestion()});

            for (int j = 0; j < questionItem.getAnswerItems().size(); j++) {
                consoleUtil.printLocalizedString("insertpropanswer", new String[]{
                        Integer.toString(j),
                        questionItem.getAnswerItems().get(j).getAnswer()
                });
            }
            consoleUtil.printLocalizedString("insertanwser", null);
            //TODO check input (for int and for value)

            int ans = consoleUtil.readInt();
            answerItems.add(questionItem.getAnswerItems().get(ans));
            resultSum = resultSum + ans;
        }
        result.setResult(resultSum);
        result.setAnswers(answerItems);

        String score = scoringService.evaluate(result);
        result.setScore(score);
        return result;
    }
}
