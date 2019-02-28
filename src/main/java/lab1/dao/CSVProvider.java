package lab1.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lab1.App;
import lab1.domain.AnswerItem;
import lab1.domain.QuestionItem;
import lab1.domain.Questionnaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVProvider implements QuestionnaireDao {

    @Override
    public Questionnaire findByName(String name) throws Exception {
        ClassLoader classLoader = new App().getClass().getClassLoader();
        File questionFile = new File(classLoader.getResource(name+"-questions.csv").getFile());
        File answerFile = new File(classLoader.getResource(name+"-answers.csv").getFile());

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
