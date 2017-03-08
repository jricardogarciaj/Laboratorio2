package com.example.ricardo.santafe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String username, correo, password, registrado ="si";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        correo = extras.getString("correo");
        password = extras.getString("password");
        intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("username",username);
        intent.putExtra("password",password);
        intent.putExtra("correo",correo);
        intent.putExtra("registrado", registrado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.mPerfil:
                intent = new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("correo",correo);
                intent.putExtra("registrado", registrado);
                startActivity(intent);

                finish();
                break;
        }
        return true;
    }
}
