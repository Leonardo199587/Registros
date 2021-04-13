package com.example.registros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ArrayList<ListaProductos> ListaProductosS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //lista
        ListaProductosS = new ArrayList<ListaProductos>();
        ListaProductosS.add(new ListaProductos("ga", "aa"));
        ListaProductosS.add(new ListaProductos("hh", "xd"));
        ListaProductosS.add(new ListaProductos("zxrp", "nn"));




        // GENER
        ProductoView1 adaptador = new ProductoView1(this);
        ListView listaviewmostrar = findViewById(R.id.id_listproductos);
        listaviewmostrar.setAdapter(adaptador);

        // mostrando
        listaviewmostrar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent in = new Intent(Home.this,Mostrarinformacion.class);
                in.putExtra("Modelo", ListaProductosS.get(i).getModelo());
                startActivity(in);

            }
           });


    }
    class ProductoView1 extends ArrayAdapter<ListaProductos> {

        AppCompatActivity appCompatActivity;

        ProductoView1(AppCompatActivity context) {
            super(context, R.layout.producto, ListaProductosS);
            appCompatActivity = context;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.producto, null);

            TextView textView1 = item.findViewById(R.id.textView_Marca);
            textView1.setText("MARCA: "+ListaProductosS.get(position).getMarca());

            TextView textView2 = item.findViewById(R.id.textView_Modelo);
            textView2.setText("MODELO: "+ListaProductosS.get(position).getModelo());


            // mostrartodo
            ImageView imageView1 = item.findViewById(R.id.id_celular_photo);
            if (ListaProductosS.get(position).getModelo()=="aa") //nombre modelo
                imageView1 .setImageResource(R.mipmap.modelo_aa);
            if (ListaProductosS.get(position).getModelo()=="xd")
                imageView1.setImageResource(R.mipmap.modelo_xd);
            if (ListaProductosS.get(position).getModelo()=="nn")
                imageView1.setImageResource(R.mipmap.modelo_nn);

            return(item);
              }
    }



}






