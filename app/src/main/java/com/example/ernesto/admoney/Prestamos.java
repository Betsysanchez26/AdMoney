package com.example.ernesto.admoney;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jesus on 23/03/17.
 */
public class Prestamos {

    public int idPrestamos;

    public int idEgresos;

    public String descripcion;

    public Prestamos(int idPrestamos, int idEgresos, String descripcion) {
        this.idPrestamos = idPrestamos;
        this.idEgresos = idEgresos;
        this.descripcion = descripcion;
    }
}

