package com.example.calculadoradivisasjava;

import android.widget.Button;

public class Conversor {

    private float conversio = 0;
    private String ultimaMoneda = "";
    private Button btn;

    public float getConversio() {
        return conversio;
    }

    public void setConversio(float conversio) {
        this.conversio = conversio;
    }

    public String getUltimaMoneda() {
        return ultimaMoneda;
    }

    public void setUltimaMoneda(String ultimaMoneda) {
        this.ultimaMoneda = ultimaMoneda;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
