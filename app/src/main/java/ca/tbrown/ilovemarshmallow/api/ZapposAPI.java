package ca.tbrown.ilovemarshmallow.api;

import ca.tbrown.ilovemarshmallow.pojo.Product;
import ca.tbrown.ilovemarshmallow.pojo.Response;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


public interface ZapposAPI {

    @GET("/mobileapi/v1/search")
    void searchProducts(
            @Query("term") String query,
            Callback<Response> responseCallback
    );

    @GET("/mobileapi/v1/product/asin/{asin}")
    void searchByAsin(
            @Path("asin") String asin,
            Callback<Product> productCallback
    );
}
