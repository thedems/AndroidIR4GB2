package vannes.lamy.ir4grp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText l,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recuperation des widgets login et password
        l=findViewById(R.id.login);
        p=findViewById(R.id.pwd);
    }

    public void clicBienvenue(View v){
        Toast.makeText(MainActivity.this,"login: "+ l.getText() + "Pwd: "+p.getText(),
                Toast.LENGTH_SHORT).show();
    }
    public void clicFermer(View v){
        finish();
    }
    public void clicEffacer(View v){
        l.setText("");
        p.setText("");
    }
}