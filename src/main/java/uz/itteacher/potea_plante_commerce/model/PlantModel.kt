package uz.itteacher.potea_plante_commerce.model

public data class PlantModel(
    val name: String,
    val price: String,
    val rating: String,
    val sold: String,
    val image: Int,
    var isLiked: Boolean = false
)
