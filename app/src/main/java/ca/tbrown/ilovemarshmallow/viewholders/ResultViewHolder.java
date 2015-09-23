package ca.tbrown.ilovemarshmallow.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.Util;
import ca.tbrown.ilovemarshmallow.activities.ProductActivity;
import ca.tbrown.ilovemarshmallow.api.Zappos;
import ca.tbrown.ilovemarshmallow.pojo.Result;

/**
 * Created by tmast_000 on 9/8/2015.
 */
public class ResultViewHolder extends RecyclerView.ViewHolder {

    // Backend Components
    private Context activityContext;

    // UI
    @Bind(R.id.cvResult) CardView cvResult;
    @Bind(R.id.ivResult)
    ImageView imgProduct;
    @Bind(R.id.tvProductName)
    TextView tvProductName;
    @Bind(R.id.tvPrice)
    TextView tvPrice;
    @Bind(R.id.tvRating)
    TextView tvRating;
    @Bind(R.id.productRatingBar)
    RatingBar productRatingBar;

    // Business Logic
    private String asin;
    private String price;
    private String rating;
    private String imgURL;
    private String searchQuery;


    public ResultViewHolder(Context c, View itemView, String query) {
        super(itemView);
        activityContext = c;
        searchQuery = query;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Result result) {

        // Load Image from URL
        imgURL = Util.resizeImageByURL(result.getImageUrl(), Constants.SMALL_IMG, Constants.MIDSIZE_IMG);
        Picasso.with(activityContext)
                .load(imgURL)
                .fit()
                .centerInside()
                .into(imgProduct);

        // Store important values
        price = result.getPrice();
        rating = Double.toString(result.getProductRating());
        asin = result.getAsin();


        // Populate Views
        tvPrice.setText(price);
        tvProductName.setText(result.getProductName());
        if (rating.equals("0.0")) {
            setRatingNotFound();
        } else {
            productRatingBar.setRating(Float.parseFloat(rating));
        }
    }


    @OnClick(R.id.cvResult)
    public void showProductDetails() {
        Intent intent = new Intent(activityContext, ProductActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constants.PRICE, price);
        intent.putExtra(Constants.RATING, rating);
        intent.putExtra(Constants.ASIN, asin);
        intent.putExtra(Constants.IMAGE_URL, imgURL);
        intent.putExtra(Constants.QUERY, searchQuery);

        activityContext.startActivity(intent);
    }

    private void setRatingNotFound() {
        tvRating.setVisibility(View.VISIBLE);
        productRatingBar.setVisibility(View.GONE);
    }
}
