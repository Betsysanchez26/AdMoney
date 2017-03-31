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
public class CategoriasTipo {

    public int idCategoriasTipo;

    public String tipo;

    public CategoriasTipo(int idCategoriasTipo, String tipo) {
        this.idCategoriasTipo = idCategoriasTipo;
        this.tipo = tipo;
    }
}

