package com.example.kbvora.arihant1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class search_festival extends ActionBarActivity {
    ArrayList<festival> mArrayList;
    GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_festival);
        mArrayList=new ArrayList<festival>();
        mGridView=(GridView)findViewById(R.id.activity_get_all_festival_gridView_search);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));

        Intent it=getIntent();
        getSupportActionBar().setTitle(it.getStringExtra("s"));
        String name=it.getStringExtra("s");
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

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.addHeader("Accept","application/json");
        mClient.addHeader("Content-Type","application/json");
        mClient.post(this,"http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_jainfestival_by_name",mStringEntity,"application/json",new JsonHttpResponseHandler(){

                    ProgressDialog mProgressDialog;
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);

                        try {
                            JSONArray mJsonArray=response.getJSONArray("d");
                            JSONObject mJsonObject;

                            for(int i=0;i<mJsonArray.length();i++)
                            {
                                mJsonObject=mJsonArray.getJSONObject(i);
                                mArrayList.add(new festival(mJsonObject.getString("festivalname"),mJsonObject.getString("description")));
                            }
                            mGridView.setAdapter(new festival_custom_adapter(search_festival.this,mArrayList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(search_festival.this, "No Data Connection!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgressDialog=ProgressDialog.show(search_festival.this,"Loading","Please Wait",true,false);
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
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                festival f=(festival)parent.getItemAtPosition(position);
                Intent it=new Intent(search_festival.this,festival_details.class);
                it.putExtra("name",f.getFestivalname()+"");

                startActivity(it);

            }

        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_festival, menu);
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
