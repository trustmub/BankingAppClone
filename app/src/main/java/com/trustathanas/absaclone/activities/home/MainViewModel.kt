package com.trustathanas.absaclone.activities.home

import androidx.lifecycle.ViewModel
import com.trustathanas.absaclone.repositories.HomeRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: HomeRepository) : ViewModel() {

    fun logoutMain() = repository.logoutMain()
}