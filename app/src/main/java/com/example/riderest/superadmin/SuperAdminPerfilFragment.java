package com.example.riderest.superadmin;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.riderest.R;
import com.example.riderest.databinding.SuperadminFragmentPerfilBinding;

public class SuperAdminPerfilFragment extends Fragment {

    private SuperadminFragmentPerfilBinding binding;

    public SuperAdminPerfilFragment() {
        super(R.layout.superadmin_fragment_perfil);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding = SuperadminFragmentPerfilBinding.bind(view);

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