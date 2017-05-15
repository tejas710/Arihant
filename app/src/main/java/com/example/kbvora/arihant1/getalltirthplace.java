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


public class getalltirthplace extends ActionBarActivity {

    ArrayList<tirth> mArrayList;
    GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getalltirthplace);
        mArrayList=new ArrayList<tirth>();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
        mGridView=(GridView)findViewById(R.id.activity_getalltirthplace_gridView);

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.addHeader("Accept","application/json");
        mClient.addHeader("Content-Type","application/json");
        mClient.get(this,"http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_all_jaintirth",new JsonHttpResponseHandler(){

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
                                mArrayList.add(new tirth(mJsonObject.getString("name"),mJsonObject.getString("photo1")));
                            }
                            mGridView.setAdapter(new tirth_custom_adapter(getalltirthplace.this,mArrayList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(getalltirthplace.this,"No Data Connection!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgressDialog=ProgressDialog.show(getalltirthplace.this,"Loading","Please Wait",true,false);
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

                    tirth t=(tirth)parent.getItemAtPosition(position);
                Intent it=new Intent(getalltirthplace.this,pager_get_tirth_details.class);
                it.putExtra("name",t.getName()+"");
                startActivity(it);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_getalltirthplace, menu);
        MenuItem searchItem=menu.findItem(R.id.action_search1);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String s) {

                Intent it=new Intent(getalltirthplace.this,searchresult_tirth.class);
                it.putExtra("s",s);
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
        if (id == R.id.tirth_menu_action_home) {
            Intent i  = new Intent(getalltirthplace.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tirth_menu_action_Tirthankar) {
            Intent i  = new Intent(getalltirthplace.this,Tirthankar.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.tirth_menu_action_Jainfestival) {
            Intent i  = new Intent(getalltirthplace.this,getAllFestival.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.tirth_menu_action_Jainmagazine) {
            Intent i  = new Intent(getalltirthplace.this,get_all_magazins.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.tirth_menu_action_Jainsongs) {
            Intent i  = new Intent(getalltirthplace.this,getallJainsongs.class);
            startActivity(i);


            return true;
        }
        if (id == R.id.tirth_menu_action_pachhakhanan) {
            Intent i  = new Intent(getalltirthplace.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.tirth_menu_action_sun_time) {
            Intent i  = new Intent(getalltirthplace.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.tirth_menu_action_nearby) {
            Intent i  = new Intent(getalltirthplace.this,MapsActivity.class);
            startActivity(i);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
