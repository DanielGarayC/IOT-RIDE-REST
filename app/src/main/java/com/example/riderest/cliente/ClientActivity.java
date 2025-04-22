package com.example.riderest.cliente;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.riderest.R;
import com.example.riderest.databinding.ActivityClientBinding;

public class ClientActivity extends AppCompatActivity {
    ActivityClientBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClientBinding.inflate(getLayoutInflater());
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
            if (id == R.id.inicioCliente) {
                replaceFragment(new Inicio());
            } else if (id == R.id.mapaCliente) {
                replaceFragment(new Map());
            } else if (id == R.id.historialCliente) {
                replaceFragment(new ClienteReserva());
            } else if (id == R.id.perfilCliente) {
                replaceFragment(new ClientePerfil());
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
