package com.example.viewalbums.data


import com.example.viewalbums.ViewAlbums
import com.example.viewalbums.net.AlbumsService
import com.example.viewalbums.net.BASE_URL
import io.reactivex.Maybe
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//gson converts your json data to your data class files

class RemoteDataSource: DataSource{


    private val albumsService: AlbumsService by lazy{ //creates for the first time and would be there incase you need it
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        retrofit.create(AlbumsService::class.java)
    }
    override fun getAlbumsFromList(): Maybe<List<ViewAlbums>> {
        return albumsService.getAlbums()
            .flatMapMaybe{Maybe.just(it)}
    }
    override fun addAlbumViews(viewAlbums: ViewAlbums) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}