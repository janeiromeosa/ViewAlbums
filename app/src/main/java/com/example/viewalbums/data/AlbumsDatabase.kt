package com.example.viewalbums.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.viewalbums.ViewAlbums
import com.example.viewalbums.net.DATABASE_VERSION

@Database(entities = [ViewAlbums::class], version = DATABASE_VERSION)
abstract class AlbumsDatabase: RoomDatabase() {
    abstract fun viewAlbumsDAO(): ViewAlbumsDAO

}
