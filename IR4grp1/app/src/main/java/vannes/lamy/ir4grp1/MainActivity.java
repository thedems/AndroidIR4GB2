package vannes.lamy.ir4grp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText l,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recuperation des widgets
         l=findViewById(R.id.login);
         p=findViewById(R.id.pwd);
    }
    public void action_valider(View v){
        Toast.makeText(this, "Bienvenue",
                Toast.LENGTH_SHORT).show();
    }
    public void action_effacer(View v){
    l.setText("");
    p.setText("");
    }
    public void action_fermer(View v){
        finish();
    }
}