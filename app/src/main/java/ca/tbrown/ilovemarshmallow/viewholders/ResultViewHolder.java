package ca.tbrown.ilovemarshmallow.viewholders;

import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.pojo.Result;

/**
 * Created by tmast_000 on 9/8/2015.
 */
public class ResultViewHolder extends RecyclerView.ViewHolder {

    // Views

    private CardView cv;
    private ImageView image;
    @Bind(R.id.tvBrand) TextView tvbrand;
    @Bind(R.id.tvProductName) TextView tvProductName;
    @Bind(R.id.tvPrice) TextView tvPrice;
    @Bind(R.id.tvRating) TextView tvRating;


    public ResultViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Result result) {
        tvbrand.setText(result.getBrandName());
        tvPrice.setText(result.getPrice());
        tvProductName.setText(result.getProductName());
        tvRating.setText(result.getProductRating().toString());
    }
}
