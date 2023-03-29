package vannes.lamy.ir4grp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        if(getResources().getString(R.string.login).equals(l.getText().toString()) &&
        getResources().getString(R.string.pwd).equals(p.getText().toString())){
            //declaration Intent
            Intent i=new Intent(MainActivity.this,HomeActivity.class);
            //insertion du login dans l'intent
            i.putExtra("msg",l.getText().toString());
            //lancement de la 2e activity
            startActivity(i);
        }
        else {
            Toast.makeText(this, "C'est quoi ce bordel! login ou pwd incorrect",
                    Toast.LENGTH_SHORT).show();
            action_effacer(v);
        }
    }
    public void action_effacer(View v){
    l.setText("");
    p.setText("");
    }
    public void action_fermer(View v){
        finish();
    }
}