package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmast_000 on 9/8/2015.
 */

public class Filter {


    private Object group;

    private Boolean removesSiblings;

    private Object detail;

    private String label;

    private Object clearLink;

    private Object ancestry;

    private List<Value> values = new ArrayList<Value>();

    private String type;

    private String id;

    /**
     * @return The group
     */
    public Object getGroup() {
        return group;
    }

    /**
     * @param group The group
     */
    public void setGroup(Object group) {
        this.group = group;
    }

    /**
     * @return The removesSiblings
     */
    public Boolean getRemovesSiblings() {
        return removesSiblings;
    }

    /**
     * @param removesSiblings The removesSiblings
     */
    public void setRemovesSiblings(Boolean removesSiblings) {
        this.removesSiblings = removesSiblings;
    }

    /**
     * @return The detail
     */
    public Object getDetail() {
        return detail;
    }

    /**
     * @param detail The detail
     */
    public void setDetail(Object detail) {
        this.detail = detail;
    }

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return The clearLink
     */
    public Object getClearLink() {
        return clearLink;
    }

    /**
     * @param clearLink The clearLink
     */
    public void setClearLink(Object clearLink) {
        this.clearLink = clearLink;
    }

    /**
     * @return The ancestry
     */
    public Object getAncestry() {
        return ancestry;
    }

    /**
     * @param ancestry The ancestry
     */
    public void setAncestry(Object ancestry) {
        this.ancestry = ancestry;
    }

    /**
     * @return The values
     */
    public List<Value> getValues() {
        return values;
    }

    /**
     * @param values The values
     */
    public void setValues(List<Value> values) {
        this.values = values;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
