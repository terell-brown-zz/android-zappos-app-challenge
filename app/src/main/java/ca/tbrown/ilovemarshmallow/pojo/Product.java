
package ca.tbrown.ilovemarshmallow.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;


public class Product {


    private String brandName;
    private String description;
    private String asin;
    private Object genders;
    private String defaultProductType;
    private String productName;
    private String defaultImageUrl;
    private List<Object> childAsins = new ArrayList<Object>();

    /**
     *
     * @return
     * The brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     *
     * @param brandName
     * The brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
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
    public String getDefaultProductType() {
        return defaultProductType;
    }

    /**
     *
     * @param defaultProductType
     * The defaultProductType
     */
    public void setDefaultProductType(String defaultProductType) {
        this.defaultProductType = defaultProductType;
    }

    /**
     *
     * @return
     * The productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     * The productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return
     * The defaultImageUrl
     */
    public String getDefaultImageUrl() {
        return defaultImageUrl;
    }

    /**
     *
     * @param defaultImageUrl
     * The defaultImageUrl
     */
    public void setDefaultImageUrl(String defaultImageUrl) {
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