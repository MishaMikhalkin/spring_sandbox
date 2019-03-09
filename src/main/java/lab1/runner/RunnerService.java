package lab1.runner;

import lab1.domain.Result;

public interface RunnerService {
    public Result makeInquirer(String questionnaireName) throws Exception;
}
