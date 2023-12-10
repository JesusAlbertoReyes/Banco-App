package com.example.bancoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CuentaBanco extends AppCompatActivity {

    private TextView nombreBanco,nombreCliente,tvSaldo;
    private EditText etCantidad;
    private Button btnDeposito,btnRetiro,btnRegresar;

    private Cuenta cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_banco);

        cuenta = new Cuenta();

        String nombre = getIntent().getStringExtra("nombre");
        String banco = getIntent().getStringExtra("banco");
        String numCuenta = getIntent().getStringExtra("numCuenta");
        String saldoString = getIntent().getStringExtra("saldo");

        nombreBanco=findViewById(R.id.tvNombreBanco);
        nombreCliente=findViewById(R.id.tvNombre);
        tvSaldo=findViewById(R.id.tvSaldo);
         btnRetiro=findViewById(R.id.btnRetiro);
        btnDeposito=findViewById(R.id.btnDeposito);
        btnRegresar=findViewById(R.id.btnRegresar);


        nombreBanco.setText(banco);
        nombreCliente.setText(nombre);
        tvSaldo.setText("Saldo:$"+saldoString);

        btnDeposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cantidadString = etCantidad.getText().toString();
                if (!cantidadString.isEmpty()) {
                    float cantidad = Float.parseFloat(cantidadString);
                    cuenta.setSaldo(cuenta.getSaldo() + cantidad);
                    actualizarSaldo();
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRetiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cantidadString = etCantidad.getText().toString();
                if (!cantidadString.isEmpty()) {
                    float cantidad = Float.parseFloat(cantidadString);
                    if (cantidad <= cuenta.getSaldo()) {
                        cuenta.setSaldo(cuenta.getSaldo() - cantidad);
                        actualizarSaldo();
                    } else {
                        Toast.makeText(getApplicationContext(), "Fondos insuficientes", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void actualizarSaldo() {
        tvSaldo.setText("Saldo: $" + cuenta.getSaldo());
    }
}