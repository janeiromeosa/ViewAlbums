package com.example.viewalbums

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.viewalbums.net.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ViewAlbums(
    val id: Int,
    val title: String,
    @PrimaryKey(autoGenerate = false)
    val userId: Int
)