package com.example.cdartspace.data

import androidx.annotation.DrawableRes
import com.example.cdartspace.R


data class ImageData(
    @DrawableRes val imageRes: Int,
    val titleRes: String,
    val artistRes: String
) {
    companion object {
        fun getImagesData(): List<ImageData> {
            return listOf(
                ImageData(
                    R.drawable.landscape_1,
                    "Title 1",
                    "Artist 1"
                ),
                ImageData(
                    R.drawable.landscape_2,
                    "Title 2",
                    "Artist 2"
                ),
                ImageData(
                    R.drawable.landscape_3,
                    "Title 3",
                    "Artist 3"
                ),
                ImageData(
                    R.drawable.landscape_4,
                    "Title 4",
                    "Artist 4"
                )

            )
        }
    }
}