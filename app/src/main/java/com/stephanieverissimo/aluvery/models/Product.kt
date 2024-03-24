package com.stephanieverissimo.aluvery.models

import androidx.annotation.DrawableRes
import com.stephanieverissimo.aluvery.R
import java.math.BigDecimal

 data class Product(
    val name:String,
    val price: BigDecimal,
    val image: String? = null,
    val description: String? = null,
)