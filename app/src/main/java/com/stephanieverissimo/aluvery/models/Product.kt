package com.stephanieverissimo.aluvery.models

import androidx.annotation.DrawableRes
import com.stephanieverissimo.aluvery.R
import java.math.BigDecimal

 class Product(
    val name:String,
    val price: BigDecimal,
    @DrawableRes val image: Int = R.drawable.ic_launcher_background
)