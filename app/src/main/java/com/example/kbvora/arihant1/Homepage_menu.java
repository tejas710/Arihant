package com.example.kbvora.arihant1;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Homepage_menu extends ActionBarActivity {

    private static long back_press;

    @Override
    public void onBackPressed() {
        if(back_press + 2000 > System.currentTimeMillis())super.onBackPressed();
        else Toast.makeText(getBaseContext(),"Press once again to exit!",Toast.LENGTH_SHORT).show();
        back_press = System.currentTimeMillis();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_menu);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));




    }

    public void gotonext(View v)
    {   Intent i;

        int ch = v.getId();
        Log.i("ch", ch + "seekbar_progress");
        switch(ch) {
            case R.id.homepage_menu_tirthankarbtn:

                i = new Intent(Homepage_menu.this, Tirthankar.class);
                startActivity(i);
                break;
            case R.id.homepage_menu_tirthplacebtn:

                i = new Intent(Homepage_menu.this, getalltirthplace.class);
                startActivity(i);
                break;
            case R.id.homepage_menu_festivalbtn:

                i = new Intent(Homepage_menu.this, getAllFestival.class);
                startActivity(i);
                break;
            case R.id.homepage_menu_jainmagazinebtn:
                i = new Intent(Homepage_menu.this, get_all_magazins.class);
                startActivity(i);
                break;
            case R.id.homepage_menu_pachhakhanbtn:
                i = new Intent(Homepage_menu.this, allpachakhan.class);
                startActivity(i);
                break;
            case R.id.homepage_menu_sunsetsunrisebtn:
                i = new Intent(Homepage_menu.this, Pager_suntime.class);
                startActivity(i);
                break;
            case R.id.homepage_menu_jainsongsbtn:
                i = new Intent(Homepage_menu.this, getallJainsongs.class);
                startActivity(i);

                break;
            case R.id.homepage_menu_map:
                i = new Intent(Homepage_menu.this, MapsActivity.class);
                startActivity(i);

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.homepage_menu_action_Tirthplace) {

            Intent i  = new Intent(Homepage_menu.this,about_us.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.homepage_menu_action_Tirthankar) {
            Intent i  = new Intent(Homepage_menu.this,Contact_us.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.homepage_menu_action_Jainfestival) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:arihant072912@gmail.com"));

            intent.putExtra(Intent.EXTRA_TEXT,"");
            startActivity(intent);

            return true;
        }

        if (id == R.id.homepage_menu_action_Jainsongs) {
            Intent i  = new Intent(Homepage_menu.this,MapsActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.homepage_menu_action_pachhakhanan) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "http://www.google.kbvora.tejas/");
            startActivity(Intent.createChooser(intent, "Share via"));
            return true;
        }

        if (id== R.id.homepage_menu_action_shere)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "http://www.google.kbvora.tejas/");
            startActivity(Intent.createChooser(intent, "Share via"));
                return  true;
        }




        return super.onOptionsItemSelected(item);
    }

}
