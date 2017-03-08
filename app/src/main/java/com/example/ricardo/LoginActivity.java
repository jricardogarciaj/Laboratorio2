package com.example.ricardo.santafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, eContrasena;
    Button bIniciar;
    TextView tRegistrarse;
    String username = "camarada", password = "alienigena", correo = "", registrado="no";
    int num =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bIniciar = (Button) findViewById(R.id.bIngresar);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);

        //Toast.makeText(this, extras.toString("username"),Toast.LENGTH_LONG).show();*/

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent, 1234);
                //mandar datos
                //intent.putExtra("username", eRUsuario.getText().toString());
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar que el usuario y contrasña sean iguales a los recibidos

                if(registrado.equals("si")){
                    Bundle extras = getIntent().getExtras();
                    username = extras.getString("username");
                    password = extras.getString("password");
                    correo = extras.getString("correo");
                    //registrado = extras.getString("registrado");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("correo", correo);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }

                else if (registrado.equals("no") && eUsuario.getText().toString().equals(username) && eContrasena.getText().toString().equals(password)) {
                    //registrado = "si";
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("correo", correo);
                    intent.putExtra("password", password);
                    intent.putExtra("registrado", registrado);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(),"Error en los datos",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
            num=1;
            Log.d("nombre",data.getExtras().getString("username"));
            Log.d("correo",data.getExtras().getString("correo"));
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en registro",Toast.LENGTH_SHORT).show();
        }
    }
}
