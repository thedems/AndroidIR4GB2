package vannes.lamy.ir4grp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
TextView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Récuperation de l'intent envoyé de notre activity principale
        Intent i = getIntent();
            //recuperation du login
        String login = i.getStringExtra("msg");
        //recuperation du widget textview
        w= findViewById(R.id.Welcome);
        w.setText("Bienvenue"  + login.toString());
    }
}