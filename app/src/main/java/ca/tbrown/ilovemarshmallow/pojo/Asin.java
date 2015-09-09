
package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;


public class Asin {


    private Object brandName;
    private Object description;
    private String asin;
    private Object genders;
    private Object defaultProductType;
    private Object productName;
    private Object defaultImageUrl;
    private List<Object> childAsins = new ArrayList<Object>();

    /**
     *
     * @return
     * The brandName
     */
    public Object getBrandName() {
        return brandName;
    }

    /**
     *
     * @param brandName
     * The brandName
     */
    public void setBrandName(Object brandName) {
        this.brandName = brandName;
    }

    /**
     *
     * @return
     * The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The asin
     */
    public String getAsin() {
        return asin;
    }

    /**
     *
     * @param asin
     * The asin
     */
    public void setAsin(String asin) {
        this.asin = asin;
    }

    /**
     *
     * @return
     * The genders
     */
    public Object getGenders() {
        return genders;
    }

    /**
     *
     * @param genders
     * The genders
     */
    public void setGenders(Object genders) {
        this.genders = genders;
    }

    /**
     *
     * @return
     * The defaultProductType
     */
    public Object getDefaultProductType() {
        return defaultProductType;
    }

    /**
     *
     * @param defaultProductType
     * The defaultProductType
     */
    public void setDefaultProductType(Object defaultProductType) {
        this.defaultProductType = defaultProductType;
    }

    /**
     *
     * @return
     * The productName
     */
    public Object getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     * The productName
     */
    public void setProductName(Object productName) {
        this.productName = productName;
    }

    /**
     *
     * @return
     * The defaultImageUrl
     */
    public Object getDefaultImageUrl() {
        return defaultImageUrl;
    }

    /**
     *
     * @param defaultImageUrl
     * The defaultImageUrl
     */
    public void setDefaultImageUrl(Object defaultImageUrl) {
        this.defaultImageUrl = defaultImageUrl;
    }

    /**
     *
     * @return
     * The childAsins
     */
    public List<Object> getChildAsins() {
        return childAsins;
    }

    /**
     *
     * @param childAsins
     * The childAsins
     */
    public void setChildAsins(List<Object> childAsins) {
        this.childAsins = childAsins;
    }

}