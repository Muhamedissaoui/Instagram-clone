package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.data.UnsplashPhoto

//The response containing a list of unsplashPhoto object
data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)