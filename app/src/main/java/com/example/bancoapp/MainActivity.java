package com.example.bancoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNumCuenta,etNombre,etBanco,etSaldo;
    Button btnEnviar,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumCuenta.findViewById(R.id.etNumCuenta);
        etNombre.findViewById(R.id.etNombre);
        etBanco.findViewById(R.id.etBanco);
        etSaldo.findViewById(R.id.etSaldo);
        btnEnviar.findViewById(R.id.btnEnviar);
        btnSalir.findViewById(R.id.btnSalir);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numCuenta= etNumCuenta.getText().toString();
                String nombre= etNombre.getText().toString();
                String banco= etBanco.getText().toString();
                Float saldo= Float.parseFloat(etSaldo.getText().toString());


                if (etNombre.getText().toString().isEmpty()||
                        etNumCuenta.getText().toString().isEmpty()||
                        etBanco.getText().toString().isEmpty()
                        ||etSaldo.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Ingrese todos os datos antes de enviarlo", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intentCuenta = new Intent(MainActivity.this,CuentaBanco.class);
                    intentCuenta.putExtra("numCuenta",numCuenta);
                    intentCuenta.putExtra("nombre",nombre);
                    intentCuenta.putExtra("banco",banco);
                    intentCuenta.putExtra("saldo",saldo);
                    startActivity(intentCuenta);
                }

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}