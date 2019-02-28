package lab1.domain;

import com.opencsv.bean.CsvBindByPosition;

import java.util.List;
import java.util.Objects;


public class QuestionItem {
    @CsvBindByPosition(position = 0)
    private int qid;

    @CsvBindByPosition(position = 1)
    private String question;

    private List<AnswerItem> answerItems;

    public QuestionItem() {}


    public QuestionItem(int qid, String question, List<AnswerItem> answerItems) {
        this.qid = qid;
        this.question = question;
        this.answerItems = answerItems;
    }

    public QuestionItem(int qid, String question) {
        this.qid = qid;
        this.question = question;
    }

    public int getQid() {
        return qid;
    }


    public String getQuestion() {
        return question;
    }


    public List<AnswerItem> getAnswerItems() {
        return answerItems;
    }

    public void setAnswerItems(List<AnswerItem> answerItems) {
        this.answerItems = answerItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionItem that = (QuestionItem) o;
        return qid == that.qid &&
                question.equals(that.question) &&
                answerItems.equals(that.answerItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qid, question, answerItems);
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
