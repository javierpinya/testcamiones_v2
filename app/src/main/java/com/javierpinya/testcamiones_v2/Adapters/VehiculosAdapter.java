package com.javierpinya.testcamiones_v2.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v2.R;

import java.util.List;

public class VehiculosAdapter extends RecyclerView.Adapter<VehiculosAdapter.VehiculosAdapter_Holder> {


    private List<TaccamiEntity> listaVehiculoEntities;
    private AdapterView.OnItemClickListener itemClickListener;

    public VehiculosAdapter(List<TaccamiEntity> listaVehiculoEntities, AdapterView.OnItemClickListener listener){
        this.listaVehiculoEntities = listaVehiculoEntities;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public VehiculosAdapter_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculosAdapter_Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VehiculosAdapter_Holder extends RecyclerView.ViewHolder {
        TextView tvTractora, tvCisterna;
        ImageView ivTractora, ivCisterna, ivTractoraBloqueada, ivCisternaBloqueada, ivTractoraInspeccionada, ivCisternaInspeccionada;

        public VehiculosAdapter_Holder(@NonNull View itemView) {
            super(itemView);

            /* Esto está mal, hay que hacerlo con ViewModel...*/
            tvTractora = itemView.findViewById(R.id.tvTractora);
            tvCisterna = itemView.findViewById(R.id.tvCisterna);
            ivTractora = itemView.findViewById(R.id.ivTractora);
            ivCisterna = itemView.findViewById(R.id.ivCisterna);
            ivTractoraBloqueada = itemView.findViewById(R.id.ivTractoraBloqueada);
            ivCisternaBloqueada = itemView.findViewById(R.id.ivCisternaBloqueada);
            ivTractoraInspeccionada = itemView.findViewById(R.id.ivTractoraInspeccionada);
            ivCisternaInspeccionada = itemView.findViewById(R.id.ivCisternaInspeccionada);
        }

        public void bind(final TaccamiEntity taccamiEntity, final OnItemClickListener listener){
        /*
        this.tvTractora.setText(listaVehiculoEntities.get(getAdapterPosition()).gettMatricula().toString());
        this.tvCisterna.setText(listaVehiculoEntities.get(getAdapterPosition()).getcMatricula().toString());
        this.ivCisterna.setImageResource(R.drawable.ic_oil_tank);

        if(listaVehiculoEntities.get(getAdapterPosition()).gettTipo().equals("T")){
            this.ivTractora.setImageResource(R.drawable.ic_frontal_truck);
        }else{
            this.ivTractora.setImageResource(R.drawable.ic_oil_truck);
        }

        if(listaVehiculoEntities.get(getAdapterPosition()).getcBloqueada()){
            this.ivCisternaBloqueada.setImageResource(R.drawable.ic_ban);
        }else{
            this.ivCisternaBloqueada.setImageResource(R.drawable.ic_checked);
        }

        if(listaVehiculoEntities.get(getAdapterPosition()).gettBloqueada()){
            this.ivTractoraBloqueada.setImageResource(R.drawable.ic_ban);
        }else{
            this.ivTractoraBloqueada.setImageResource(R.drawable.ic_checked);
        }

        if(listaVehiculoEntities.get(getAdapterPosition()).getcInspeccionada()){
            this.ivCisternaInspeccionada.setImageResource(R.drawable.ic_inspeccionado_true);
        }else{
            this.ivCisternaInspeccionada.setImageResource(R.drawable.ic_inspeccionado_false);
        }

        if(listaVehiculoEntities.get(getAdapterPosition()).gettInspeccionada()){
            this.ivTractoraInspeccionada.setImageResource(R.drawable.ic_inspeccionado_true);
        }else{
            this.ivTractoraInspeccionada.setImageResource(R.drawable.ic_inspeccionado_false);
        }

         */



        }
    }

    public interface OnItemClickListener{
        void onItemClick(VehiculosAdapter vehiculosAdapter, int position);
    }
}


