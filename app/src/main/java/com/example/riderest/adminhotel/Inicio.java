package com.example.riderest.adminhotel;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.riderest.R;
import com.example.riderest.cliente.ClienteListaHoteles;
import com.example.riderest.cliente.HistorialEventos;
import com.example.riderest.databinding.AdminhotelFragmentPerfilBinding;

import java.util.Calendar;

public class Inicio extends Fragment {


    private AdminhotelFragmentPerfilBinding binding;

    public Inicio() {
        super(R.layout.adminhotel_fragment_inicio);
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout del fragment
        View view = inflater.inflate(R.layout.adminhotel_fragment_inicio, container, false);


        Button DatosHuesped = view.findViewById(R.id.button1);
        DatosHuesped.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DatosHuesped.class);
            startActivity(intent);
        });


        return view;
    }
}