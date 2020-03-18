package com.example.meucepapp.repository;

import com.example.meucepapp.model.CepResponse;

import io.reactivex.Single;

import static com.example.meucepapp.repository.remote.Service.getEndPoint;

public class CepRepository {

    public Single<CepResponse> cepResponseSingle(String cep){

        return getEndPoint().getCepResponse(cep);
    }


}
