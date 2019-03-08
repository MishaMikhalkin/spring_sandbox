package lab1.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lab1.domain.AnswerItem;
import lab1.domain.QuestionItem;
import lab1.domain.Questionnaire;
import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionnaireCSVDao implements QuestionnaireDao {

    @Autowired
    private AppLanguage appLanguage;

    @Override
    public Questionnaire findByName(String name) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();

        String questionsLocalizedFile = ConsoleUtil.getLocalizedString("questions", new String[]{name});
        File questionFile = new File(classLoader.getResource(questionsLocalizedFile).getFile());

        String answerLocalizedFile = ConsoleUtil.getLocalizedString("answers", new String[]{name});
        File answerFile = new File(classLoader.getResource(answerLocalizedFile).getFile());

        try (FileReader questionReader = new FileReader(questionFile)) {
            try (FileReader answerReader = new FileReader(answerFile)) {

                List<QuestionItem> questionItems = new CsvToBeanBuilder(questionReader).withType(QuestionItem.class).build().parse();
                List<AnswerItem> answerItems = new CsvToBeanBuilder(answerReader).withType(AnswerItem.class).build().parse();
                for (QuestionItem questionItem : questionItems) {
                    questionItem.setAnswerItems(answerItems.stream().filter(a -> a.getIdq() == questionItem.getQid()).collect(Collectors.toList()));
                }

                return new Questionnaire(name, questionItems);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found " + name);
        } catch (IOException e) {
            throw new IOException("File IOException " + name);
        }
    }
}
