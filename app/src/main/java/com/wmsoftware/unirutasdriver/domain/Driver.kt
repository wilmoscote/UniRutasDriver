package com.wmsoftware.unirutasdriver.domain

import kotlinx.serialization.Serializable

@Serializable
data class Driver(
    val id: String? = null,
    val name: String? = "",
    val email: String? = "",
    val createdAt: String? = null,
    val status: Int? = 1,
    val profilePicture: String? = "",
    val lastLocation: LocationInfo? = LocationInfo(),
    val lastLocationUpdateAt: String? = "",
    val fcm: String? = ""
)

@Serializable
data class LocationInfo(
    val latitude: String? = "",
    val longitude: String? = ""
)