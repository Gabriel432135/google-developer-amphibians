package com.example.amphibians.network

import com.example.amphibians.data.AmphibiansContainer
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.data.NetworkAmphibiansRepository
import com.example.amphibians.model.Amphibian
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import kotlin.getValue

interface AmphibiansApiService{
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}

class DefaultAmphibiansContainer: AmphibiansContainer {

    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansRepository: AmphibiansRepository by lazy {
        NetworkAmphibiansRepository(retrofitService)
    }
}