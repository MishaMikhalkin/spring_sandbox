package lab1.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lab1.domain.AnswerItem;
import lab1.domain.QuestionItem;
import lab1.domain.Questionnaire;
import lab1.util.AppLanguage;
import lab1.util.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionnaireCSVDao implements QuestionnaireDao {

    private ConsoleUtil consoleUtil;

    private AppLanguage appLanguage;

    private String questionFilePrefix;
    private String answerFilePrefix;
    private String fileNameFormat;

    @Autowired
    public QuestionnaireCSVDao(@Value("${questionFilePrefix}") String questionFilePrefix,
                               @Value("${answerFilePrefix}") String answerFilePrefix,
                               @Value("${fileNameFormat}") String fileNameFormat,
                               AppLanguage appLanguage, ConsoleUtil consoleUtil) {
        this.questionFilePrefix = questionFilePrefix;
        this.answerFilePrefix = answerFilePrefix;
        this.fileNameFormat = fileNameFormat;
        this.consoleUtil = consoleUtil;
        this.appLanguage = appLanguage;
    }

    @Override
    public Questionnaire findByName(String name) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();

        String questionsLocalizedFile = String.format(fileNameFormat, questionFilePrefix, appLanguage.toString());
        File questionFile = new File(classLoader.getResource(questionsLocalizedFile).getFile());

        String answerLocalizedFile = String.format(fileNameFormat, answerFilePrefix, appLanguage.toString());
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
