package com.example.kbvora.arihant1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.IOException;


public class audiostavntirthankar extends ActionBarActivity {
    TextView tv;
    TextView tv1;
    Button button1;
    MediaPlayer mediaPlayer=null;
    String str,str1;
    private boolean playPause;
    private boolean intialStage = true;
    class jinal extends  AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(audiostavntirthankar.this, "downloading", Toast.LENGTH_LONG).show();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // if(mProgressDialog.isShowing())
            Toast.makeText(audiostavntirthankar.this, "Downloading Complete", Toast.LENGTH_LONG).show();

        }

        @Override
        protected String doInBackground(String... params) {
            // Environment.getRootDirectory().getPath()
            // Environment.getExternalStorageDirectory().getPath();
            String FileName = "/sdcard/"+str1+".mp3"; // save in your sdcard


            try{
                java.io.BufferedInputStream in = new java.io.BufferedInputStream(new java.net.URL(str).openStream());
                java.io.FileOutputStream fos = new java.io.FileOutputStream(FileName);
                java.io.BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
                byte[] data = new byte[1024];
                int x=0;
                while((x=in.read(data,0,1024))>=0){
                    bout.write(data,0,x);
                }
                fos.flush();
                bout.flush();
                fos.close();
                bout.close();
                in.close();
                //  Toast.makeText(audioplay.this,"download complete",Toast.LENGTH_LONG).show();
            }
            catch (Exception ex)
            {
                Toast.makeText(audiostavntirthankar.this, ex.toString(), Toast.LENGTH_LONG).show();
            }
            return null;
        }
    }
    class Player extends AsyncTask<String, Void, Boolean> {
        private ProgressDialog progress;

        @Override
        protected Boolean doInBackground(String... params) {
            // TODO Auto-generated method stub
            Boolean prepared;
            try {

                mediaPlayer.setDataSource(params[0]);

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // TODO Auto-generated method stub
                        intialStage = true;
                        playPause=false;
                        // btn.setBackgroundResource(R.drawable.button_play);
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.prepare();
                prepared = true;
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                Log.d("IllegarArgument", e.getMessage());
                prepared = false;
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            }
            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            if (progress.isShowing()) {
                progress.cancel();
            }
            Log.d("Prepared", "//" + result);
            mediaPlayer.start();

            intialStage = false;
        }

        public Player() {
            progress = new ProgressDialog(audiostavntirthankar.this);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            this.progress.setMessage("Buffering...");
            this.progress.show();

        }
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiostavntirthankar);
        Intent it=getIntent();
        str=it.getStringExtra("path");
        str1=str.substring(19,str.length());
        str=str.replace("~/","http://www.jinalshah.brainoorja.com/");


        button1=(Button)findViewById(R.id.button111);

        tv1=(TextView)findViewById(R.id.MarqueeText111);

        tv1.setText(str1+"                          "+str1);
        tv1.setSelected(true);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        button1.setOnClickListener(pausePlay);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
        getSupportActionBar().setTitle(str1);
    }
    private View.OnClickListener pausePlay = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            // TODO Auto-generated method stub

            if (!playPause) {
                button1.setBackgroundResource(R.drawable.pause);//pause
                if (intialStage)
                    new Player()
                            .execute(str);
                else {
                    if (!mediaPlayer.isPlaying())
                        mediaPlayer.start();
                }
                playPause = true;
            } else {
                button1.setBackgroundResource(R.drawable.play);//play
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
                playPause = false;
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_audiostavntirthankar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.download2) {
            new jinal().execute(str);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
