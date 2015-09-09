package ca.tbrown.ilovemarshmallow.activities;

import android.app.SearchManager;
import android.content.Intent;
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

import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.pojo.Response;
import ca.tbrown.ilovemarshmallow.pojo.Result;

public class SearchResultsActivity extends BaseActivity {

    // UI
    private Toolbar toolbar;
    private SearchView searchbox;
    private RecyclerView rvResults;
    // Business Logic
    private String searchQuery;
    private Response response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        searchQuery = getSearchQuery();
        setupToolbar(searchQuery);
        searchForProduct(searchQuery);
        getData();
        setupRecyclerView();

    }

    private void getData() {
        response = new Response();
        List<Result> data = new ArrayList<Result>();
        //String brandName, Object originalPrice, String price, String imageUrl, String asin, String productUrl, Double productRating, Object map, String productName)
        data.add(new Result("Nike","99.99","44.55","www.google.com","4rd1kc93d3","www.google.com",4.0,null,"Towel"));
        data.add(new Result("Nike","99.99","44.55","www.google.com","4rd1kc93d3","www.google.com",4.0,null,"Towel"));
        data.add(new Result("Nike","99.99","44.55","www.google.com","4rd1kc93d3","www.google.com",4.0,null,"Towel"));
        response.setResults(data);
    }

    private void setupRecyclerView() {
        rvResults = (RecyclerView) findViewById(R.id.rvResults);
        rvResults.setHasFixedSize(true);
        rvResults.setLayoutManager(new LinearLayoutManager(activityContext));

    }

    private void setupToolbar(String query) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

    }

    private void searchForProduct(String query) {

    }

    private String getSearchQuery() {
        String query = "";
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
        }
        return query;
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
