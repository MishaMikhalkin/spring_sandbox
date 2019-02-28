package lab1.domain;


import java.util.List;

public class Result {
    private Student student;

    private Questionnaire questionnaire;

    private List<AnswerItem> answers;

    private float result;

    public Student getStudent() {
        return student;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public List<AnswerItem> getAnswers() {
        return answers;
    }

    public float getResult() {
        return result;
    }

    public void setAnswers(List<AnswerItem> answers) {
        this.answers = answers;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
