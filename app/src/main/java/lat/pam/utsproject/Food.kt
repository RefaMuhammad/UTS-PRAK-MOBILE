package lat.pam.utsproject

data class Food(
    val name: String,
    val description: String,
    val image: Int,
    val price: String = "$$$$",
    val category: String = "Roti",
    val deliveryTime: String = "30-40 min",
    val deliveryCost: String = "Ongkir 1rb",
    val discount: String = "70% off",
    val discountInfo: String = "Diskon 70%, maks. 40rb"
)