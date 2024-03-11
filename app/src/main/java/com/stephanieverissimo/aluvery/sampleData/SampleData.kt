package com.stephanieverissimo.aluvery.sampleData

import com.stephanieverissimo.aluvery.R
import com.stephanieverissimo.aluvery.models.Product
import java.math.BigDecimal

val sampleProductPromo = listOf(Product("Hambuguer", BigDecimal(12.99), R.drawable.burger),
                           Product("Pizza", BigDecimal(19.99), R.drawable.pizza),
                           Product("Fries", BigDecimal(6.99), R.drawable.fries))

val sampleProductCandies = listOf(Product("Chocolate", BigDecimal(4.99), R.drawable.placeholder),
                           Product("MM's", BigDecimal(5.99), R.drawable.placeholder),
                           Product("Marshmallows", BigDecimal(6.99), R.drawable.placeholder))

val sampleProductCombo = listOf(Product("#11", BigDecimal(4.99), R.drawable.burger),
                           Product("#12", BigDecimal(5.99), R.drawable.burger),
                           Product("#13", BigDecimal(6.99), R.drawable.burger))

val sampleProductDrinks= listOf(Product("Water", BigDecimal(2.99), R.drawable.placeholder),
                           Product("Coffe", BigDecimal(9.99), R.drawable.placeholder),
                           Product("Soda", BigDecimal(6.99), R.drawable.placeholder))

