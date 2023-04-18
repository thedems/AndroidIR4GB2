package vannes.lamy.ir4grp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //recuperation de l'intent
        Intent i=getIntent();
        //recuperation du login
        String login= i.getStringExtra("msg");
        //affichage du toast
        Toast.makeText(this, "Bienvenue "+ login, Toast.LENGTH_SHORT).show();
    }
    public void action_tel(View v){
        //TODO ajouter les permissions dans l'androidmanifest
        //<uses-permission android:name="android.permission.CALL_PHONE"/>
        startActivity(new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:0123123456")));
    }
    public void action_alarme(View v){
        //TODO ajouter les permissions dans l'androidmanifest
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarme ESAIP");
        i.putExtra(AlarmClock.EXTRA_HOUR, 18);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 15);
        startActivity(i);
    }
    public void action_esaip(View v){
        String url = "https://www.esaip.org/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void action_video(View v){
        Intent i=new Intent(HomeActivity.this, VideoActivity.class);
        startActivity(i);
    }
    public void action_fermer(View v){
        finish();
    }

}