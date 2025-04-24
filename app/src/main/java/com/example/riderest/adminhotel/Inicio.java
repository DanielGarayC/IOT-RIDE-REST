package com.example.riderest.adminhotel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riderest.R;
import com.example.riderest.databinding.AdminhotelFragmentPerfilBinding;

public class Inicio extends Fragment {


    private AdminhotelFragmentPerfilBinding binding;

    public Inicio() {
        super(R.layout.adminhotel_fragment_inicio);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.adminhotel_fragment_inicio, container, false);
    }
}