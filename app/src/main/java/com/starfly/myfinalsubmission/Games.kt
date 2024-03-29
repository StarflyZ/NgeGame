package com.starfly.myfinalsubmission
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val title: String,
    val description: String,
    val photo: String
) : Parcelable
