package com.example.viewalbums.data

import com.example.viewalbums.ViewAlbums
import io.reactivex.Maybe

class ViewAlbumsRepository(private val localDataSource: DataSource,
                           private val remoteDataSource: DataSource): DataSource {


    override fun getAlbumsFromList(): Maybe<List<ViewAlbums>> {

        return remoteDataSource.getAlbumsFromList()
            .doOnSuccess{ it.forEach { viewAlbums ->  addAlbumViews(viewAlbums)} }
            .onErrorResumeNext { _: Throwable -> localDataSource.getAlbumsFromList()}
            //.onErrorResumeNext { throwable: Throwable -> localDataSource.getAlbumsFromList()
            // when the retrofit service fails, for example no internet, onErrorResumeNext will be called and the data will be retrieved from the localDataSource

    }
    override fun addAlbumViews(viewAlbums: ViewAlbums) {
        localDataSource.addAlbumViews(viewAlbums)
    }
}