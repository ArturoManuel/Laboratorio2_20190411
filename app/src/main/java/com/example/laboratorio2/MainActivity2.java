package com.example.laboratorio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {

    public TextInputEditText  nombre ,apellido, correo , contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button button = findViewById(R.id.btnRegister);
        nombre = findViewById(R.id.nombretext);
        apellido=findViewById(R.id.apellidoText);
        correo= findViewById(R.id.correo);
        contraseña=findViewById(R.id.contraseña1);


;       nombre.setText(getIntent().getStringExtra("firstName"));
        apellido.setText(getIntent().getStringExtra("lastName"));
        correo.setText(getIntent().getStringExtra("email"));
        contraseña.setText(getIntent().getStringExtra("password"));



        button.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("username",getIntent().getStringExtra("username"));
            intent.putExtra("nombre2",getIntent().getStringExtra("firstName"));
            intent.putExtra("apellido2",getIntent().getStringExtra("lastName"));

            startActivity(intent);
        });
    }
}