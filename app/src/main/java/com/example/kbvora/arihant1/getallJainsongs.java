package com.example.kbvora.arihant1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class getallJainsongs extends ActionBarActivity {
    ArrayList<jainsong> mArrayList;
    GridView mGridView;
    TextView tv1;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getalljainsongs);

        mArrayList=new ArrayList<jainsong>();
        mGridView=(GridView)findViewById(R.id.activity_getalljainsongs_gridView);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                jainsong j=(jainsong)parent.getItemAtPosition(position);
                str=j.getJainsongs_audiopath().replace("~/","http://www.jinalshah.brainoorja.com/");
                Intent it=new Intent(getallJainsongs.this,audioplay.class);
                it.putExtra("name",j.getJainsongs_name()+"");
                it.putExtra("path",str);
                startActivity(it);
            }
        });

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.addHeader("Accept","application/json");
        mClient.addHeader("Content-Type","application/json");
        mClient.get(this,"http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_all_jainsongs",new JsonHttpResponseHandler(){

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
                                mArrayList.add(new jainsong(mJsonObject.getString("jainsongs_name"),mJsonObject.getString("jainsongs_audiopath")));
                            }

                            mGridView.setAdapter(new jainsong_custom_adapter(getallJainsongs.this,mArrayList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(getallJainsongs.this, "No Data Connection!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgressDialog=ProgressDialog.show(getallJainsongs.this,"Loading","Please Wait",true,false);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jainsongs, menu);
        MenuItem searchItem=menu.findItem(R.id.action_search4);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                Intent it = new Intent(getallJainsongs.this, search_jain_songs.class);
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
        if (id == R.id.sfes1tirthankar_menu_action_home) {
            Intent i  = new Intent(getallJainsongs.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sfes1tirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(getallJainsongs.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.sfes1tirthankar_menu_action_Jainmagazine) {
            Intent i = new Intent(getallJainsongs.this,get_all_magazins.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sfes1tirth_menu_action_Tirthankar) {
            Intent i = new Intent(getallJainsongs.this,Tirthankar.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sfes1tirth_menu_action_pachhakhanan) {
            Intent i = new Intent(getallJainsongs.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.sfes1tirthankar_menu_action_sun_time) {
            Intent i  = new Intent(getallJainsongs.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.sfes1tirth_menu_action_Jainfestival) {
            Intent i  = new Intent(getallJainsongs.this,getAllFestival.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.sfes1tirthankar_menu_action_nearby) {
            Intent i  = new Intent(getallJainsongs.this,MapsActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
