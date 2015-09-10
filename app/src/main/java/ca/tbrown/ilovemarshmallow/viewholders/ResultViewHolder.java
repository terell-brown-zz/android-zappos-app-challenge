package ca.tbrown.ilovemarshmallow.viewholders;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.tbrown.ilovemarshmallow.Constants;
import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.activities.ProductActivity;
import ca.tbrown.ilovemarshmallow.api.Zappos;
import ca.tbrown.ilovemarshmallow.pojo.Product;
import ca.tbrown.ilovemarshmallow.pojo.Result;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by tmast_000 on 9/8/2015.
 */
public class ResultViewHolder extends RecyclerView.ViewHolder {

    // Backend Components
    private Context activityContext;

    // Views
    @Bind(R.id.cvResult) CardView cvResult;
    @Bind(R.id.ivResult) ImageView imgProduct;
    @Bind(R.id.tvProductName) TextView tvProductName;
    @Bind(R.id.tvPrice) TextView tvPrice;
    @Bind(R.id.tvRating) TextView tvRating;

    // Business Logic
    private String asin;
    private String price;
    private String rating;
    private String imgURL;


    public ResultViewHolder(Context c,View itemView) {
        super(itemView);
        activityContext = c;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Result result) {

        // Load Image from URL
        imgURL = result.getImageUrl();
        Picasso.with(activityContext).load(imgURL).into(imgProduct);

        // Store important values
        price = result.getPrice();
        rating = Double.toString(result.getProductRating());
        asin = result.getAsin();


        // Populate Views
        tvPrice.setText(price);
        tvProductName.setText(result.getProductName());
        tvRating.setText(rating);
    }


    @OnClick(R.id.cvResult)
    public void showProductDetails() {
        Intent intent = new Intent(activityContext, ProductActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constants.PRICE, price);
        intent.putExtra(Constants.RATING, rating);
        intent.putExtra(Constants.ASIN, asin);
        intent.putExtra(Constants.IMAGE_URL,imgURL);

        activityContext.startActivity(intent);
    }
}
