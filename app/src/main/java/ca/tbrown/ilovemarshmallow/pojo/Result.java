package ca.tbrown.ilovemarshmallow.pojo;

/**
 * Created by tmast_000 on 9/8/2015.
 */

public class Result {


    private String brandName;

    private Object originalPrice;

    private String price;

    private String imageUrl;

    private String asin;

    private String productUrl;

    private Double productRating;

    private Object map;

    private String productName;

    public Result(String brandName, Object originalPrice, String price, String imageUrl, String asin, String productUrl, Double productRating, Object map, String productName) {
        this.brandName = brandName;
        this.originalPrice = originalPrice;
        this.price = price;
        this.imageUrl = imageUrl;
        this.asin = asin;
        this.productUrl = productUrl;
        this.productRating = productRating;
        this.map = map;
        this.productName = productName;
    }


    /**
     * @return The brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName The brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return The originalPrice
     */
    public Object getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice The originalPrice
     */
    public void setOriginalPrice(Object originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * @return The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return The asin
     */
    public String getAsin() {
        return asin;
    }

    /**
     * @param asin The asin
     */
    public void setAsin(String asin) {
        this.asin = asin;
    }

    /**
     * @return The productUrl
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     * @param productUrl The productUrl
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    /**
     * @return The productRating
     */
    public Double getProductRating() {
        return productRating;
    }

    /**
     * @param productRating The productRating
     */
    public void setProductRating(Double productRating) {
        this.productRating = productRating;
    }

    /**
     * @return The map
     */
    public Object getMap() {
        return map;
    }

    /**
     * @param map The map
     */
    public void setMap(Object map) {
        this.map = map;
    }

    /**
     * @return The productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName The productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

}
