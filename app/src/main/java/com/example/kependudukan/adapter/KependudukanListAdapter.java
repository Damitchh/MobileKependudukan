package com.example.kependudukan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kependudukan.R;
import com.example.kependudukan.pojo.ListKk;

import java.util.ArrayList;

public class KependudukanListAdapter extends RecyclerView.Adapter<KependudukanListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ListKk> kkArrayList;

    public KependudukanListAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<ListKk> getKkArrayList() {
        return kkArrayList;
    }

    public void setKkArrayList(ArrayList<ListKk> kkArrayList) {
        this.kkArrayList = kkArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListKk object = getKkArrayList().get(position);

        Glide.with(context).load(object.getImage()).into(holder.iv_foto);
        holder.tv_id.setText(String.valueOf(object.getId()));
        holder.tv_no_kk.setText(String.valueOf(object.getNo_kk()));
        holder.tv_nama.setText(object.getNama());
        holder.tv_alamat.setText(object.getAlamat());

    }

    @Override
    public int getItemCount() {
        return kkArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_foto;
        private TextView tv_id;
        private TextView tv_no_kk;
        private TextView tv_nama;
        private TextView tv_alamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.foto_list);
            tv_id = itemView.findViewById(R.id.id_list);
            tv_no_kk = itemView.findViewById(R.id.no_kk_list);
            tv_nama = itemView.findViewById(R.id.nama_list);
            tv_alamat = itemView.findViewById(R.id.alamat_list);
        }
    }
}
