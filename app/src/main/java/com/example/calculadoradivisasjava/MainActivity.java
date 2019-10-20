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

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    Conversor conversor = new Conversor();

    @Override
    public void onCreate(Bundle savedInstanceState) {
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

        btnComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addcoma(',', tvIn);
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netejarPantalla(tvIn, tvOut);
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
                conversor = fctConversio((String)btnDollar.getText(), conversor, btnDollar, tvIn, tvOut);
            }
        });

        btnLibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnLibra.getText(), conversor, btnLibra, tvIn, tvOut);
            }
        });

        btnYen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnYen.getText(), conversor, btnYen, tvIn, tvOut);
            }
        });

        btnYuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor = fctConversio((String)btnYuan.getText(), conversor, btnYuan, tvIn, tvOut);
            }
        });

    }

    private void addnumero(int num, TextView tvIn) {
        String tvContent;
        String actualString = "";
        int actualInt;
        float actualFloat = 0;
        int index = 0;

        tvContent = tvIn.getText().toString();

        if (tvContent.length() < 7) {

            if (!tvContent.contains(",")) {

                actualInt = Integer.parseInt(tvContent);

                if (actualInt == 0) {
                    tvIn.setText("");

                    tvContent = String.valueOf(actualInt + num);
                    tvIn.setText(tvContent);

                } else {
                    tvContent = String.valueOf(num);
                    tvContent = String.valueOf(actualInt + tvContent);
                    tvIn.setText(tvContent);
                }

            } else {

                if (tvContent.charAt(tvContent.length() - 1) == ',') {

                    index = tvContent.indexOf(",");
                    tvContent = tvContent.substring(0, (tvContent.length() - 1));
                    actualFloat = Float.parseFloat(tvContent);
                    actualString = String.valueOf(actualFloat);
                    actualString = actualString.substring(0, (actualString.length() - 2)) + ",";
                }

                if ((tvContent.length() - 2) != index) {

                    tvContent = String.valueOf(num);
                    tvContent = String.valueOf(actualString + tvContent);
                    tvIn.setText((tvContent));
                }
            }
        }
    }

    private void addcoma(char coma, TextView tvIn) {

        String tvContent;

        tvContent = tvIn.getText().toString();

        if (!tvContent.contains(",")) {

            tvContent = tvContent + coma;

            tvIn.setText(tvContent);

        } else {

            tvIn.setText(tvContent);

        }
    }

    private void operacio(TextView tvIn, TextView tvOut, Conversor conversor) {

        float fctConversio;
        float inText;
        float outFloat;
        String outText;

        fctConversio = conversor.getConversio();
        inText = Float.parseFloat(tvIn.getText().toString());
        outFloat = inText*fctConversio;

        outText = String.valueOf(outFloat);

        outText = truncate(outText, 2);

        tvOut.setText(outText);
    }

    private String truncate(String value, int places) {
        return new BigDecimal(value).setScale(places, RoundingMode.DOWN).stripTrailingZeros().toString();
    }

    private Conversor fctConversio(String moneda, Conversor conversor, Button btnClicked, TextView tvIn, TextView tvOut) {

        String ultimaMoneda;

        ultimaMoneda = conversor.getUltimaMoneda();

        if (!ultimaMoneda.equals(moneda)) {

            dialogConEditText(moneda, conversor, btnClicked);

            tvIn.setText("0");
            tvOut.setText("0");

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
                float conversioF;
                Button ultimaMoneda;

                ultimaMoneda = conversor.getBtn();
                conversio = edtValor.getText().toString();
                conversioF = Float.parseFloat(conversio);

                if (ultimaMoneda != null) {
                    ultimaMoneda.setBackgroundColor(Color.parseColor("#ABABAB"));
                }

                conversor.setConversio(conversioF);
                conversor.setUltimaMoneda(moneda);
                conversor.setBtn(btnClicked);

                btnClicked.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        ad.show();

        // el Show es asíncrono.
    }

    private void eliminarNumero(TextView tvIn) {

        String text = (String) tvIn.getText();
        String newText;

        if (text.length() > 1) {

            newText = text.substring(0, (text.length() - 1));
            tvIn.setText(newText);

        } else {
            tvIn.setText("0");
        }
    }

    private void netejarPantalla(TextView tvIn, TextView tvOut) {

        tvIn.setText("0");
        tvOut.setText("0");

    }
}
