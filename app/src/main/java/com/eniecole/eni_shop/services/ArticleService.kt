package com.eniecole.eni_shop.services

import com.eniecole.eni_shop.bo.Article
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {

    @GET(value = "products")
    suspend fun getAll() : List<Article>

    @GET(value = "products/{id}")
    suspend fun getById(@Path("id") id: String) : Article?

    @POST(value = "products")
    suspend fun add(@Body article: Article)
}

object CallArticleApi{
    val BASE_URL = "https://fakestoreapi.com/"

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val retrofitService: ArticleService by lazy { retrofit.create(ArticleService::class.java) }
}