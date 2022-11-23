package com.codinginflow.imagesearchapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//To send these informations to other screens
//Photo model to get all data from json file and convert them
@Parcelize
data class UnsplashPhoto(
    val id: String,
    val description: String?,
    val created_at: String,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser
) : Parcelable {
    //Nested classes:
    @Parcelize
    data class UnsplashPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ) : Parcelable
    @Parcelize
    data class UnsplashUser(
        val name: String,
        val username: String,
        val profile_image: UnsplashUserPP
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
        //Nested classes:
        @Parcelize
        data class UnsplashUserPP(
            val medium: String
        ): Parcelable
    }
}