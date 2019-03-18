package com.example.viewalbums.home

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

import com.example.viewalbums.ViewAlbums
import com.example.viewalbums.data.DataSource
import com.example.viewalbums.data.LocalDataSource
import com.example.viewalbums.data.RemoteDataSource
import com.example.viewalbums.data.ViewAlbumsRepository
import com.example.viewalbums.net.ENDPOINT
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel(){
    private val albumsObservable: MutableLiveData<List<ViewAlbums>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getArticlesObservable(): LiveData<List<ViewAlbums>> = albumsObservable

    private lateinit var repository: DataSource

    fun getAlbums(application: Application){
        repository = ViewAlbumsRepository(remoteDataSource = RemoteDataSource(),
            localDataSource = LocalDataSource(application)
        )

        compositeDisposable.add(repository.getAlbumsFromList()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ Log.d("Album Description", it[0].title)}, {it.printStackTrace()}))
    }
}