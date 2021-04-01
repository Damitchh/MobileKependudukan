package com.example.kependudukan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.kependudukan.fragment.SearchKk;
import com.example.kependudukan.fragment.SearchList;
import com.example.kependudukan.fragment.SelectView;
import com.example.kependudukan.fragment.ShowKk;
import com.example.kependudukan.fragment.ShowList;

public class MainActivity extends AppCompatActivity {

    private SelectView selectView = new SelectView();
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(selectView, bundle, "");
    }

    public void setFragment(Fragment fragment, Bundle bundle, String task) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (task.equals("replace")) {
            fragmentTransaction.replace(R.id.frag_container, fragment);
        } else {
            fragmentTransaction.add(R.id.frag_container, fragment);
        }
        fragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
