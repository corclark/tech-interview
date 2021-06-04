package com.specialized.android

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface GearApi {
    @GET("api/gear/")
    fun getGear() : Call<List<GearItem>>

    @GET("api/gear/{id}/")
    fun getGearDetail (@Path("id") id: Int?) : Call<GearItemDetail>

    companion object {

        var BASE_URL = "https://interview.retul.com/"

        fun create() : GearApi {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GearApi::class.java)

        }

    }
}