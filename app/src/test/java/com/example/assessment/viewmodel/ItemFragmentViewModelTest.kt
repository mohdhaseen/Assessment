package com.example.assessment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.assessment.ItemFragmentViewState
import com.example.assessment.RxSchedulersOverrideRule
import com.example.assessment.model.Response
import com.example.assessment.repository.RepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class ItemFragmentViewModelTest {
    private lateinit var viewModel: ItemFragmentViewModel

    @RelaxedMockK
    lateinit var stateObserver: Observer<ItemFragmentViewState>

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var rxSchedulersOverrideRule = RxSchedulersOverrideRule()

    @Before
    fun before() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = ItemFragmentViewModel(RepositoryImpl())
        viewModel.shipmentStateLiveData.observeForever { stateObserver }

    }

    @Test
    fun loadDataWithSuccess() {
        val apiKey = "j0XjaRWTD643A1dfnomojk6ijDpn3NAO"
        val response = Response()
        viewModel.getMostViewedArticles(apiKey)
        verify { stateObserver.onChanged(ItemFragmentViewState.LoadData(response))}
    }

    @Test
    fun loadDataWithError() {
        val apiKey = "wrong_api_key"
        viewModel.getMostViewedArticles(apiKey)
        verify { stateObserver.onChanged(ItemFragmentViewState.HandleError(Throwable())) }
    }

}