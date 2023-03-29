package vannes.lamy.ir4grp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
}