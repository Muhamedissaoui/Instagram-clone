package com.codinginflow.imagesearchapp.di

import com.codinginflow.imagesearchapp.api.UnsplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Dagger module
//Instructions for dagger
//Application component auto generated by dagger-hilt
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    //Dagger provides methode
    //Tells dagger how to create a retrofit object
    //Gson converts json into kotlin
    //Instantiate retrofit object
    //Singleton to instantiate once in life cycle of the app
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    //Dagger provides methode
    //Tells dagger how to create unsplashApi interface
    //Instantiate unsplashApi interface
    //Singleton to instantiate once in life cycle of the app
    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)

}