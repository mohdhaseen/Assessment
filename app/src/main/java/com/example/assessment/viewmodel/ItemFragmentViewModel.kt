package com.example.assessment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessment.ItemFragmentViewState
import com.example.assessment.model.Response
import com.example.assessment.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * @author Mohd Haseen
 */
class ItemFragmentViewModel(private val repository: Repository) : ViewModel() {

    private val disposables: CompositeDisposable by lazy { CompositeDisposable() }
    private val shipmentStateMutableLiveData = MutableLiveData<ItemFragmentViewState>()
    val shipmentStateLiveData: LiveData<ItemFragmentViewState>
        get() = shipmentStateMutableLiveData

    fun getMostViewedArticles(apiKey: String) {
        executeState(ItemFragmentViewState.ShowLoader)
        callApi(apiKey)
    }

    private fun callApi(apiKey: String) {
        disposables.add(
            repository.getMostViewedArticles(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError)
        )
    }

    private fun onSuccess(response: Response) {
        executeState(ItemFragmentViewState.HideLoader)
        executeState(ItemFragmentViewState.LoadData(response))
    }

    private fun onError(throwable: Throwable) {
        executeState(ItemFragmentViewState.HideLoader)
        executeState(ItemFragmentViewState.HandleError(throwable))
    }

    private fun executeState(state: ItemFragmentViewState) {
        shipmentStateMutableLiveData.value = state
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}