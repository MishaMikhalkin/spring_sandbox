package lab1.service;

import lab1.domain.Result;

public class ScoringServiceImpl implements ScoringService {


    @Override
    public char evaluate(Result result) {

         double score = result.getResult() / result.getAnswers().size() ;

        if (score >= 0.9) {
            return 'A';
        } else if (score >= 0.8) {
            return 'B';
        } else if (score >= 0.7) {
            return 'C';
        } else {
            return 'D';
        }
    }
}
