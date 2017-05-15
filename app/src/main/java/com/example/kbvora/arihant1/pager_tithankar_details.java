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
import com.squareup.picasso.Picasso;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class pager_tithankar_details extends ActionBarActivity implements  tirthankar_details1.OnFragmentInteractionListener,tirthankar_details2.OnFragmentInteractionListener1,trithankar_details3.OnFragmentInteractionListener2,tirthakar_details4.OnFragmentInteractionListener3,tirthankar_details5.OnFragmentInteractionListener4, ActionBar.TabListener {

    String tithankar = "", pastname = "", presantname = "", futurename = "";
    String chyvandate = "", janmadate = "", dikshaname = "", kevaldate = "", mokshadate = "";
    String heven = "", birthplce = "", parents = "", complex = "", symbol = "", height = "", age = "", tree = "";
    String attenspirit = "", disciple = "", nirvanplace = "", intro = "";
    String photo1 = "", photo2 = "", photo3 = "", photo4 = "", photo5 = "";
    String stuti = "", stavan = "";
    SectionPagerAdapter sectionPagerAdapter;
    ViewPager mViewPager;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tithankar_details);
        Intent it = getIntent();
        String name = it.getStringExtra("name");
        Toast.makeText(pager_tithankar_details.this, name, Toast.LENGTH_SHORT).show();
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
            mclient.post(pager_tithankar_details.this, "http://www.jinalshah.brainoorja.com/WebService_d2t.asmx/get_tirthankar_by_name", mStringEntity, "application/json", new JsonHttpResponseHandler()

                    {

                        ProgressDialog mProgressDialog;

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);


                            try {
                                JSONArray mJsonArray = response.getJSONArray("d");
                                JSONObject obj;

                                obj = mJsonArray.getJSONObject(0);
                                tithankar=(obj.getString("tirthankar") + "");
                                pastname=(obj.getString("pastname") + "");
                                presantname=(obj.getString("presentname")+"");
                                futurename=(obj.getString("futurename")+ "");
                                chyvandate=(obj.getString("chyavandate")+ "");

                                janmadate=(obj.getString("janmadate")+ "");
                                dikshaname=(obj.getString("dikshadate")+ "");
                                kevaldate=(obj.getString("kevalgyandate")+ "");
                                mokshadate=(obj.getString("mokshadate")+ "");
                                heven=(obj.getString("heaven")+ "");
                                birthplce=(obj.getString("birthplace")+ "");
                                parents=(obj.getString("parents")+ "");
                                complex=(obj.getString("complex")+ "");
                                symbol=(obj.getString("symbol")+ "");
                                height=(obj.getString("height")+ "");
                                age=(obj.getString("age")+ "");
                                tree=(obj.getString("tree")+ "");
                                attenspirit=(obj.getString("attendentspirits")+ "");
                                disciple=(obj.getString("malefemaledisciple")+ "");
                                nirvanplace=(obj.getString("nirvanplace")+ "");
                                intro=(obj.getString("introduction")+ "");
                                stuti=(obj.getString("stuti")+ "");
                                stavan=(obj.getString("stavan")+ "");

                                photo1 = obj.getString("photo1")+"";
                                if(photo1!="") {
                                    photo1 = obj.getString("photo1").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo2 = obj.getString("photo2")+"";
                                if(photo2!="") {
                                    photo2 = obj.getString("photo2").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo3 = obj.getString("photo3")+"";
                                if(photo3!="") {
                                    photo3 = obj.getString("photo3").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo4 = obj.getString("photo4")+"";
                                if(photo4!="") {
                                    photo4 = obj.getString("photo4").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                photo5 = obj.getString("photo5")+"";
                                if(photo5!="") {
                                    photo5 = obj.getString("photo5").replace("~/", "http://www.jinalshah.brainoorja.com/");
                                }
                                mActionBar=getSupportActionBar();
                                mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

                                sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.pager1);
                                mViewPager.setAdapter(sectionPagerAdapter);
                                mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
                                {
                                    @Override
                                    public void onPageSelected(int position) {
                                        //super.onPageSelected(position);
                                        mActionBar.setSelectedNavigationItem(position);
                                    }
                                });
                                for(int i=0;i<sectionPagerAdapter.getCount();i++)
                                {
                                    mActionBar.addTab(
                                            mActionBar.newTab().setText(sectionPagerAdapter.getPageTitle(i))
                                                    .setTabListener(pager_tithankar_details.this)
                                    );
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Toast.makeText(pager_tithankar_details.this,"No Data Connection!",Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onStart() {
                            super.onStart();
                            mProgressDialog = ProgressDialog.show(pager_tithankar_details.this, "Loading", "Please Wait", true, false);
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
        getMenuInflater().inflate(R.menu.menu_pager_tithankar_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ptirthankar_menu_action_home) {
            Intent i  = new Intent(pager_tithankar_details.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.ptirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(pager_tithankar_details.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.ptirthankar_menu_action_Jainfestival) {
            Intent i = new Intent(pager_tithankar_details.this,getAllFestival.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.ptirthankar_menu_action_Jainmagazine) {
            Intent i = new Intent(pager_tithankar_details.this,get_all_magazins.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.ptirthankar_menu_action_Jainsongs) {
            Intent i = new Intent(pager_tithankar_details.this,getallJainsongs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.ptirthankar_menu_action_pachhakhanan) {
            Intent i = new Intent(pager_tithankar_details.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.ptirthankar_menu_action_sun_time) {
            Intent i  = new Intent(pager_tithankar_details.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.ptirthankar_menu_action_nearby) {
            Intent i  = new Intent(pager_tithankar_details.this,MapsActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
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
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

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
                    return tirthankar_details1.newInstance(tithankar,pastname,presantname,futurename,photo1);
                case 1:
                    return tirthankar_details2.newInstance(chyvandate,janmadate,dikshaname,kevaldate,mokshadate,heven,birthplce,parents,complex,symbol,height,age,tree,attenspirit,disciple,nirvanplace);
                case 2:
                    return trithankar_details3.newInstance(intro);
                case 3:
                    return tirthakar_details4.newInstance(stavan,stuti);
                case 4:
                    return tirthankar_details5.newInstance(photo1,photo2,photo3,photo4,photo5);
                default:
                     return tirthankar_details1.newInstance(tithankar,pastname,presantname,futurename,photo1);

            }
        }

        @Override
        public int getCount() {
            return 5;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l=Locale.getDefault();
            switch (position)
            {
                case 0:
                    return getString(R.string.Tirthankar).toUpperCase();
                case 1:
                    return getString(R.string.Tirthankar_Information).toUpperCase();
                case 2:
                    return getString(R.string.Tirthankar_history).toUpperCase();
                case 3:
                    return getString(R.string.Tirthankar_media).toUpperCase();
                case 4:
                    return getString(R.string.Tirthankar_gallary).toUpperCase();
            }
            return null;
        }
    }
}
