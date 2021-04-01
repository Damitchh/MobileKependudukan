package com.example.kependudukan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kependudukan.KkData;
import com.example.kependudukan.pojo.ListKk;
import com.example.kependudukan.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowKk extends Fragment {

    public static final String EXTRA_KEY = "extra_key";
    private ListKk post;
    private TextView id, no_kk, nama, alamat;
    private ImageView foto;
//    private ArrayList<ListKk> list = new ArrayList<>();

    public ShowKk() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show_kk, container, false);

        id = view.findViewById(R.id.id);
        no_kk = view.findViewById(R.id.no_kk);
        nama = view.findViewById(R.id.nama);
        alamat = view.findViewById(R.id.alamat);
        foto = view.findViewById(R.id.foto);

//        list.addAll(KkData.getListData());

        //get data from bundle
        Bundle getBundle = this.getArguments();
        if (getBundle != null) {
            post = getBundle.getParcelable(EXTRA_KEY);
            if (post != null) {

                try {
                    JSONObject jsonObject = new JSONObject();
                    JSONObject orang = jsonObject.getJSONObject("result");
                    id.setText(orang.getString("id_survey"));
                    no_kk.setText(orang.getString("nomor_id_bdt"));
                    nama.setText(orang.getString("nama_kepala_rumah_tangga"));
                    alamat.setText(orang.getString("alamat_rumah"));
                    String gambar = orang.getString("image");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                /*id.setText(String.valueOf(post.getId()));
                no_kk.setText(String.valueOf(post.getNo_kk()));
                nama.setText(post.getNama());
                alamat.setText(post.getAlamat());*/
            }
        }

        // Inflate the layout for this fragment
        return view;
    }

}
