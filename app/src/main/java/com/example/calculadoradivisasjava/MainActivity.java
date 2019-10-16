package com.example.calculadoradivisasjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Conversor conversor = new Conversor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);
        Button btnComa = findViewById(R.id.btnComa);
        Button btnIgual = findViewById(R.id.btnIgual);
        Button btnCE = findViewById(R.id.btnCE);
        Button btnDEL = findViewById(R.id.btnDEL);
        final Button btnLibra = findViewById(R.id.btnLibra);
        final Button btnYen = findViewById(R.id.btnYen);
        final Button btnDollar = findViewById(R.id.btnDollar);
        final Button btnYuan = findViewById(R.id.btnYuan);
        final TextView tvIn = findViewById(R.id.tvIn);
        final TextView tvOut = findViewById(R.id.tvOut);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(1, tvIn);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(2, tvIn);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(3, tvIn);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(4, tvIn);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(5, tvIn);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(6, tvIn);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(7, tvIn);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(8, tvIn);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(9, tvIn);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnumero(0, tvIn);
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netejarPantalla(tvIn);
            }
        });

        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarNumero(tvIn);
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacio(tvIn, tvOut, conversor);
            }
        });

        btnDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnDollar.getText(), conversor, btnDollar);
            }
        });

        btnLibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnLibra.getText(), conversor, btnLibra);
            }
        });

        btnYen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnYen.getText(), conversor, btnYen);
            }
        });

        btnYuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnYuan.getText(), conversor, btnYuan);
            }
        });

    }

    protected void addnumero(int num, TextView tvIn) {
        String tvContent;
        int actualInt = 0;

        tvContent = (String) tvIn.getText();

        if (tvContent.length() < 6) {

            actualInt = Integer.parseInt(tvContent);

            if (actualInt == 0) {
                tvIn.setText("");

                actualInt = actualInt + num;
                tvContent = String.valueOf(actualInt);
                tvIn.setText(tvContent);

            } else {

                tvContent = String.valueOf(actualInt);
                tvIn.setText(tvContent + num);
            }
        }
    }

    protected void operacio(TextView tvIn, TextView tvOut, Conversor conversor) {



    }

    protected Conversor fctConversio(String moneda, Conversor conversor, Button btnClicked) {

        float conversio;
        String ultimaMoneda;

        ultimaMoneda = conversor.getUltimaMoneda();

        if (!ultimaMoneda.equals(moneda)) {

            dialogConEditText(moneda, conversor, btnClicked);

        }

        return conversor;
    }

    private void dialogConEditText(final String moneda, final Conversor conversor, final Button btnClicked) {
        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("Factor de conversió");
        ad.setMessage("Quin es el factor de conversió del " + moneda);

        // Ahora forzamos que aparezca el editText
        final EditText edtValor = new EditText(this);
        ad.setView(edtValor);

        ad.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                String conversio;

                conversio = edtValor.getText().toString();

                conversor.setConversio(Float.parseFloat(conversio));
                conversor.setUltimaMoneda(moneda);
                conversor.setBtn(btnClicked);

                btnClicked.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        ad.show();

        // el Show es asíncrono.
    }

    protected void eliminarNumero(TextView tvIn) {

        String text = (String) tvIn.getText();
        String newText;

        if (text.length() > 1) {

            newText = text.substring(0, (text.length() - 1));
            tvIn.setText(newText);

        } else {
            tvIn.setText("0");
        }
    }

    protected void netejarPantalla(TextView tvIn) {

        tvIn.setText("0");

    }
}
