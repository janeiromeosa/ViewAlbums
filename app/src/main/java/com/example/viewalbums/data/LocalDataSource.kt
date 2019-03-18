package com.example.viewalbums.data

import android.app.Application
import android.arch.persistence.room.Room
import android.provider.ContactsContract
import com.example.viewalbums.ViewAlbums
import com.example.viewalbums.net.DATABASE_NAME
import io.reactivex.Maybe

class LocalDataSource(private val application: Application): DataSource {



    private val database: AlbumsDatabase by lazy {
        Room.databaseBuilder(application, AlbumsDatabase::class.java, DATABASE_NAME).build()

    }
    override fun getAlbumsFromList() = database.viewAlbumsDAO().getAllAlbums()

    override fun addAlbumViews(viewAlbums: ViewAlbums) {
        database.viewAlbumsDAO().addAlbums(viewAlbums)
    }
}