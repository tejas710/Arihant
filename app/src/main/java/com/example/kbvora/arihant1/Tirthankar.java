package com.example.kbvora.arihant1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Tirthankar extends ActionBarActivity {

    ArrayList<Tirthankarcon> mArrayList;
    GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirthankar);
        mArrayList=new ArrayList<Tirthankarcon>();
        mGridView=(GridView)findViewById(R.id.activity_tirthankar_gridView);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.addHeader("Accept","application/json");
        mClient.addHeader("Content-Type","application/json");
        mClient.get(this, "http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_all_tirthankar", new JsonHttpResponseHandler() {

                    ProgressDialog mProgressDialog;

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);

                        try {
                            JSONArray mJsonArray = response.getJSONArray("d");
                            JSONObject mJsonObject;

                            for (int i = 0; i < mJsonArray.length(); i++) {
                                mJsonObject = mJsonArray.getJSONObject(i);
                                mArrayList.add(new Tirthankarcon(mJsonObject.getString("tirthankar"), mJsonObject.getString("photo1")));
                            }
                            mGridView.setAdapter(new Tirthankar_custom_adpter(Tirthankar.this, mArrayList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(Tirthankar.this, "No Data Connection!", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgressDialog=ProgressDialog.show(Tirthankar.this,"Loading","Please Wait",true,false);
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


                Tirthankarcon t=(Tirthankarcon)parent.getItemAtPosition(position);
                Intent it=new Intent(Tirthankar.this,pager_tithankar_details.class);
                it.putExtra("name",t.getTirthankar()+"");
                startActivity(it);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tirthankar, menu);
        MenuItem searchItem=menu.findItem(R.id.action_search2);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                Intent it = new Intent(Tirthankar.this, search_Tirthankar.class);
                it.putExtra("s", s);
                startActivity(it);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.tirthankar_menu_action_home) {
            Intent i  = new Intent(Tirthankar.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(Tirthankar.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tirthankar_menu_action_Jainfestival) {
            Intent i = new Intent(Tirthankar.this,getAllFestival.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tirthankar_menu_action_Jainmagazine) {
            Intent i = new Intent(Tirthankar.this,get_all_magazins.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tirthankar_menu_action_Jainsongs) {
            Intent i = new Intent(Tirthankar.this,getallJainsongs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tirthankar_menu_action_pachhakhanan) {
            Intent i = new Intent(Tirthankar.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.tirthankar_menu_action_sun_time) {
            Intent i  = new Intent(Tirthankar.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.tirthankar_menu_action_nearby) {
            Intent i  = new Intent(Tirthankar.this,MapsActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
