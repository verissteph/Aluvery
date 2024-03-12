package com.stephanieverissimo.aluvery.sampleData

import com.stephanieverissimo.aluvery.models.Product
import java.math.BigDecimal


val sampleProductCandies = listOf(Product("Chocolate", BigDecimal(4.99), "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",),
                                  Product("Ice cream", BigDecimal(5.99), "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",),
                                  Product("Cake", BigDecimal(6.99),"https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",))

val sampleProductCombo = listOf(Product("#11", BigDecimal(4.99)),
                                Product("#12", BigDecimal(5.99)),
                                Product("#13", BigDecimal(6.99)))

val sampleProductDrinks = listOf(Product("Beer", BigDecimal(12.99),  "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",),
                                 Product("Juice", BigDecimal(9.99), "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"),
                                 Product("Soda", BigDecimal(6.99), "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"),
                                 Product("Water", BigDecimal(2.99), "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"),)


val sampleProducts = listOf(Product("Hambuguer", BigDecimal(12.99), "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"),
                            Product("Pizza", BigDecimal(19.99),  "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"),
                            Product("Fries", BigDecimal(6.99),  "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"),
                            *sampleProductDrinks.toTypedArray(), *sampleProductCandies.toTypedArray(),
                           *sampleProductCombo.toTypedArray())

val sampleSections = mapOf(
    "Promotions" to sampleProducts,
    "Candies" to sampleProductCandies,
    "Drinks" to sampleProductDrinks,
    "Combo" to sampleProductCombo,
    )