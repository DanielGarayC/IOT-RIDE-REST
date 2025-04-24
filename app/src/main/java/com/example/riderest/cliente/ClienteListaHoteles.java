package com.example.riderest.cliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riderest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClienteListaHoteles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClienteListaHoteles extends Fragment implements HotelAdapter.OnHotelClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClienteListaHoteles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClienteListaHoteles.
     */
    // TODO: Rename and change types and number of parameters
    public static ClienteListaHoteles newInstance(String param1, String param2) {
        ClienteListaHoteles fragment = new ClienteListaHoteles();
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

    RecyclerView recyclerView;
    List<Hotel> listaHoteles;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.cliente_fragment_lista_hoteles, container, false);
        // Ahora findViewById debe hacerse con respecto a la vista inflada
        recyclerView = view.findViewById(R.id.recyclerHoteles);

        // Establecer el layout manager para el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crear una lista de hoteles (estos son datos de ejemplo)
        listaHoteles = new ArrayList<>();
        listaHoteles.add(new Hotel("El Mariscal Cusco", 5, "8.8 Fabuloso - 1434 comentarios", "Centro de la ciudad", "Del 28 abr al 2 mar", "Desde S/345.00", R.drawable.hotel1));
        listaHoteles.add(new Hotel("JW Marriot", 5, "8.8 Fabuloso - 572 comentarios", "Centro de la ciudad", "Del 28 abr al 2 mar", "Desde S/524.00", R.drawable.hotel2));

        // Configurar el adaptador
        HotelAdapter adapter = new HotelAdapter(listaHoteles,this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onVerDetallesClick(Hotel hotel) {
        // Crear un bundle para pasar el hotel seleccionado al fragmento de detalles
        Bundle bundle = new Bundle();
        bundle.putSerializable("hotel", hotel); // Asegúrate de que Hotel implemente Serializable


        /* Opción 2: Si no estás usando Navigation Component*/
        ClienteInformacionHoteles detallesFragment = new ClienteInformacionHoteles();
        detallesFragment.setArguments(bundle);

        getParentFragmentManager().beginTransaction()
            .replace(R.id.frame_layout, detallesFragment)
            .addToBackStack(null)
            .commit();

    }

}