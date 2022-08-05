package com.example.assessment.network

import com.example.assessment.model.Response
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author Mohd Haseen
 *
 */

interface ApiService {

    @GET("svc/mostpopular/v2/viewed/1.json?api-key=j0XjaRWTD643A1dfnomojk6ijDpn3NAO")
    fun getMostViewedArticles() : Single<Response>

}