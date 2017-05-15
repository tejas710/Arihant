package com.example.kbvora.arihant1;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class festival_details extends ActionBarActivity {
    TextView tv_festivalname,tv_description;
    ProgressDialog mProgressDialog;
    JSONObject obj;
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);
        tv_festivalname=(TextView)findViewById(R.id.festival_details_textView_festvalname);
        tv_description=(TextView)findViewById(R.id.festival_details_textView_description);
        Intent it = getIntent();
        name = it.getStringExtra("name");
        getSupportActionBar().setTitle(name);
         obj = new JSONObject();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
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
            mclient.post(this, "http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_jainfestival_by_name", mStringEntity, "application/json", new JsonHttpResponseHandler()

                    {

                        ProgressDialog mProgressDialog;

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);

                            try {
                                JSONArray mJsonArray = response.getJSONArray("d");
                                JSONObject obj;

                                obj = mJsonArray.getJSONObject(0);
                              //  tv_festivalname.setText(obj.getString("festivalname") + "");
                                tv_description.setText(obj.getString("description") + "");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Toast.makeText(festival_details.this, "No Data Connection!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onStart() {
                            super.onStart();
                            mProgressDialog=ProgressDialog.show(festival_details.this,"Loading","Please Wait",true,false);

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
        getMenuInflater().inflate(R.menu.menu_festival_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.festirthankar_menu_action_home) {
            Intent i  = new Intent(festival_details.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.festirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(festival_details.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.festirthankar_menu_action_Jainmagazine) {
            Intent i = new Intent(festival_details.this,get_all_magazins.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.festirthankar_menu_action_Jainsongs) {
            Intent i = new Intent(festival_details.this,getallJainsongs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.festirth_menu_action_pachhakhanan) {
            Intent i = new Intent(festival_details.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.festirthankar_menu_action_sun_time) {
            Intent i  = new Intent(festival_details.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.festirthankar_menu_action_nearby) {
            Intent i  = new Intent(festival_details.this,MapsActivity.class);
            startActivity(i);

            return true;
        }

        if(id==R.id.pager_festival_action_shere)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_TEXT, "Name :" + name + ", Description :" + tv_description.getText().toString() + ".");

            startActivity(Intent.createChooser(intent, "Share with"));
        }
        return super.onOptionsItemSelected(item);
    }
}
