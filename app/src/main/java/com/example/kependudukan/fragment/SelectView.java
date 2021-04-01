package com.example.kependudukan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kependudukan.MainActivity;
import com.example.kependudukan.R;

import java.util.Objects;

public class SelectView extends Fragment {

    private Button cari_nomor, lihat_list;

    public SelectView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_view, container, false);

        cari_nomor = view.findViewById(R.id.cari_nomor);
        lihat_list = view.findViewById(R.id.lihat_list);

        cari_nomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                ((MainActivity)(Objects.requireNonNull(getActivity()))).setFragment(new SearchKk(), bundle, "replace");
            }
        });

        lihat_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                ((MainActivity)(Objects.requireNonNull(getActivity()))).setFragment(new SearchList(), bundle, "replace");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
