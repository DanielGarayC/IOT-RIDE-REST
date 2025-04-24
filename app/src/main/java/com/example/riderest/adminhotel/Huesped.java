package com.example.riderest.adminhotel;


public class Huesped {
    private String nombre;
    private String fecha;
    private String checkIn;

    public Huesped (String nombre, String fecha, String checkIn) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.checkIn = checkIn;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCheckIn() {
        return checkIn;
    }
}
