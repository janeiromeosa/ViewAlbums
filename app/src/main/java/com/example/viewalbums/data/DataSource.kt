package com.example.viewalbums.data

import com.example.viewalbums.ViewAlbums
import io.reactivex.Maybe

interface DataSource{
    fun getAlbumsFromList(): Maybe<List<ViewAlbums>> //maybe and single are types of observables
    fun addAlbumViews(viewAlbums: ViewAlbums)
}

