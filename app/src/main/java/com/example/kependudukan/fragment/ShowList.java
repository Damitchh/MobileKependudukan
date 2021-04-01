package com.example.kependudukan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kependudukan.R;
import com.example.kependudukan.adapter.KependudukanListAdapter;
import com.example.kependudukan.pojo.ListKk;

import java.util.ArrayList;

public class ShowList extends Fragment {

    public static final String EXTRA_KEY = "extra_key";
    private RecyclerView recyclerView;
    private KependudukanListAdapter adapter;

    public ShowList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new KependudukanListAdapter(getContext());
        fetchingData();
        if (adapter.getKkArrayList().size() > 0) {
            setView();
        }

        // Inflate the layout for this fragment
        return view;
    }

    private void fetchingData() {
        Bundle getBundle = this.getArguments();
        if (getBundle != null) {
            ArrayList<ListKk> post = getBundle.getParcelableArrayList(this.EXTRA_KEY);
            if (post.size() > 0) {
                adapter.setKkArrayList(post);
            }
        }
    }

    private void setView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
