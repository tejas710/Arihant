package com.example.kbvora.arihant1;


import android.app.AlertDialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.squareup.picasso.Picasso;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Locale;


public class pager_get_tirth_details extends ActionBarActivity implements tirth_details1.OnFragmentInteractionListener,tirth_details2.OnFragmentInteractionListener1,tirth_detail3.OnFragmentInteractionListener2,tirth_details4.OnFragmentInteractionListener3,tirth_details5.OnFragmentInteractionListener4,tirth_details6.OnFragmentInteractionListener5, ActionBar.TabListener {

    String tname="";
    String photo1="",photo2="",photo3="",photo4="",photo5="",photo6="",photo7="",photo8="";
    String mulnayak=" ",descrption="",contact="",address="",city="",state="",country="";
    String nearcity="",surplace="",dhramshal="",bhojanshal="",nearbus="",nearrailway="",nearairport="";
    String websit="";


    SectionPagerAdapter sectionPagerAdapter;
    ViewPager mViewPager;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_get_tirth_details);
        Intent it = getIntent();
        String name = it.getStringExtra("name");
        Toast.makeText(pager_get_tirth_details.this,name,Toast.LENGTH_SHORT).show();
        getdata(name);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));

    }

    public void getdata(String name) {


        JSONObject obj = new JSONObject();
        StringEntity mStringEntity = null;
        try {
            obj.put("name", name);
            mStringEntity = new StringEntity(obj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            AsyncHttpClient mclient = new AsyncHttpClient();
            mclient.addHeader("Accept", "application/json");
            mclient.addHeader("Content-Type", "application/json");
            RequestHandle post = mclient.post(pager_get_tirth_details.this, "http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_jaintirth_by_name", mStringEntity, "application/json", new JsonHttpResponseHandler()

                    {

                        ProgressDialog mProgressDialog;

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);


                            try {
                                JSONArray mJsonArray = response.getJSONArray("d");
                                JSONObject obj;

                                obj = mJsonArray.getJSONObject(0);

                                tname = obj.getString("name") + "";

                                contact = obj.getString("contactdetails") + "";
                                address = obj.getString("address") + "";
                                mulnayak = obj.getString("mulnayak") + "";
                                city = obj.getString("city") + "";
                                state = obj.getString("state") + "";
                                country = obj.getString("country") + "";
                                nearcity = obj.getString("nearestcity") + "";
                                surplace = obj.getString("surroundplaces") + "";
                                dhramshal = obj.getString("dharmshala") + "";
                                bhojanshal = obj.getString("bhojanshala") + "";
                                nearbus = obj.getString("nearestbusstop") + "";
                                nearrailway = obj.getString("nearestrailwaystation") + "";
                                nearairport = obj.getString("nearestairport") + "";
                                websit = obj.getString("website") + "";
                                photo1 = obj.getString("photo1") + "";
                                if (photo1 != "") {
                                    photo1 = obj.getString("photo1").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo2 = obj.getString("photo2") + "";
                                if (photo2 != "") {
                                    photo2 = obj.getString("photo2").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo3 = obj.getString("photo3") + "";
                                if (photo3 != "") {
                                    photo3 = obj.getString("photo3").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo4 = obj.getString("photo4") + "";
                                if (photo4 != "") {
                                    photo4 = obj.getString("photo4").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo5 = obj.getString("photo5") + "";
                                if (photo5 != "") {
                                    photo5 = obj.getString("photo5").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo6 = obj.getString("photo6") + "";
                                if (photo6 != "") {
                                    photo6 = obj.getString("photo6").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo7 = obj.getString("photo7") + "";
                                if (photo7 != "") {
                                    photo7 = obj.getString("photo7").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo8 = obj.getString("photo8") + "";
                                if (photo8 != "") {
                                    photo8 = obj.getString("photo8").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                descrption = obj.getString("description") + "";

                                mActionBar = getSupportActionBar();
                                mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

                                sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.pager);
                                mViewPager.setAdapter(sectionPagerAdapter);
                                mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                                    @Override
                                    public void onPageSelected(int position) {
                                        //super.onPageSelected(position);
                                        mActionBar.setSelectedNavigationItem(position);
                                    }
                                });
                                for (int i = 0; i < sectionPagerAdapter.getCount(); i++) {
                                    mActionBar.addTab(
                                            mActionBar.newTab().setText(sectionPagerAdapter.getPageTitle(i))
                                                    .setTabListener((pager_get_tirth_details.this)
                                                    ));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Toast.makeText(pager_get_tirth_details.this,"No Data Connection!",Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onStart() {
                            super.onStart();
                            mProgressDialog = ProgressDialog.show(pager_get_tirth_details.this, "Loading", "Please Wait", true, false);
                        }

                        @Override
                        public void onFinish() {
                            super.onFinish();
                            if (mProgressDialog.isShowing()) {
                                mProgressDialog.dismiss();
                            }
                        }
                    }
            );
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pager_get_tirth_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.pagertirth_menu_action_home) {
            Intent i  = new Intent(pager_get_tirth_details.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.pagertirth_menu_action_Tirthankar) {
            Intent i  = new Intent(pager_get_tirth_details.this,Tirthankar.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.pagertirth_menu_action_Jainfestival) {
            Intent i  = new Intent(pager_get_tirth_details.this,getAllFestival.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.pagertirth_menu_action_Jainmagazine) {
            Intent i  = new Intent(pager_get_tirth_details.this,get_all_magazins.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.pagertirth_menu_action_Jainsongs) {
            Intent i  = new Intent(pager_get_tirth_details.this,getallJainsongs.class);
            startActivity(i);


            return true;
        }
        if (id == R.id.pagertirth_menu_action_pachhakhanan) {
            Intent i  = new Intent(pager_get_tirth_details.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.pagertirth_menu_action_sun_time) {
            Intent i  = new Intent(pager_get_tirth_details.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.pagertirth_menu_action_nearby) {
            Intent i  = new Intent(pager_get_tirth_details.this,MapsActivity.class);
            startActivity(i);

            return true;
        }
        if(id==R.id.pager_tirth_place_action_shere)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,"Name :"+tname+", Address :"+address+", Contact :"+contact+".");
            startActivity(Intent.createChooser(intent, "Share with"));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onFragmentInteraction1(Uri uri) {


    }
    @Override
    public void onFragmentInteraction2(Uri uri) {

    }

    @Override
    public void onFragmentInteraction3(Uri uri) {

    }

    @Override
    public void onFragmentInteraction4(Uri uri) {

    }

    @Override
    public void onFragmentInteraction5(Uri uri) {

    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    return tirth_details1.newInstance(tname,photo1,mulnayak);
                case 1:
                    return tirth_details6.newInstance(descrption);
                case 2:
                    return tirth_details2.newInstance(nearcity,nearbus,nearrailway,nearairport);
                case 3:
                    return tirth_detail3.newInstance(address,city,state,country,contact);
                case 4:
                    return tirth_details4.newInstance(surplace,dhramshal,bhojanshal);
                case 5:
                    return tirth_details5.newInstance(photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8);
                    default:
                        return tirth_details1.newInstance(tname,photo1,mulnayak);
            }
        }

        @Override
        public int getCount() {
            return 6;
        }@Override
         public CharSequence getPageTitle(int position) {


            Locale l=Locale.getDefault();

            switch (position)
            {
                case 0:
                    return getString(R.string.info).toUpperCase();

                               case 1:
                    return getString(R.string.info1).toUpperCase();
                case 2:
                    return getString(R.string.info2).toUpperCase();
                case 3:
                    return getString(R.string.info3).toUpperCase();
                case 4:
                    return getString(R.string.info4).toUpperCase();
                case 5:
                    return getString(R.string.info5).toUpperCase();
            }
            return null;
        }

    }
}