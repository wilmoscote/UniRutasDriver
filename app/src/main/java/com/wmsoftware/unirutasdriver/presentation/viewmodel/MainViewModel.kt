package com.wmsoftware.unirutasdriver.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wmsoftware.unirutasdriver.data.datasource.local.UserPreferences
import com.wmsoftware.unirutasdriver.network.service.LocationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    locationService: LocationService
) : ViewModel() {
    val locationFlow = locationService.getLocationFlow().shareIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(1000),
        replay = 1
    )
}