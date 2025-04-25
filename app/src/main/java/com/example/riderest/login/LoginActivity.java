package com.example.riderest.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.riderest.databinding.ActivityLoginBinding;
import com.example.riderest.MainActivity; // Asegúrate de que este import apunte al destino correcto

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Acción al presionar "Iniciar sesión"
        binding.btnIniciar.setOnClickListener(v -> {
            String correo = binding.etCorreo.getText().toString();
            String clave = binding.etPassword.getText().toString();

            if (correo.equals("admin@admin.com") && clave.equals("1234")) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });

        // Links auxiliares
        binding.tvRegistro.setOnClickListener(v ->
                Toast.makeText(this, "Ir a registro", Toast.LENGTH_SHORT).show()
        );

        binding.tvPostula.setOnClickListener(v ->
                Toast.makeText(this, "Ir a postulación", Toast.LENGTH_SHORT).show()
        );

        binding.tvOlvide.setOnClickListener(v ->
                Toast.makeText(this, "Recuperar contraseña", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
