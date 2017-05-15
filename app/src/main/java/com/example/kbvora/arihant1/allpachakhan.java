package com.example.kbvora.arihant1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.GpsStatus;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class allpachakhan extends ActionBarActivity {
    ArrayList<pachakhan> mArrayList;
    ListView mListView;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allpachakhan);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
        mArrayList=new ArrayList<pachakhan>();
        mListView=(ListView)findViewById(R.id.pachakhanlistView);
        mArrayList.add( new pachakhan("Ayambil Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/1.mp3"));
        mArrayList.add( new pachakhan("Chhath Attham Atthai Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/2.mp3"));
        mArrayList.add( new pachakhan("Chovihar Upvaas Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/3.mp3"));
        mArrayList.add( new pachakhan("Choviyaar Upvaas Evening Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/4.mp3"));
        mArrayList.add( new pachakhan("Deshavagasik Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/5.mp3"));
        mArrayList.add( new pachakhan("Dharna Abhigraham Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/6.mp3"));
        mArrayList.add( new pachakhan("Ekasanu Evening Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/7.mp3"));
        mArrayList.add( new pachakhan("Ekasanu Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/8.mp3"));
        mArrayList.add( new pachakhan("Ekasanu Parvwanu Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/9.mp3"));
        mArrayList.add( new pachakhan("Muthi Sahiam Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/10.mp3"));
        mArrayList.add( new pachakhan("Navkarshi Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/11.mp3"));
        mArrayList.add( new pachakhan("Panhar Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/12.mp3"));
        mArrayList.add( new pachakhan("Porshi Sadporshi Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/13.mp3"));
        mArrayList.add( new pachakhan("Purimaddh Avaddh Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/14.mp3"));
        mArrayList.add( new pachakhan("Tivihar Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/15.mp3"));
        mArrayList.add( new pachakhan("Tivihar Upvaas Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/16.mp3"));
        mArrayList.add( new pachakhan("Tivihar Upvaas Parvwanu Pachakhan","http://www.jinalshah.brainoorja.com/pachkhan/17.mp3"));
        mListView.setAdapter(new pachakhan_custom_adpter(allpachakhan.this, mArrayList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                pachakhan p=(pachakhan)parent.getItemAtPosition(position);

                Intent it=new Intent(allpachakhan.this,Audioplaypavhakhan.class);
                it.putExtra("name",p.getPname()+"");
                it.putExtra("path",p.getPpath()+"");
                startActivity(it);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_allpachakhan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatemen
        if (id == R.id.pactirthankar_menu_action_home) {
            Intent i  = new Intent(allpachakhan.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.pactirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(allpachakhan.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.pactirthankar_menu_action_Tirthankar) {
            Intent i = new Intent(allpachakhan.this,Tirthankar.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.pactirthankar_menu_action_Jainmagazine) {
            Intent i = new Intent(allpachakhan.this,get_all_magazins.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.pactirthankar_menu_action_Jainsongs) {
            Intent i = new Intent(allpachakhan.this,getallJainsongs.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.pactirthankar_menu_action_sun_time) {
            Intent i  = new Intent(allpachakhan.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.pactirthankar_menu_action_nearby) {
            Intent i  = new Intent(allpachakhan.this,MapsActivity.class);
            startActivity(i);

            return true;
        }



        return super.onOptionsItemSelected(item);
    }


}
