package com.example.assessment

import com.example.assessment.model.Response

/**
 * @author Mohd Haseen
 *
 */

sealed class ItemFragmentViewState {

    object ShowLoader : ItemFragmentViewState()

    object HideLoader : ItemFragmentViewState()

    data class LoadData(val response: Response) : ItemFragmentViewState()

    data class HandleError(val throwable: Throwable) : ItemFragmentViewState()


}