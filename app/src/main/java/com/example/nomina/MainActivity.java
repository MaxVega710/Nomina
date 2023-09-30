package com.example.nomina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       EditText txtCliente=findViewById(R.id.txtEmpleado);
       Button btnEntrar=findViewById(R.id.btnEntrar),btnCerrar=findViewById(R.id.btnCerrar);

       btnCerrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

       btnEntrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (txtCliente.getText().toString().matches("")){
                   Toast.makeText(MainActivity.this, "No ingreso un empleado", Toast.LENGTH_SHORT).show();
               }
               else {
               Intent intent=new Intent(MainActivity.this, nominaActivity.class);
               intent.putExtra("nombre",txtCliente.getText().toString());
               startActivity(intent);
               finish();}
           }
       });

    }
}