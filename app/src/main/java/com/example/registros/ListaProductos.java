package com.example.registros;

public class ListaProductos {

    private String marca;
    private String modelo;




    public ListaProductos(String marca, String modelo) {
        this.marca=marca;
        this.modelo=modelo;
    }



    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }



}