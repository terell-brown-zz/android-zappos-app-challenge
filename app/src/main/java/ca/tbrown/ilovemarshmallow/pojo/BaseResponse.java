package ca.tbrown.ilovemarshmallow.pojo;


public class BaseResponse {


    private String id;

    private String description;

    private Integer statusCode = -1;

    private Object extraInformation;

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

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode The statusCode
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return The extraInformation
     */
    public Object getExtraInformation() {
        return extraInformation;
    }

    /**
     * @param extraInformation The extraInformation
     */
    public void setExtraInformation(Object extraInformation) {
        this.extraInformation = extraInformation;
    }

}
