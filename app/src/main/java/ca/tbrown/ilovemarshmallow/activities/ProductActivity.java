package ca.tbrown.ilovemarshmallow.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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
import ca.tbrown.ilovemarshmallow.Util;
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
    private String productName;
    private String imageURL;
    private String price;
    private String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        setupToolbar();

        if (savedInstanceState != null) {
            restoreProductData(savedInstanceState);
            updateProductDetails(false);
        } else {
            handleIntent(getIntent());
            getProductDetails();
        }
    }

    private void restoreProductData(Bundle savedInstanceState) {
        productName = savedInstanceState.getString(Constants.PRODUCT);
        asin = savedInstanceState.getString(Constants.ASIN);
        price = savedInstanceState.getString(Constants.PRICE);
        rating = savedInstanceState.getString(Constants.RATING);
        Bitmap bitmap = (Bitmap) savedInstanceState.getParcelable(Constants.IMAGE);
        imgProduct.setImageBitmap(bitmap);
    }

    private void handleIntent(Intent intent) {
        searchQuery = intent.getStringExtra(Constants.QUERY);
        asin = intent.getStringExtra(Constants.ASIN);
        price = intent.getStringExtra(Constants.PRICE);
        rating = intent.getStringExtra(Constants.RATING);
        imageURL = Util.resizeImageByURL(intent.getStringExtra(Constants.IMAGE_URL),
                Constants.SMALL_IMG,
                Constants.LARGE_IMG);
    }

    private void getProductDetails() {
        Zappos.getAPI().searchByAsin(asin, new Callback<Product>() {
            @Override
            public void success(Product productDetails, Response response) {
                productName = productDetails.getProductName();
                updateProductDetails(true);
            }

            @Override
            public void failure(RetrofitError error) {
                viewContainer.setVisibility(View.INVISIBLE);
                Log.e("NONe", error.getMessage());
                Toast.makeText(activityContext, error.getMessage(), Toast.LENGTH_LONG).show();
                new TextView(activityContext).setText("No results found.");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        BitmapDrawable bd = (BitmapDrawable) imgProduct.getDrawable();
        Bitmap image = bd.getBitmap();
        outState.putParcelable(Constants.IMAGE, image);
        outState.putString(Constants.PRODUCT, productName);
        outState.putString(Constants.ASIN, asin);
        outState.putString(Constants.PRICE, price);
        outState.putString(Constants.RATING, rating);
        super.onSaveInstanceState(outState);
    }

    private void updateProductDetails(Boolean isDataNew) {

        if (isDataNew) {

            // Populate TextViews
            tvProductName.setText(productName);
            tvPrice.setText(price);
            tvRating.setText(rating);

            // Load Image from URL to ImageView
            Picasso.with(activityContext)
                    .load(imageURL)
                    .fit()
                    .centerInside()
                    .into(imgProduct);
        }

    }

}
