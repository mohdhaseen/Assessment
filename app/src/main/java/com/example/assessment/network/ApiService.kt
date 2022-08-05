package com.example.assessment.network

import com.example.assessment.model.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Mohd Haseen
 *
 */

interface ApiService {

    @GET("svc/mostpopular/v2/viewed/1.json")
    fun getMostViewedArticles(@Query("api-key") apkiKey: String): Single<Response>

}