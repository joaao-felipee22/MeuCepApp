package com.example.meucepapp.repository.remote;

import com.example.meucepapp.model.CepResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPoint {

    @GET("/ws/{cep}/json/")
    Single<CepResponse> getCepResponse(
            @Path("cep") String cep
    );
}
