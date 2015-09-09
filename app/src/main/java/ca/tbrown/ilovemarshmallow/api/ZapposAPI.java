package ca.tbrown.ilovemarshmallow.api;

import ca.tbrown.ilovemarshmallow.pojo.Asin;
import ca.tbrown.ilovemarshmallow.pojo.Response;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


public interface ZapposAPI {

    @GET("/mobileapi/v1/search")
    void searchZappos(@Query("term") String query, Callback<Response> responseCallback);

    @GET("https://zappos.amazon.com/mobileapi/v1/product/asin/{asin}")
    Asin searchByAsin(@Path("asin") String asin);
}
