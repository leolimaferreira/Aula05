/*
 *@author:<Leonardo Lima 1110482423021>
 */
package com.example.aula05;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula05.model.ContaBancaria;
import com.example.aula05.model.ContaEspecial;
import com.example.aula05.model.ContaPoupanca;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbPoupanca;
    private RadioButton rbEspecial;
    private EditText etNumConta;
    private EditText etNome;
    private EditText etSaldoAtual;
    private EditText etLimite;
    private EditText etValor;
    private EditText etDiasRendimento;
    private EditText etTaxa;
    private Button btnSacar;
    private Button btnDepositar;
    private TextView tvSaldo;
    private TextView tvDados;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbPoupanca = findViewById(R.id.rbPoupanca);
        rbPoupanca.setChecked(true);
        rbEspecial = findViewById(R.id.rbEspecial);
        etNumConta = findViewById(R.id.etNumConta);
        etNome = findViewById(R.id.etNome);
        etSaldoAtual = findViewById(R.id.etSaldoAtual);
        etLimite = findViewById(R.id.etLimite);
        etValor = findViewById(R.id.etValor);
        etDiasRendimento = findViewById(R.id.etDiasRendimento);
        etTaxa = findViewById(R.id.etTaxa);
        btnSacar = findViewById(R.id.btnSacar);
        btnDepositar = findViewById(R.id.btnDepositar);
        tvSaldo = findViewById(R.id.tvSaldo);
        tvDados = findViewById(R.id.tvDados);

        btnSacar.setOnClickListener(op -> saque());
        btnDepositar.setOnClickListener(op -> deposito());



    }

    private void deposito() {
        if(rbPoupanca.isChecked()) {
            ContaPoupanca conta = new ContaPoupanca();
            conta.setNumConta(Integer.parseInt(etNumConta.getText().toString()));
            conta.setCliente(etNome.getText().toString());
            conta.setSaldo(Double.parseDouble(etSaldoAtual.getText().toString()));
            conta.setDiaRendimento(Integer.parseInt(etDiasRendimento.getText().toString()));
            conta.depositar(Double.parseDouble(etValor.getText().toString()));
            conta.calcularNovoSaldo(Double.parseDouble(etTaxa.getText().toString()));
            BigDecimal sal = BigDecimal.valueOf(conta.getSaldo()).setScale(2, RoundingMode.HALF_UP);
            tvSaldo.setText(getString(R.string.SaldoFinal) + sal);
            tvDados.setText(getString(R.string.NumeroConta) + conta.getNumConta() + getString(R.string.NomeCliente) + conta.getCliente());
        }
        if(rbEspecial.isChecked()) {
            ContaEspecial conta = new ContaEspecial();
            conta.setNumConta(Integer.parseInt(etNumConta.getText().toString()));
            conta.setCliente(etNome.getText().toString());
            conta.setSaldo(Double.parseDouble(etSaldoAtual.getText().toString()));
            conta.setLimite(Float.parseFloat(etLimite.getText().toString()));
            conta.depositar(Double.parseDouble(etValor.getText().toString()));
            BigDecimal sal = BigDecimal.valueOf(conta.getSaldo()).setScale(2, RoundingMode.HALF_UP);
            tvSaldo.setText(getString(R.string.SaldoFinal) + sal);
            tvDados.setText(getString(R.string.NumeroConta) + conta.getNumConta() + getString(R.string.NomeCliente) + conta.getCliente());

        }
    }

    private void saque() {
        if(rbPoupanca.isChecked()) {
            ContaPoupanca conta = new ContaPoupanca();
            conta.setNumConta(Integer.parseInt(etNumConta.getText().toString()));
            conta.setCliente(etNome.getText().toString());
            conta.setSaldo(Double.parseDouble(etSaldoAtual.getText().toString()));
            conta.setDiaRendimento(Integer.parseInt(etDiasRendimento.getText().toString()));
            conta.sacar(Double.parseDouble(etValor.getText().toString()));
            if(conta.getSaldo() == Float.parseFloat(etSaldoAtual.getText().toString())) {
                tvSaldo.setText(getString(R.string.ErroSaquePoupanca));
                tvDados.setText(getString(R.string.NumeroConta) + conta.getNumConta() + getString(R.string.NomeCliente) + conta.getCliente());

            } else {
                tvSaldo.setText(getString(R.string.SaldoFinal) + conta.getSaldo());
                tvDados.setText(getString(R.string.NumeroConta) + conta.getNumConta() + getString(R.string.NomeCliente) + conta.getCliente());

            }
        }

        if(rbEspecial.isChecked()) {
            ContaEspecial conta = new ContaEspecial();
            conta.setNumConta(Integer.parseInt(etNumConta.getText().toString()));
            conta.setCliente(etNome.getText().toString());
            conta.setSaldo(Double.parseDouble(etSaldoAtual.getText().toString()));
            conta.setLimite(Float.parseFloat(etLimite.getText().toString()));
            conta.sacar(Double.parseDouble(etValor.getText().toString()));
            if(conta.getSaldo() == Float.parseFloat(etSaldoAtual.getText().toString())) {
                tvSaldo.setText(getString(R.string.ErroSaqueEspecial));
                tvDados.setText(getString(R.string.NumeroConta) + conta.getNumConta() + getString(R.string.NomeCliente) + conta.getCliente());

            } else {
                tvSaldo.setText(getString(R.string.SaldoFinal) + conta.getSaldo());
                tvDados.setText(getString(R.string.NumeroConta) + conta.getNumConta() + getString(R.string.NomeCliente) + conta.getCliente());
            }
        }
    }
}