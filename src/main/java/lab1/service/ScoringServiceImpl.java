package lab1.service;

import lab1.domain.Result;

public class ScoringServiceImpl implements ScoringService {


    @Override
    public Result evaluate(Result result) {

        double score = result.getResult() / result.getAnswers().size() ;

        String value = "D";
        if (score >= 0.9) {
            value = "A";
        } else if (score >= 0.8) {
            value = "B";
        } else if (score >= 0.7) {
            value = "C";
        }

        result.setScore(value);
        return result;
    }
}
