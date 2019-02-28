package lab1.domain;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;


public class AnswerItem {
    @CsvBindByPosition(position = 0)
    private  int ida;
    @CsvBindByPosition(position = 1)
    private  int idq;
    @CsvBindByPosition(position = 2)
    private  String answer;
    @CsvBindByPosition(position = 3)
    private  float weight;

    public AnswerItem() {}

    public AnswerItem(int ida, int idq, String answer, float weight) {
        this.ida = ida;
        this.idq = idq;
        this.answer = answer;
        this.weight = weight;
    }


    public int getIda() {
        return ida;
    }

    public int getIdq() {
        return idq;
    }

    public String getAnswer() {
        return answer;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerItem that = (AnswerItem) o;
        return ida == that.ida &&
                idq == that.idq &&
                Float.compare(that.weight, weight) == 0 &&
                answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ida, idq, answer, weight);
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public void setIdq(int idq) {
        this.idq = idq;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
