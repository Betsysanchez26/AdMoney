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
public class Recurrentes {

    public int idRecurrentes;

    public String nombre;

    public float cantidad;

    public String fecha;

    public Recurrentes(int idRecurrentes, String nombre, float cantidad, String fecha) {
        this.idRecurrentes = idRecurrentes;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
}

