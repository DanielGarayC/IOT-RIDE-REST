package com.example.riderest.adminhotel;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.riderest.R;
import com.example.riderest.databinding.AdminhotelFragmentPerfilBinding;

public class AdminHotelPerfilFragment extends Fragment {

    private AdminhotelFragmentPerfilBinding binding;

    public AdminHotelPerfilFragment() {
        super(R.layout.adminhotel_fragment_perfil);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding = AdminhotelFragmentPerfilBinding.bind(view);

        binding.btnEditar.setOnClickListener(v -> {
            habilitarCampos(true);
        });

        // Por si quieres deshabilitar después de guardar
        // binding.btnGuardar.setOnClickListener(v -> habilitarCampos(false));
    }

    private void habilitarCampos(boolean habilitar) {
        binding.etNombre.setEnabled(habilitar);
        binding.etTipoDoc.setEnabled(habilitar);
        binding.etNumDoc.setEnabled(habilitar);
        binding.etFechaNac.setEnabled(habilitar);
        binding.etCorreo.setEnabled(habilitar);
        binding.etTelefono.setEnabled(habilitar);
        binding.etDomicilio.setEnabled(habilitar);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}