package com.example.kependudukan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kependudukan.MainActivity;
import com.example.kependudukan.R;
import com.example.kependudukan.http_client.KependudukanCall;
import com.example.kependudukan.http_client.RetrofitClient;
import com.example.kependudukan.pojo.ListKk;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchList extends Fragment {

    private Button ambil;
    private EditText jumlah;
    private ArrayList<ListKk> kkArrayList;

    public SearchList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_list, container, false);

        ambil = view.findViewById(R.id.ambil);
        jumlah = view.findViewById(R.id.jumlah);
        kkArrayList = new ArrayList<>();

        ambil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String count = jumlah.getText().toString();
                if (!count.isEmpty()) {
                    getKependudukanList(Integer.parseInt(jumlah.getText().toString()));
                }
                else {
                    jumlah.setError("Field Tidak Boleh Kosong!");
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void getKependudukanList(final int jumlah) {
        KependudukanCall kependudukanCall = RetrofitClient.getClient().create(KependudukanCall.class);
        Call<ArrayList<ListKk>> getKKList = kependudukanCall.getKKList(jumlah);
        getKKList.enqueue(new Callback<ArrayList<ListKk>>() {
            @Override
            public void onResponse(Call<ArrayList<ListKk>> call, Response<ArrayList<ListKk>> response) {
                if (response.isSuccessful() && response.body().size()!=0) {
                    kkArrayList = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList(ShowList.EXTRA_KEY, kkArrayList);
                    ((MainActivity)(Objects.requireNonNull(getActivity()))).setFragment(new ShowList(), bundle, "replace");
                }
                else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ListKk>> call, Throwable t) {
//                for (int i = 0; i < jumlah; i++) {
//                    ListKk contoh = new ListKk();
//                    contoh.setId(2020001);
//                    contoh.setAlamat("1263  Davis Street, LEMOYNE");
//                    contoh.setImage("http://barokah-softdev.com/img/1.jpg");
//                    contoh.setNama("Lori Hewitt");
//                    contoh.setNo_kk(350001);
//                    kkArrayList.add(contoh);
//                }
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList(ShowList.EXTRA_KEY, kkArrayList);
//                ((MainActivity)(Objects.requireNonNull(getActivity()))).setFragment(new ShowList(), bundle, "replace");
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
