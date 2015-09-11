package ca.tbrown.ilovemarshmallow.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
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

public class SearchResultsActivity extends SearchBarActivity {

    // UI
    private RecyclerView rvResults;
    private LinearLayout activityLayout;
    private ArrayList<Result> searchResults;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);
        searchQuery = getSearchQuery();
        setupToolbar();
        setupRecyclerView();

        if (savedInstanceState != null) {
            restoreSearchData(savedInstanceState);
            populateRecyclerView();
        } else {
            searchForProducts(searchQuery);
        }
    }

    private void restoreSearchData(Bundle savedInstanceState) {
        searchQuery = savedInstanceState.getString(Constants.QUERY);
        searchResults = savedInstanceState.getParcelableArrayList(Constants.SEARCH_RESULTS);
    }

    private void populateRecyclerView() {
        ResultAdapter adapter = new ResultAdapter(activityContext, searchResults, searchQuery);
        rvResults.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(Constants.QUERY, searchQuery);
        outState.putParcelableArrayList(Constants.SEARCH_RESULTS, searchResults);
        super.onSaveInstanceState(outState);
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
        String query = null;
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
        }

        if (query == null)
            query = intent.getStringExtra(Constants.QUERY);

        return query;
    }

    private void searchForProducts(String query) {

        Zappos.getAPI().searchProducts(query, new Callback<Response>() {
            @Override
            public void success(Response apiResponse, retrofit.client.Response response) {

                searchResults = apiResponse.getResults();
                ResultAdapter adapter = new ResultAdapter(activityContext, apiResponse.getResults(), searchQuery);
                rvResults.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(activityContext, "No search results found", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
