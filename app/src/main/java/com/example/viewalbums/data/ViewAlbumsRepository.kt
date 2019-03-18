package com.example.viewalbums.data

import com.example.viewalbums.ViewAlbums
import io.reactivex.Maybe

class ViewAlbumsRepository(private val localDataSource: DataSource,
                           private val remoteDataSource: DataSource): DataSource {


    override fun getAlbumsFromList(): Maybe<List<ViewAlbums>> {
        return remoteDataSource.getAlbumsFromList()
            .doOnSuccess{ Result -> Result.forEach { viewAlbums ->  addAlbumViews(viewAlbums)} }
            //.onErrorResumeNext { throwable: Throwable -> localDataSource.getAlbumsFromList(id)

    }
    override fun addAlbumViews(viewAlbums: ViewAlbums) {
        localDataSource.addAlbumViews(viewAlbums)
    }
}