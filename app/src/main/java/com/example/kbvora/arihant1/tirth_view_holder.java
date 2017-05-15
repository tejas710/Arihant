package com.example.kbvora.arihant1;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jinansh12 on 18-01-15.
 */
public class tirth_view_holder {

    TextView tv1;
    ImageView img1;

    public tirth_view_holder(TextView tv1, ImageView img1) {
        this.tv1 = tv1;
        this.img1 = img1;
    }

    public TextView getTv1() {
        return tv1;
    }

    public void setTv1(TextView tv1) {
        this.tv1 = tv1;
    }

    public ImageView getImg1() {
        return img1;
    }

    public void setImg1(ImageView img1) {
        this.img1 = img1;
    }
}
