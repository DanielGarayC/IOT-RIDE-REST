package com.example.riderest.cliente;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.riderest.R;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> listaHoteles;
    private OnHotelClickListener listener;

    // Interfaz para manejar el evento de clic en el botón
    public interface OnHotelClickListener {
        void onVerDetallesClick(Hotel hotel);
    }

    public HotelAdapter(List<Hotel> listaHoteles, OnHotelClickListener listener) {
        this.listaHoteles = listaHoteles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cliente_item_hotel, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = listaHoteles.get(position);
        holder.txtNombre.setText(hotel.getNombre());
        holder.ratingBar.setRating(hotel.getRating());
        holder.txtPuntuacion.setText(hotel.getPuntuacion());
        holder.txtUbicacion.setText(hotel.getUbicacion());
        holder.txtFechas.setText(hotel.getFechas());
        holder.txtPrecio.setText(hotel.getPrecio());
        holder.imgHotel.setImageResource(hotel.getImagen());

        // Configurar el listener para el botón de ver detalles
        holder.btnVerDetalles.setOnClickListener(v -> {
            if (listener != null) {
                listener.onVerDetallesClick(hotel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaHoteles.size();
    }

    static class HotelViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtPuntuacion, txtUbicacion, txtFechas, txtPrecio;
        RatingBar ratingBar;
        ImageView imgHotel;
        Button btnVerDetalles;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPuntuacion = itemView.findViewById(R.id.txtPuntuacion);
            txtUbicacion = itemView.findViewById(R.id.txtUbicacion);
            txtFechas = itemView.findViewById(R.id.txtFechas);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imgHotel = itemView.findViewById(R.id.imgHotel);
            btnVerDetalles = itemView.findViewById(R.id.btnVerDetalles);
        }
    }
}