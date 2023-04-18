package vannes.lamy.ir4grp1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //recuperation du videoView
        VideoView myvideoView= findViewById(R.id.videoView);
        //creation de l' URI
        Uri raw_uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bigbunny);
        myvideoView.setVideoURI(raw_uri);
        myvideoView.setMediaController(new MediaController(this));
        myvideoView.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //recuperation de l'id du menu
        int id=item.getItemId();
        if(id==R.id.close){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}