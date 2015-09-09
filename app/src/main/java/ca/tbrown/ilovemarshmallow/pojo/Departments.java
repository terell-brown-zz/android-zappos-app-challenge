package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmast_000 on 9/8/2015.
 */

public class Departments {


    private Object allLink;

    private List<Ancestry> ancestry = new ArrayList<Ancestry>();

    private List<Category> categories = new ArrayList<Category>();

    /**
     * @return The allLink
     */
    public Object getAllLink() {
        return allLink;
    }

    /**
     * @param allLink The allLink
     */
    public void setAllLink(Object allLink) {
        this.allLink = allLink;
    }

    /**
     * @return The ancestry
     */
    public List<Ancestry> getAncestry() {
        return ancestry;
    }

    /**
     * @param ancestry The ancestry
     */
    public void setAncestry(List<Ancestry> ancestry) {
        this.ancestry = ancestry;
    }

    /**
     * @return The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
