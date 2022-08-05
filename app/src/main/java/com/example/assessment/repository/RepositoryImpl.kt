package com.example.assessment.repository

import com.example.assessment.model.Response
import com.example.assessment.network.ApiHandler
import io.reactivex.Single

/**
 * @author Mohd Haseen
 *
 */
class RepositoryImpl : Repository {
    private val shipmentApi = ApiHandler.API

    override fun getMostViewedArticles(apiKey: String): Single<Response> {
        return shipmentApi.getMostViewedArticles(apiKey)
    }
}