package ca.tbrown.ilovemarshmallow.api;


import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.api.ZapposAPI;import retrofit.RestAdapter;

public class Zappos {
    // Singleton for the Zappos API

    private static ZapposAPI api;

    public static ZapposAPI getAPI() {
        if (api == null) {
            RestAdapter retrofit = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .build();
            api = retrofit.create(ZapposAPI.class);
        }

        return api;
    }
}
