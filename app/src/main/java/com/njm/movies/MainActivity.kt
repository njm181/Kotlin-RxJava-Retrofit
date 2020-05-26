package com.njm.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.njm.movies.data.retrofit.RetrofitService
import com.njm.movies.domain.Datos
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         compositeDisposable = CompositeDisposable() //CompositeDisposable para agregarle las conexiones entre Observable y Observer para luego con un .clear liberar recursos
                compositeDisposable.add(
                        RetrofitService.getInstanceRetrofit().getMovies()//-->OBSERVABLE abajo hago la subscripcion
                        .observeOn(AndroidSchedulers.mainThread())//en que hilo se ejecuta el Observer, osea lo que se hace cuando tenga los datos
                        .subscribeOn(Schedulers.io())//en que hilo secundario se ejecuta el Observable, lo que trae los datos
                        .subscribe({response -> onResponse(response)}, {t -> onFailure(t) })) //aca suscribo al Observable el Observer



    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: Datos) {
        println("Datos!! "+response.results.get(0).name)
        compositeDisposable.clear()//libero los recursos entre Observable y Observer
        }
    }


