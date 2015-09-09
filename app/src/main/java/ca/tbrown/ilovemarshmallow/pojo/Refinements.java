package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmast_000 on 9/8/2015.
*/
public class Refinements {


    private ClearAllLink clearAllLink;

    private List<String> prioritizedFilterIds = new ArrayList<String>();

    private Departments departments;

    private List<Filter> filters = new ArrayList<Filter>();

    /**
     * @return The clearAllLink
     */
    public ClearAllLink getClearAllLink() {
        return clearAllLink;
    }

    /**
     * @param clearAllLink The clearAllLink
     */
    public void setClearAllLink(ClearAllLink clearAllLink) {
        this.clearAllLink = clearAllLink;
    }

    /**
     * @return The prioritizedFilterIds
     */
    public List<String> getPrioritizedFilterIds() {
        return prioritizedFilterIds;
    }

    /**
     * @param prioritizedFilterIds The prioritizedFilterIds
     */
    public void setPrioritizedFilterIds(List<String> prioritizedFilterIds) {
        this.prioritizedFilterIds = prioritizedFilterIds;
    }

    /**
     * @return The departments
     */
    public Departments getDepartments() {
        return departments;
    }

    /**
     * @param departments The departments
     */
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    /**
     * @return The filters
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * @param filters The filters
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}
