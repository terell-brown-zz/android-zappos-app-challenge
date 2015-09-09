package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private Integer totalResults;

    private List<Result> results = new ArrayList<Result>();

    private Refinements refinements;

    /**
     * @return The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults The totalResults
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * @return The refinements
     */
    public Refinements getRefinements() {
        return refinements;
    }

    /**
     * @param refinements The refinements
     */
    public void setRefinements(Refinements refinements) {
        this.refinements = refinements;
    }

}


