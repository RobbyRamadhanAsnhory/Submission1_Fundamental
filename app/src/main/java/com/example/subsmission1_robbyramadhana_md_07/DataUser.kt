package com.example.subsmission1_robbyramadhana_md_07
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataUser(
    var avatar : Int? = null,
    var username: String? = null,
    var name: String? = null,
    var location: String? = null,
    var repository: String? = null,
    var company : String? = null,
    var followers: String? = null,
    var following: String? = null
): Parcelable