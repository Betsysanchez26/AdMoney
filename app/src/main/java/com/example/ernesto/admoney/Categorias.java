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
public class Categorias {

    public int idCategoriasTipo;

    public int idCategorias;

    public String nombre;

    public Categorias(int idCategoriasTipo, int idCategorias, String nombre) {
        this.idCategoriasTipo = idCategoriasTipo;
        this.idCategorias = idCategorias;
        this.nombre = nombre;
    }

}

