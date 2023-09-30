package com.example.nomina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class nominaActivity extends AppCompatActivity {

    private Button btnCalcular,btnLimpiar,btnCerrar;
    private TextView lblEmpleado,subTotal,impuesto,total;
    private EditText txtNumRecibo,txtNombreEmpleado,txtHorasTrabajadas,txtHorasExtras;
private RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomina);
        btnCalcular=findViewById(R.id.btnCalcular);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnCerrar=findViewById(R.id.btnCerrar);
        lblEmpleado=findViewById(R.id.lblEmpleado);
        txtNumRecibo=findViewById(R.id.txtNumRecibo);
        txtNombreEmpleado=findViewById(R.id.txtNombre);
        txtHorasTrabajadas=findViewById(R.id.txtHorasTrabajadas);
        txtHorasExtras=findViewById(R.id.txtHorasExtras);
       rb1=findViewById(R.id.rb1);
       rb2=findViewById(R.id.rb2);
       rb3=findViewById(R.id.rb3);
        subTotal=findViewById(R.id.lblSubtotal);
        impuesto=findViewById(R.id.lblImpuesto);
        total=findViewById(R.id.lblTotal);

     String empleado= getIntent().getStringExtra("nombre");
     lblEmpleado.setText(empleado);
     txtNombreEmpleado.setText(empleado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empleado= getIntent().getStringExtra("nombre");
                lblEmpleado.setText(""+empleado);
                txtNombreEmpleado.setText(empleado);
                if (txtHorasExtras.getText().toString().matches("")||
                        txtHorasTrabajadas.getText().toString().matches("")||
                txtNumRecibo.getText().toString().matches("")
                ){
                    Toast.makeText(nominaActivity.this, "No ingreso datos", Toast.LENGTH_SHORT).show();
                }
                else{
                   nomina nom=new nomina();
                    int puesto=0;
                    if(rb1.isChecked()){
                        puesto=1;
                    } else if (rb2.isChecked()) {
                        puesto=2;
                    } else if (rb3.isChecked()) {
                        puesto=3;
                    }

                   nom.setNombre(empleado);
                   nom.setPuesto(puesto);
                   nom.setNumRecibo(Integer.parseInt(txtNumRecibo.getText().toString()));
                   nom.setHorasTrabNormal(Float.parseFloat(txtHorasTrabajadas.getText().toString()));
                   nom.setHorasTrabExtras(Float.parseFloat(txtHorasExtras.getText().toString()));
                   subTotal.setText("Subtotal: $"+nom.calcularSubtotal());
                   impuesto.setText("Impuesto: $"+nom.calcularImpuesto());
                   total.setText("Total: $"+nom.calcularTotal());
                }
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(nominaActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

btnLimpiar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        txtHorasExtras.setText("");
        txtHorasTrabajadas.setText("");
        txtNumRecibo.setText("");
        subTotal.setText("Subtotal: $");
        impuesto.setText("Impuesto: $");
        total.setText("Total: $");
    }
});

    }


}