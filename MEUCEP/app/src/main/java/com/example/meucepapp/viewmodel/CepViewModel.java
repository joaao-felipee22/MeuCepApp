package com.example.meucepapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meucepapp.model.CepResponse;
import com.example.meucepapp.repository.CepRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CepViewModel extends AndroidViewModel {

    private MutableLiveData<CepResponse> responseMutableLiveData = new MutableLiveData<>();
    public LiveData<CepResponse> cepResponseLiveData = responseMutableLiveData;
    private CepRepository cepRepository = new CepRepository();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> loadingMutable = new MutableLiveData<>();
    public LiveData<Boolean> loadingLiveData = loadingMutable;

    public CepViewModel(@NonNull Application application) {
        super(application);
    }

    public void getCep(String cep){
        disposable.add(
                cepRepository.cepResponseSingle(cep)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> loadingMutable.setValue(true))
                .doAfterTerminate(() -> loadingMutable.setValue(false))
                .subscribe(cepResponse -> responseMutableLiveData.setValue(cepResponse),
                        throwable -> Log.i("LOG", "Message -> " + throwable.getMessage()))
        );
    }



    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
