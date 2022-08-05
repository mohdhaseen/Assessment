package com.aranoah.healthkart.plus.pharmacy.shipmentv2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assessment.repository.RepositoryImpl
import com.example.assessment.viewmodel.ItemFragmentViewModel


/**
 * @author Mohd Haseen
 */
class ItemFragmentViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return ItemFragmentViewModel( RepositoryImpl()) as T
    }
}