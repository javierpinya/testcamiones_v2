package com.javierpinya.testcamiones_v2.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.testcamiones_v2.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v2.R;

import java.util.List;

public class ListaBuscarVehiculoRecyclerViewAdapter extends RecyclerView.Adapter<ListaBuscarVehiculoRecyclerViewAdapter.ViewHolder> {

    private List<String> mTractoras;
    private List<String> mCisternas;
    private List<Boolean> bloqueoTractoras;
    private List<Boolean> bloqueoCisternas;
    private Context ctx;

    public ListaBuscarVehiculoRecyclerViewAdapter(List<String> mTractoras, List<String> mCisternas, List<Boolean> bloqueoTractora, List<Boolean> bloqueoCisterna, Context ctx){
        this.mTractoras = mTractoras;
        this.mCisternas = mCisternas;
        this.bloqueoCisternas = bloqueoCisterna;
        this.bloqueoTractoras = bloqueoTractora;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tractora.setText(mTractoras.get(position));

        if (mCisternas.get(position) != null){
            holder.cisterna.setText(mCisternas.get(position));
        }else{
            holder.cisterna.setText("-");
        }

        if(bloqueoCisternas.get(position) == true){
            holder.bloqueoCisterna.setImageResource(R.drawable.ic_ban);
        }else if(bloqueoCisternas.get(position) == false){
            holder.bloqueoCisterna.setImageResource(R.drawable.ic_checked);
        }else {
            holder.bloqueoCisterna.setImageResource(R.color.icons2);
        }

        if(bloqueoTractoras.get(position) == true){
            holder.bloqueoTractora.setImageResource(R.drawable.ic_ban);
        }else if(bloqueoTractoras.get(position) == false){
            holder.bloqueoTractora.setImageResource(R.drawable.ic_checked);
        }else{
            holder.bloqueoTractora.setImageResource(R.color.icons2);
        }
        holder.mView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (null != v){

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTractoras.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        public final TextView tractora;
        public final TextView cisterna;
        public final ImageView bloqueoCisterna;
        public final ImageView bloqueoTractora;

        public ViewHolder(View view){
            super(view);
            mView = view;
            tractora = view.findViewById(R.id.tvTractora);
            cisterna = view.findViewById(R.id.tvCisterna);
            bloqueoCisterna = view.findViewById(R.id.ivCisternaBloqueada);
            bloqueoTractora = view.findViewById(R.id.ind_observaciones);
        }
    }
}
