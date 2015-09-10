package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

public class Response extends BaseResponse {

    private Integer totalResults;

    private ArrayList<Result> results = new ArrayList<Result>();

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
    public ArrayList<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(ArrayList<Result> results) {
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

