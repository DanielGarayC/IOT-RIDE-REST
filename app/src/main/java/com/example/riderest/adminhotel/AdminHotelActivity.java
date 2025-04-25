package com.example.riderest.adminhotel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.fragment.NavHostFragment;
import com.example.riderest.R;
import com.example.riderest.adminhotel.Inicio;
import com.example.riderest.databinding.ActivityAdminhotelBinding;
import com.example.riderest.databinding.ActivityClientBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminHotelActivity extends AppCompatActivity {

    ActivityAdminhotelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminhotelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener el fragmento a mostrar desde el intent
        String destino = getIntent().getStringExtra("fragmentDestino");

        if ("inicio".equals(destino)) {
            replaceFragment(new Inicio());
        } else {
            // Fragmento por defecto
            replaceFragment(new Inicio());
        }



        // Navegación inferior
        binding.bottonNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_hotel_inicio) {
                replaceFragment(new Inicio());
            } else if (id == R.id.nav_hotel_perfil) {
                replaceFragment(new AdminHotelPerfilFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}