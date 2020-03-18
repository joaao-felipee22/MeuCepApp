
package com.example.meucepapp.model;

import com.google.gson.annotations.SerializedName;

public class CepResponse {

    @SerializedName("bairro")
    private String mBairro;
    @SerializedName("cep")
    private String mCep;
    @SerializedName("complemento")
    private String mComplemento;
    @SerializedName("gia")
    private String mGia;
    @SerializedName("ibge")
    private String mIbge;
    @SerializedName("localidade")
    private String mLocalidade;
    @SerializedName("logradouro")
    private String mLogradouro;
    @SerializedName("uf")
    private String mUf;
    @SerializedName("unidade")
    private String mUnidade;

    public String getBairro() {
        return mBairro;
    }

    public void setBairro(String bairro) {
        mBairro = bairro;
    }

    public String getCep() {
        return mCep;
    }

    public void setCep(String cep) {
        mCep = cep;
    }

    public String getComplemento() {
        return mComplemento;
    }

    public void setComplemento(String complemento) {
        mComplemento = complemento;
    }

    public String getGia() {
        return mGia;
    }

    public void setGia(String gia) {
        mGia = gia;
    }

    public String getIbge() {
        return mIbge;
    }

    public void setIbge(String ibge) {
        mIbge = ibge;
    }

    public String getLocalidade() {
        return mLocalidade;
    }

    public void setLocalidade(String localidade) {
        mLocalidade = localidade;
    }

    public String getLogradouro() {
        return mLogradouro;
    }

    public void setLogradouro(String logradouro) {
        mLogradouro = logradouro;
    }

    public String getUf() {
        return mUf;
    }

    public void setUf(String uf) {
        mUf = uf;
    }

    public String getUnidade() {
        return mUnidade;
    }

    public void setUnidade(String unidade) {
        mUnidade = unidade;
    }

}
