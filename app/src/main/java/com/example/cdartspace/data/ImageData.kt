package com.example.cdartspace.data

import androidx.annotation.DrawableRes
import com.example.cdartspace.R


data class ImageData(
    @DrawableRes val imageRes: Int,
    val titleRes: Int,
    val artistRes: Int
) {
    companion object {
        fun getImagesData(): List<ImageData> {
            return listOf(
                ImageData(
                    R.drawable.landscape_1,
                    R.string.art_title_1,
                    R.string.art_artist_1
                ),
                ImageData(
                    R.drawable.landscape_2,
                    R.string.art_title_2,
                    R.string.art_artist_2
                ),
                ImageData(
                    R.drawable.landscape_3,
                    R.string.art_title_3,
                    R.string.art_artist_3
                ),
                ImageData(
                    R.drawable.landscape_4,
                    R.string.art_title_4,
                    R.string.art_artist_4
                ),

            )
        }
    }
}