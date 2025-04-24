package com.example.riderest.cliente;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.riderest.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Inicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Inicio extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Inicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inicio.
     */
    // TODO: Rename and change types and number of parameters
    public static Inicio newInstance(String param1, String param2) {
        Inicio fragment = new Inicio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout del fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Referencia al EditText
        EditText etFecha = view.findViewById(R.id.etFecha);

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
                                etFecha.setText(fecha);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }



        });

        EditText etCantidad = view.findViewById(R.id.etCantidad);

        etCantidad.setOnClickListener(v -> {
            View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_cliente_inicio_cantpersonas, null);


            TextView tvAdultos = dialogView.findViewById(R.id.tvAdultos);
            TextView tvNinos = dialogView.findViewById(R.id.tvNinos);

            Button btnMinusAdultos = dialogView.findViewById(R.id.btnMinusAdultos);
            Button btnPlusAdultos = dialogView.findViewById(R.id.btnPlusAdultos);
            Button btnMinusNinos = dialogView.findViewById(R.id.btnMinusNinos);
            Button btnPlusNinos = dialogView.findViewById(R.id.btnPlusNinos);
            Button btnAplicar = dialogView.findViewById(R.id.btnAplicar);

            AlertDialog dialog = new AlertDialog.Builder(getContext()).setView(dialogView).create();

            btnPlusAdultos.setOnClickListener(v1 -> {
                int count = Integer.parseInt(tvAdultos.getText().toString());
                tvAdultos.setText(String.valueOf(count + 1));
            });

            btnMinusAdultos.setOnClickListener(v1 -> {
                int count = Integer.parseInt(tvAdultos.getText().toString());
                if (count > 1) tvAdultos.setText(String.valueOf(count - 1)); // mínimo 1 adulto
            });

            btnPlusNinos.setOnClickListener(v1 -> {
                int count = Integer.parseInt(tvNinos.getText().toString());
                tvNinos.setText(String.valueOf(count + 1));
            });

            btnMinusNinos.setOnClickListener(v1 -> {
                int count = Integer.parseInt(tvNinos.getText().toString());
                if (count > 0) tvNinos.setText(String.valueOf(count - 1));
            });

            btnAplicar.setOnClickListener(v1 -> {
                String resultado =
                        tvAdultos.getText() + " adulto(s) · " +
                        tvNinos.getText() + " niño(s)";
                etCantidad.setText(resultado);
                dialog.dismiss();
            });

            dialog.show();
        });

        Button btnAbrirDetalle;
        btnAbrirDetalle = view.findViewById(R.id.btnBuscar);
        btnAbrirDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una instancia del fragmento al que quieres ir
                ClienteListaHoteles hotelFragment = new ClienteListaHoteles();

                // Usar FragmentManager para reemplazar el fragmento actual
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, hotelFragment) // R.id.fragment_container es el ID del contenedor del fragmento
                        .addToBackStack(null) // Esto permite volver atrás con el botón "Back"
                        .commit();
            }
        });

        return view;
    }
}