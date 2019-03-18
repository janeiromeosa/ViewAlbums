package com.example.viewalbums.net

import android.renderscript.Script
import com.example.viewalbums.ViewAlbums
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


// https://jsonplaceholder.typicode.com/albums

interface AlbumsService {
    @GET(ENDPOINT)
    fun getAlbums(): Maybe<List<ViewAlbums>>
}