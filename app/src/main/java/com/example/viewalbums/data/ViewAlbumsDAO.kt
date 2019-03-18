package com.example.viewalbums.data

import android.arch.persistence.room.*
import com.example.viewalbums.ViewAlbums
import io.reactivex.Maybe

@Dao
interface ViewAlbumsDAO{
    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Maybe <List<ViewAlbums>>

    @Insert
    fun addAlbums(viewAlbums: ViewAlbums)

    @Delete
    fun deleteAlbums(viewAlbums: ViewAlbums)

    @Update
    fun upgradeAlbums(viewAlbums: ViewAlbums)




}