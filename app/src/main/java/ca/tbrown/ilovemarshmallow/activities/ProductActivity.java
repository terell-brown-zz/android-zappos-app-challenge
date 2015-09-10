package ca.tbrown.ilovemarshmallow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.api.Zappos;
import ca.tbrown.ilovemarshmallow.pojo.Product;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProductActivity extends SearchBarActivity {

    // UI
    private Toolbar toolbar;
    private SearchView searchbox;

    @Bind(R.id.viewContainer) LinearLayout viewContainer;
    @Bind(R.id.imgProduct) ImageView imgProduct;
    @Bind(R.id.tvProductName) TextView tvProductName;
    @Bind(R.id.tvPrice) TextView tvPrice;
    @Bind(R.id.tvRating) TextView tvRating;


    // Business Logic
    private String asin;
    private String imageURL;
    private String price;
    private String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        setupToolbar();
        handleIntent(getIntent());
        getProductDetails();
    }

    private void handleIntent(Intent intent) {
        asin = intent.getStringExtra(Constants.ASIN);
        price = intent.getStringExtra(Constants.PRICE);
        rating = intent.getStringExtra(Constants.RATING);
    }

    private void getProductDetails() {
        Zappos.getAPI().searchByAsin(asin, new Callback<Product>() {
            @Override
            public void success(Product productDetails, Response response) {
                updateProductDetails(productDetails);
            }

            @Override
            public void failure(RetrofitError error) {
                viewContainer.setVisibility(View.INVISIBLE);
                Log.e("NONe", error.getMessage());
                Toast.makeText(activityContext,error.getMessage(),Toast.LENGTH_LONG).show();
                new TextView(activityContext).setText("No results found.");
            }
        });
    }

    private void updateProductDetails(Product product) {

        // Load Image from URL to ImageView
        Picasso.with(activityContext).load(product.getDefaultImageUrl()).into(imgProduct);

        // Populate TextViews
        tvProductName.setText(product.getProductName());
        tvPrice.setText(price);
        tvRating.setText(rating);
    }

}
