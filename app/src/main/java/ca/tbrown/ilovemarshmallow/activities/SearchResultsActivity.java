package ca.tbrown.ilovemarshmallow.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.adapters.ResultAdapter;
import ca.tbrown.ilovemarshmallow.api.Zappos;
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
    private LinearLayout activityLayout;

    // Business Logic
    private String searchQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);
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

    @Override
    protected void onNewIntent(Intent intent) {
        /*
        Necessary for activities with the launchMode="singleTop" attribute set in Manifest File.
        When there is a need to launch another instance of this activity, the current instance
        will be recycled and the onNewIntent method will be called to handle the intent used
        to launch the 'new instance
         */

        setIntent(intent);
        searchQuery = getSearchQuery();
        searchForProducts(searchQuery);
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

        Zappos.getAPI().searchProducts(query, new Callback<Response>() {
            @Override
            public void success(Response apiResponse, retrofit.client.Response response) {

                ResultAdapter adapter = new ResultAdapter(activityContext, apiResponse.getResults());
                rvResults.setAdapter(adapter);

            }

            @Override
            public void failure(RetrofitError error) {
                rvResults.setVisibility(View.INVISIBLE);
                Toast.makeText(activityContext, error.getMessage(), Toast.LENGTH_LONG).show();
//                TextView tvError = new TextView(activityContext);
//                tvError.setText("No results found! Pleaset try another search term");
//                activityLayout = new LinearLayout(activityContext);
//                activityLayout.addView(tvError);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_results, menu);
        setupSearchBox(menu);
        return true;
    }

    private void setupSearchBox(Menu menu) {

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        searchbox = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchbox.setSearchableInfo(searchableInfo);
        searchbox.setIconifiedByDefault(false);
        searchbox.requestFocus();
        searchbox.setQuery(searchQuery, false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
