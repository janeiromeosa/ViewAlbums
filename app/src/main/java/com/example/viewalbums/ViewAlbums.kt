package com.example.viewalbums

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.viewalbums.net.TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
data class ViewAlbums(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)