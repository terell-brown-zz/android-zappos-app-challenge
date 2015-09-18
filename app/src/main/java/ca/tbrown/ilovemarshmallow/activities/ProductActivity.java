package ca.tbrown.ilovemarshmallow.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.URI;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @Bind(R.id.imgProduct) ImageView imgProduct;
    @Bind(R.id.tvProductName) TextView tvProductName;
    @Bind(R.id.tvDescription) TextView tvDescription;
    @Bind(R.id.tvPrice) TextView tvPrice;
    @Bind(R.id.tvRating) @Nullable TextView tvRating;
    @Bind(R.id.productRatingBar) RatingBar productRatingBar;
    @Bind(R.id.fab) FloatingActionButton fab;
    private boolean isPortraitMode;

    // Business Logic
    private String asin;
    private String productName;
    private String imageURL;
    private String price;
    private String rating;
    private String description;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        isPortraitMode = isPortraitMode();
        setupToolbar();
        intent = getIntent();
        if (intent.getAction() == Intent.ACTION_VIEW) {
            getUriData();
            getProductDetails();
        } else if  (savedInstanceState != null) {
            restoreProductData(savedInstanceState);
            updateProductDetails(false);
        } else {
            handleIntent(intent);
            getProductDetails();
        }
    }

    private boolean isPortraitMode() {
        if (getResources().getConfiguration().orientation == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void getUriData() {
        Uri data = intent.getData();
        asin = data.getQueryParameter(Constants.PARSE_QUERY_ASIN);
        price = data.getQueryParameter(Constants.PARSE_QUERY_PRICE);
        rating = data.getQueryParameter(Constants.PARSE_QUERY_RATING);
        imageURL = "h" + data.getQueryParameter(Constants.PARSE_IMG_URL);
    }

    private void restoreProductData(Bundle savedInstanceState) {
        productName = savedInstanceState.getString(Constants.PRODUCT);
        searchQuery = savedInstanceState.getString(Constants.QUERY);
        asin = savedInstanceState.getString(Constants.ASIN);
        price = savedInstanceState.getString(Constants.PRICE);
        rating = savedInstanceState.getString(Constants.RATING);
        description = savedInstanceState.getString(Constants.DESCRIPTION);
        imageURL = savedInstanceState.getString(Constants.IMAGE);
        //Bitmap bitmap = (Bitmap) savedInstanceState.getParcelable(Constants.IMAGE);
        //imgProduct.setImageBitmap(bitmap);
    }

    private void handleIntent(Intent intent) {
        searchQuery = intent.getStringExtra(Constants.QUERY);
        asin = intent.getStringExtra(Constants.ASIN);
        Log.e("ASIN", asin);
        price = intent.getStringExtra(Constants.PRICE);
        rating = intent.getStringExtra(Constants.RATING);

        String newImageSize;
        if (isPortraitMode()) {
            newImageSize = Constants.PORTRAIT_SIZE;
        } else {
            newImageSize = Constants.LANDSCAPE_SIZE;
        }

        imageURL = Util.resizeImageByURL(intent.getStringExtra(
                        Constants.IMAGE_URL),
                        Constants.MIDSIZE_IMG,
                        newImageSize);
    }

    private void getProductDetails() {
        Zappos.getAPI().searchByAsin(asin, new Callback<Product>() {
            @Override
            public void success(Product productDetails, Response response) {
                productName = productDetails.getProductName();
                description = productDetails.getDescription();
                updateProductDetails(true);
            }

            @Override
            public void failure(RetrofitError error) {
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
        outState.putString(Constants.IMAGE, imageURL);
        outState.putString(Constants.QUERY, searchQuery);
        outState.putString(Constants.PRODUCT, productName);
        outState.putString(Constants.ASIN, asin);
        outState.putString(Constants.PRICE, price);
        outState.putString(Constants.RATING, rating);
        outState.putString(Constants.DESCRIPTION, description);
        super.onSaveInstanceState(outState);
    }

    private void updateProductDetails(Boolean isDataNew) {

            // Populate TextViews
            tvProductName.setText(productName);
            tvDescription.setText(Html.fromHtml(description));
            tvPrice.setText(price);

        if (rating.equals("0.0")) {
            setRatingNotFound();
        } else {
            productRatingBar.setRating(Float.parseFloat(rating));
        }


        //if (isDataNew) {
            // Load Image from URL to ImageView
            Picasso.with(activityContext)
                    .load(imageURL)
                    //.fit()
                    //.centerInside()
                    .into(imgProduct);
        //}
    }

    @OnClick(R.id.fab)
    public void shareProduct() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String uri = generateURI().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, generateShareMessage(uri));
        sendIntent.putExtra(Constants.ASIN, asin);
        sendIntent.putExtra(Constants.PRICE, price);
        sendIntent.putExtra(Constants.RATING, rating);
        sendIntent.putExtra(Constants.URI, Constants.ASIN_ENDPOINT + asin);
        sendIntent.setData(Uri.parse(uri));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, null));
    }

    private String generateShareMessage(String uri) {
        StringBuilder message = new StringBuilder()
                .append(Constants.SHARE_MESSAGE + "\n")
                .append(productName + "\n")
                .append(uri);
        return message.toString();
    }

    private String generateURI() {
        StringBuilder uri = new StringBuilder()
                .append(Constants.BASE_URL)
                .append(Constants.SEARCH_URL)
                .append(Constants.ASIN_SEARCH + asin + "&")
                .append(Constants.PRICE_SEARCH + Constants.DOLLAR_SIGN + price.substring(1) + "&")
                .append(Constants.RATING_SEARCH + rating + "&")
                .append(Constants.IMG_SEARCH + imageURL.substring(1));

        return uri.toString();
    }

    public void setRatingNotFound() {
        tvRating.setVisibility(View.VISIBLE);
        productRatingBar.setVisibility(View.INVISIBLE);
    }
}
