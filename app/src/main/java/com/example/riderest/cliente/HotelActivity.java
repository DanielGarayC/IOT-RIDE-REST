package com.example.riderest.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.riderest.MainActivity;
import com.example.riderest.R;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {
    // ✅ Declaras la variable aquí (sin inicializar)
    RecyclerView recyclerView;
    List<Hotel> listaHoteles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        recyclerView = findViewById(R.id.recyclerHoteles); // Mueve esta línea aquí
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaHoteles = new ArrayList<>();
        listaHoteles.add(new Hotel("El Mariscal Cusco", 5, "8.8 Fabuloso - 1434 comentarios", "Centro de la ciudad", "Del 28 abr al 2 mar", "Desde S/345.00", R.drawable.hotel1));
        listaHoteles.add(new Hotel("JW Marriot", 5, "8.8 Fabuloso - 572 comentarios", "Centro de la ciudad", "Del 28 abr al 2 mar", "Desde S/524.00", R.drawable.hotel2));

        HotelAdapter adapter = new HotelAdapter(listaHoteles);
        recyclerView.setAdapter(adapter);


        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelActivity.this, ClientActivity.class); // o MainActivity si se llama así
                intent.putExtra("fragmentDestino", "inicio");
                startActivity(intent);
                finish(); // Cierra HotelActivity
            }
        });

    }
}