package com.example.laboratorio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView nombre_apellido,username;
    Button contador ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        username=findViewById(R.id.username);
        nombre_apellido=findViewById(R.id.nombreapellido);

        username.setText(getIntent().getStringExtra("username"));
        nombre_apellido.setText(getIntent().getStringExtra("nombre2")+" "+getIntent().getStringExtra("apellido2"));

        contador= findViewById(R.id.contador);

        contador.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
            startActivity(intent);
        });

    }
}