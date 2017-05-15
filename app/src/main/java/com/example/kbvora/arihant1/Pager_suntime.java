package com.example.kbvora.arihant1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Locale;


public class Pager_suntime extends ActionBarActivity implements suntime_fregment.OnFragmentInteractionListener , ActionBar.TabListener {
    ArrayList<suntime> mArrayList;
    SectionPagerAdapter sectionPagerAdapter;
    ViewPager mViewPager;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_suntime);
        mArrayList = new ArrayList<suntime>();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));


        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/1.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/2.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/3.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/4.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/5.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/6.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/7.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/8.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/9.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/10.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/11.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/12.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/13.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/14.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/15.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/16.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/17.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/18.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/19.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/20.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/21.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/22.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/23.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/24.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/25.png"));
        mArrayList.add(new suntime("http://www.jinalshah.brainoorja.com//suntime/26.png"));

        try {
            mActionBar = getSupportActionBar();
            mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
            mViewPager = (ViewPager) findViewById(R.id.pager2sun);
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
                                .setTabListener((Pager_suntime.this)
                                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pager_suntime, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.suntirthankar_menu_action_home) {
            Intent i  = new Intent(Pager_suntime.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.suntirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(Pager_suntime.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.suntirthankar_menu_action_Tirthankar) {
            Intent i = new Intent(Pager_suntime.this,Tirthankar.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.suntirthankar_menu_action_Jainsongs) {
            Intent i = new Intent(Pager_suntime.this,getallJainsongs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.suntirthankar_menu_action_Jainfestival) {
            Intent i  = new Intent(Pager_suntime.this,getAllFestival.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.suntirthankar_menu_action_Jainmagazine) {
            Intent i = new Intent(Pager_suntime.this,get_all_magazins.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.suntirthankar_menu_action_pachhakhanan) {
            Intent i = new Intent(Pager_suntime.this,allpachakhan.class);
            startActivity(i);

            return true;
        }


        if (id == R.id.suntirthankar_menu_action_nearby) {
            Intent i  = new Intent(Pager_suntime.this,MapsActivity.class);
            startActivity(i);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

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
            switch (position) {
                case 1:
                    return suntime_fregment.newInstance(mArrayList.get(0).getTpath() + "");

                case 2:
                    return suntime_fregment.newInstance(mArrayList.get(1).getTpath() + "");
                case 3:
                    return suntime_fregment.newInstance(mArrayList.get(2).getTpath() + "");
                case 4:
                    return suntime_fregment.newInstance(mArrayList.get(3).getTpath() + "");
                case 5:
                    return suntime_fregment.newInstance(mArrayList.get(4).getTpath() + "");
                case 6:
                    return suntime_fregment.newInstance(mArrayList.get(5).getTpath() + "");
                case 7:
                    return suntime_fregment.newInstance(mArrayList.get(6).getTpath() + "");
                case 8:
                    return suntime_fregment.newInstance(mArrayList.get(7).getTpath() + "");
                case 9:
                    return suntime_fregment.newInstance(mArrayList.get(8).getTpath() + "");
                case 10:
                    return suntime_fregment.newInstance(mArrayList.get(9).getTpath() + "");
                case 11:
                    return suntime_fregment.newInstance(mArrayList.get(10).getTpath() + "");
                case 12:
                    return suntime_fregment.newInstance(mArrayList.get(11).getTpath() + "");
                case 13:
                    return suntime_fregment.newInstance(mArrayList.get(12).getTpath() + "");
                case 14:
                    return suntime_fregment.newInstance(mArrayList.get(13).getTpath() + "");
                case 15:
                    return suntime_fregment.newInstance(mArrayList.get(14).getTpath() + "");
                case 16:
                    return suntime_fregment.newInstance(mArrayList.get(15).getTpath() + "");
                case 17:
                    return suntime_fregment.newInstance(mArrayList.get(16).getTpath() + "");
                case 18:
                    return suntime_fregment.newInstance(mArrayList.get(17).getTpath() + "");
                case 19:
                    return suntime_fregment.newInstance(mArrayList.get(18).getTpath() + "");
                case 20:
                    return suntime_fregment.newInstance(mArrayList.get(19).getTpath() + "");
                case 21:
                    return suntime_fregment.newInstance(mArrayList.get(20).getTpath() + "");
                case 22:
                    return suntime_fregment.newInstance(mArrayList.get(21).getTpath() + "");
                case 23:
                    return suntime_fregment.newInstance(mArrayList.get(22).getTpath() + "");
                case 24:
                    return suntime_fregment.newInstance(mArrayList.get(23).getTpath() + "");
                case 25:
                    return suntime_fregment.newInstance(mArrayList.get(24).getTpath() + "");
                case 26:
                    return suntime_fregment.newInstance(mArrayList.get(25).getTpath() + "");
                default:
                    return suntime_fregment.newInstance(mArrayList.get(0).getTpath() + "");
            }
        }

        @Override
        public int getCount() {
            return 26;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l=Locale.getDefault();
            switch (position)
            {
                case 0:
                    return "Kartak Sud".toUpperCase();
                case 1:
                    return "Kartak Vad".toUpperCase();
                case 2:
                    return "Magshar Sud".toUpperCase();
                case 3:
                    return "Magshar Vad".toUpperCase();
                case 4:
                    return "Posh Sud".toUpperCase();
                case 5:
                    return "Posh Vad".toUpperCase();
                case 6:
                    return "Maha Sud".toUpperCase();
                case 7:
                    return "Maha Vad".toUpperCase();
                case 8:
                    return "Fagan Sud".toUpperCase();
                case 9:
                    return "Fagan Vad".toUpperCase();
                case 10:
                    return "Chaitra Sud".toUpperCase();
                case 11:
                    return "Chaitra Vad".toUpperCase();
                case 12:
                    return "Vaishakh Sud".toUpperCase();
                case 13:
                    return "Vaishakh Vad".toUpperCase();
                case 14:
                    return "Jeth Sud".toUpperCase();
                case 15:
                    return "Jeth Vad".toUpperCase();
                case 16:
                    return "Adhik Ashadh Sud".toUpperCase();
                case 17:
                    return "Adhik Ashadh Vad".toUpperCase();
                case 18:
                    return "Nij Ashadh Sud".toUpperCase();
                case 19:
                    return "Nij Ashadh Vad".toUpperCase();
                case 20:
                    return "Sharavan Sud".toUpperCase();
                case 21:
                    return "Sharavan Vad".toUpperCase();
                case 22:
                    return "Bhadarvo Sud".toUpperCase();
                case 23:
                    return "Bhadarvo Vad".toUpperCase();
                case 24:
                    return "Aso Sud".toUpperCase();
                case 25:
                    return "Aso Vad".toUpperCase();



            }
            return null;
        }
    }
}
