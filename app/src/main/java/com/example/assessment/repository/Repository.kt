package com.example.assessment.repository

import com.example.assessment.model.Response
import io.reactivex.Single

/**
 * @author Mohd Haseen
 *
 */
interface Repository {

    fun getMostViewedArticles(): Single<Response>

}