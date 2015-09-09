package ca.tbrown.ilovemarshmallow.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.adapters.ResultAdapter;
import ca.tbrown.ilovemarshmallow.api.ZapposAPI;
import ca.tbrown.ilovemarshmallow.pojo.Response;
import ca.tbrown.ilovemarshmallow.pojo.Result;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class SearchResultsActivity extends BaseActivity {

    // UI
    private Toolbar toolbar;
    private SearchView searchbox;
    private RecyclerView rvResults;

    // Business Logic
    private String searchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        searchQuery = getSearchQuery();
        setupToolbar();
        setupRecyclerView();
        searchForProducts(searchQuery);
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void setupRecyclerView() {
        rvResults = (RecyclerView) findViewById(R.id.rvResults);
        rvResults.setHasFixedSize(true);
        rvResults.setLayoutManager(new LinearLayoutManager(activityContext));
    }

    private String getSearchQuery() {
        String query = "";
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
        }
        return query;
    }

    private void searchForProducts(String query) {

        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .build();

        ZapposAPI api = retrofit.create(ZapposAPI.class);

        api.searchZappos(query, new Callback<Response>() {
            @Override
            public void success(Response apiResponse, retrofit.client.Response response) {
                ResultAdapter adapter = new ResultAdapter(apiResponse.getResults());
                rvResults.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_results, menu);
        searchbox = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchbox.setIconifiedByDefault(false);
        searchbox.requestFocus();
        searchbox.setQuery(searchQuery,false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
