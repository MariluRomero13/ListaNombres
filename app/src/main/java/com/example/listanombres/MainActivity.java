package com.example.listanombres;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.listanombres.adaptadores.adaptadorAlumnos;
import com.example.listanombres.modelos.Alumno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));
    }

    public void OnClick(View view)
    {
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/ListaNombre", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try
                        {

                            Gson gson = new Gson();
                            Type type = new TypeToken<List<Alumno>>(){}.getType();
                             List<Alumno> lp  = gson.fromJson(response.toString(), type);
                             adaptadorAlumnos adaptador = new adaptadorAlumnos(lp);
                             lista.setAdapter(adaptador);

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance(MainActivity.this).getRequestQueue().add(jar);
    }
}
