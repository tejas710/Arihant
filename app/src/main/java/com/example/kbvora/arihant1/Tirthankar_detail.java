package com.example.kbvora.arihant1;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class Tirthankar_detail extends ActionBarActivity {

    TextView tv_tirthankar,tv_pastname,tv_presentname,tv_futurename,tv_chyavandate,tv_janmadate,tv_dikshadate,tv_kevalgyandate;
    ImageView img1,img2,img3,img4,img5;
    TextView tv_mokshadate,tv_heaven,tv_birthplace,tv_parents;
    TextView tv_complex,tv_symbol,tv_height,tv_age,tv_tree;
    TextView tv_attendentspirits,tv_malefemaledisciple,tv_nirvanplace;
    TextView tv_introduction,tv_stuti,tv_stavan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirthankar_detail);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));

        tv_tirthankar=(TextView)findViewById(R.id.Tirthanakr_details_textView_tirthankar);
        tv_pastname=(TextView)findViewById(R.id.Tirthanakr_details_textView_pastname);
        tv_presentname=(TextView)findViewById(R.id.Tirthanakr_details_textView_presentname);
        tv_futurename=(TextView)findViewById(R.id.Tirthanakr_details_textView_futurename);
        tv_chyavandate=(TextView)findViewById(R.id.Tirthanakr_details_textView_chyavandate);
        tv_janmadate=(TextView)findViewById(R.id.Tirthanakr_details_textView_janmadate);
        tv_dikshadate=(TextView)findViewById(R.id.Tirthanakr_details_textView_dikshadate);
        tv_kevalgyandate=(TextView)findViewById(R.id.Tirthanakr_details_textView_kevalgyandate);
        tv_mokshadate=(TextView)findViewById(R.id.Tirthanakr_details_textView_mokshadate);
        tv_heaven=(TextView)findViewById(R.id.Tirthanakr_details_textView_heaven);
        tv_birthplace=(TextView)findViewById(R.id.Tirthanakr_details_textView_birthplace);
        tv_parents=(TextView)findViewById(R.id.Tirthanakr_details_textView_parents);
        tv_complex=(TextView)findViewById(R.id.Tirthanakr_details_textView_complex);
        tv_symbol=(TextView)findViewById(R.id.Tirthanakr_details_textView_symbol);
        tv_height=(TextView)findViewById(R.id.Tirthanakr_details_textView_height);
        tv_age=(TextView)findViewById(R.id.Tirthanakr_details_textView_age);
        tv_tree=(TextView)findViewById(R.id.Tirthanakr_details_textView_tree);
        tv_attendentspirits=(TextView)findViewById(R.id.Tirthanakr_details_textView_attendentspirits);
        tv_malefemaledisciple=(TextView)findViewById(R.id.Tirthanakr_details_textView_malefemaledisciple);
        tv_nirvanplace=(TextView)findViewById(R.id.Tirthanakr_details_textView_nirvanplace);
        tv_introduction=(TextView)findViewById(R.id.Tirthanakr_details_textView_introduction);
        tv_stuti=(TextView)findViewById(R.id.Tirthanakr_details_textView_stuti);
        tv_stavan=(TextView)findViewById(R.id.Tirthanakr_details_textView_stavan);
        img1=(ImageView)findViewById(R.id.Tirthanakr_details_imageView_photo1);
        img2=(ImageView)findViewById(R.id.Tirthanakr_details_imageView_photo2);
        img3=(ImageView)findViewById(R.id.Tirthanakr_details_imageView_photo3);
        img4=(ImageView)findViewById(R.id.Tirthanakr_details_imageView_photo4);
        img5=(ImageView)findViewById(R.id.Tirthanakr_details_imageView_photo5);


        Intent it = getIntent();
        String name = it.getStringExtra("name");


        JSONObject obj = new JSONObject();
        StringEntity mStringEntity=null;
        try {
            obj.put("name",name);
            mStringEntity = new StringEntity(obj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected) {
            AsyncHttpClient mclient = new AsyncHttpClient();
            mclient.addHeader("Accept", "application/json");
            mclient.addHeader("Content-Type", "application/json");
            mclient.post(this, "http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_tirthankar_by_name", mStringEntity, "application/json", new JsonHttpResponseHandler()

                    {

                        ProgressDialog mProgressDialog;

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);

                            try {
                                JSONArray mJsonArray = response.getJSONArray("d");
                                JSONObject obj;

                                obj = mJsonArray.getJSONObject(0);
                                tv_tirthankar.setText(obj.getString("tirthankar") + "");
                                tv_pastname.setText(obj.getString("pastname") + "");
                                tv_presentname.setText(obj.getString("presentname")+"");
                                tv_futurename.setText(obj.getString("futurename")+ "");
                               tv_chyavandate.setText(obj.getString("chyavandate")+ "");

                                tv_janmadate.setText(obj.getString("janmadate")+ "");
                                tv_dikshadate.setText(obj.getString("dikshadate")+ "");
                                tv_kevalgyandate.setText(obj.getString("kevalgyandate")+ "");
                                tv_mokshadate.setText(obj.getString("mokshadate")+ "");
                                tv_heaven.setText(obj.getString("heaven")+ "");
                                tv_birthplace.setText(obj.getString("birthplace")+ "");
                                tv_parents.setText(obj.getString("parents")+ "");
                                tv_complex.setText(obj.getString("complex")+ "");
                                tv_symbol.setText(obj.getString("symbol")+ "");
                                tv_height.setText(obj.getString("height")+ "");
                                tv_age.setText(obj.getString("age")+ "");
                                tv_tree.setText(obj.getString("tree")+ "");
                                tv_attendentspirits.setText(obj.getString("attendentspirits")+ "");
                                tv_malefemaledisciple.setText(obj.getString("malefemaledisciple")+ "");
                                tv_nirvanplace.setText(obj.getString("nirvanplace")+ "");
                                tv_introduction.setText(obj.getString("introduction")+ "");
                                tv_stuti.setText(obj.getString("stuti")+ "");
                                tv_stavan.setText(obj.getString("stavan")+ "");
                                String str1 = obj.getString("photo1")+"";
                                if(str1!="") {
                                    str1 = obj.getString("photo1").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                    Picasso.with(Tirthankar_detail.this).load(str1).into(img1);
                                }
                                String str2 = obj.getString("photo2")+"";
                                if(str2!="") {
                                    str2 = obj.getString("photo2").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                    Picasso.with(Tirthankar_detail.this).load(str2).into(img2);
                                }
                                String str3 = obj.getString("photo3")+"";
                                if(str3!="") {
                                    str3 = obj.getString("photo3").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                    Picasso.with(Tirthankar_detail.this).load(str3).into(img3);
                                }
                                String str4 = obj.getString("photo4")+"";
                                if(str4!="") {
                                    str4 = obj.getString("photo4").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                    Picasso.with(Tirthankar_detail.this).load(str4).into(img4);
                                }
                                String str5 = obj.getString("photo5")+"";
                                if(str5!="") {
                                    str5 = obj.getString("photo5").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                    Picasso.with(Tirthankar_detail.this).load(str5).into(img5);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Log.i("dsf", " nathi thayu");
                        }

                        @Override
                        public void onStart() {
                            super.onStart();
                            mProgressDialog=ProgressDialog.show(Tirthankar_detail.this,"Loading","Please Wait",true,false);

                        }

                        @Override
                        public void onFinish() {
                            super.onFinish();
                            if(mProgressDialog.isShowing())
                            {
                                mProgressDialog.dismiss();
                            }
                        }
                    }
            );
        }
        else
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("No Data Connection Found,Please Turn On Data Connection From Settings And Then Try Again ");
            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setIcon(R.drawable.ic_launcher);
            builder.setCancelable(false);
            AlertDialog dialog=builder.create();
            dialog.show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tirthankar_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
