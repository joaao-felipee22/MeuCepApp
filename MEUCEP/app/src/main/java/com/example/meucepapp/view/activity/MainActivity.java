package com.example.meucepapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.meucepapp.R;
import com.example.meucepapp.viewmodel.CepViewModel;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView bairro, localidade, cep, longadouro;
    private SearchView searchView;
    private CepViewModel cepViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        cepViewModel.loadingLiveData.observe(this, aBoolean -> {
            if(aBoolean){
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        cepViewModel.cepResponseLiveData.observe(this, cepResponse -> {
            bairro.setText(cepResponse.getBairro());
            longadouro.setText(cepResponse.getLogradouro());
            cep.setText(cepResponse.getCep());
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                cepViewModel.getCep(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }


    public void initView(){
        bairro = findViewById(R.id.txt_bairro);
        localidade = findViewById(R.id.txt_localidade);
        cep = findViewById(R.id.txt_cep);
        longadouro = findViewById(R.id.txt_long);
        searchView = findViewById(R.id.searchView);
        progressBar = findViewById(R.id.progressBar);
        cepViewModel = ViewModelProviders.of(this).get(CepViewModel.class);
    }



}
