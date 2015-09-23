package ca.tbrown.ilovemarshmallow;

public class Constants {

    // API Endpoints
    public static final String BASE_URL = "https://zappos.amazon.com";
    public static final String ASIN_ENDPOINT = BASE_URL + "/mobileapi/v1/product/asin/";
    public static final String SEARCH_URL="/mobileapi/v1/search?";

    // URL Generation
    public static final String ASIN_SEARCH = "asin=";
    public static final String PRICE_SEARCH = "price=";
    public static final String RATING_SEARCH = "rating=";
    public static final String IMG_SEARCH = "img=";

    // URL Parsing
    public static final String PARSE_QUERY_TERM = "term";
    public static final String PARSE_QUERY_PRICE = "price";
    public static final String PARSE_QUERY_RATING = "rating";
    public static final String PARSE_IMG_URL = "img";
    public static final String PARSE_QUERY_ASIN = "asin";
    public static final String DOLLAR_SIGN = "%24";

    // Image Sizing
    public static final String SMALL_IMG = "AA160";
    public static final String MIDSIZE_IMG = "AA250";
    public static final String LARGE_IMG = "AA500";

    // Intent Extra Keys
    public static final String ASIN = "__ASIN__" ;
    public static final String QUERY = "__QUERY__";
    public static final String IMAGE = "__IMAGE__";
    public static final String RATING = "__RATING__";
    public static final String PRICE = "__PRICE__";
    public static final String SEARCH_RESULTS = "__SEARCH_RESULTS__";
    public static final String IMAGE_URL = "__IMAGE_URL__" ;
    public static final String DESCRIPTION = "__DESCRIPTION__";
    public static final String PRODUCT = "__PRODUCT__";
    public static final String PAGE = "__PAGE__";
    public static final String IS_BACK_NAV = "___BACK__";
    public static final String URI = "__URI__";

    // Product Sharing Message
    public static final String SHARE_MESSAGE = "Check out this product @ Zappos. com: ";

}
