package com.example.kbvora.arihant1;

import android.widget.TextView;

/**
 * Created by jinansh12 on 18-03-15.
 */
public class magazine_view_holder {
    TextView tv1,tv2,tv3,tv4;

    public magazine_view_holder(TextView tv1, TextView tv2, TextView tv3, TextView tv4) {
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.tv4 = tv4;

    }

    public TextView getTv1() {
        return tv1;
    }

    public void setTv1(TextView tv1) {
        this.tv1 = tv1;
    }

    public TextView getTv2() {
        return tv2;
    }

    public void setTv2(TextView tv2) {
        this.tv2 = tv2;
    }

    public TextView getTv3() {
        return tv3;
    }

    public void setTv3(TextView tv3) {
        this.tv3 = tv3;
    }

    public TextView getTv4() {
        return tv4;
    }

    public void setTv4(TextView tv4) {
        this.tv4 = tv4;
    }


}
