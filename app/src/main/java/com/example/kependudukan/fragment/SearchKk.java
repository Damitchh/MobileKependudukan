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
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchKk extends Fragment {

    private Button cari;
    private EditText nomor_kk;
    private ListKk result;

    public SearchKk() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_kk, container, false);

        result = new ListKk();
        cari = view.findViewById(R.id.cari);
        nomor_kk = view.findViewById(R.id.search);

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = nomor_kk.getText().toString();
                if (!data.isEmpty()) {
                    getDataFromAPI(nomor_kk.getText().toString());
                }
                else {
                    nomor_kk.setError("Field Tidak Boleh Kosong!");
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    //ambil data dengan retrofit
    public void getDataFromAPI(String nomor_kk) {
        KependudukanCall kependudukanCall = RetrofitClient.getClient().create(KependudukanCall.class);
        final Call<ListKk> getKK = kependudukanCall.getKKById(nomor_kk);
        getKK.enqueue(new Callback<ListKk>() {
            @Override
            public void onResponse(Call<ListKk> call, Response<ListKk> response) {
                if (response.isSuccessful() && response.body()!=null) {
                    result = response.body();
//                    ListKk contoh = new ListKk();
//                    contoh.setId(2020001);
//                    contoh.setAlamat("1263  Davis Street, LEMOYNE");
//                    contoh.setImage("http://barokah-softdev.com/img/1.jpg");
//                    contoh.setNama("Lori Hewitt");
//                    contoh.setNo_kk(350001);
                    Bundle bundle = new Bundle();
//                    bundle.putParcelable(ShowKk.EXTRA_KEY, contoh);
                    bundle.putParcelable(ShowKk.EXTRA_KEY, result);
                    ((MainActivity) (Objects.requireNonNull(getActivity()))).setFragment(new ShowKk(), bundle, "replace");
                }
                else {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListKk> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
