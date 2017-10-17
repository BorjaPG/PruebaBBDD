package com.bp.pruebabbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.dataList);

        //Datos a insertar.
        Modelo modelo1 = new Modelo("La plataforma Android", "Presentación e historia de la plataforma Android");
        Modelo modelo2 = new Modelo("Entorno de desarrollo", "Presentación e instalación del entorno de desarrollo Android");
        Modelo modelo3 = new Modelo("Principio de programación", "Presentación de las especificidades del desarrollo Android");
        Modelo modelo4 = new Modelo("Mi primera aplicación: HelloAndroid", "Creación del primer proyecto Android y explicación de la arquitectura de un proyecto Android");
        Modelo modelo5 = new Modelo("Depuración y gestión de errores", "Explicación de la manera de depurar una aplicación Android");
        Modelo modelo6 = new Modelo("Creación de interfaces sencillas", "Introducción a la creación de interfaces con Android");

        //Inicializar BBDD.
        DataBase datoBdd = new DataBase(this);
        //Iniciar conexión en modo escritura.
        datoBdd.openForWrite();
        //Insertar los datos.
        datoBdd.insertData(modelo1);
        datoBdd.insertData(modelo2);
        datoBdd.insertData(modelo3);
        datoBdd.insertData(modelo4);
        datoBdd.insertData(modelo5);
        datoBdd.insertData(modelo6);

        //ArrayList de tipo Modelo que contendrá todos los datos de la tabla.
        ArrayList<Modelo> dataList = datoBdd.getAllData();
        //Cerrar conexión.
        datoBdd.close();
        //Adapter para adaptar los datos a los elementos de la lista.
        ArrayAdapter<Modelo> adapter = new ArrayAdapter<Modelo>(this, android.R.layout.simple_list_item_1, dataList);
        //Establecer adapter.
        list.setAdapter(adapter);
    }
}
