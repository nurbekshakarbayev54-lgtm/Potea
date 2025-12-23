package uz.itteacher.potea_plante_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.itteacher.potea_plante_commerce.R
import uz.itteacher.potea_plante_commerce.model.FavouriteData
import uz.itteacher.potea_plante_commerce.model.PlantModel

class PlantAdapter(
    private val list: List<PlantModel>,
    private val likeToggleEnabled: Boolean = true
) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgPlant)
        val name: TextView = view.findViewById(R.id.txtName)
        val rating: TextView = view.findViewById(R.id.txtRating)
        val sold: TextView = view.findViewById(R.id.txtSold)
        val price: TextView = view.findViewById(R.id.txtPrice)
        val btnLike: ImageButton = view.findViewById(R.id.btnLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.img.setImageResource(item.image)
        holder.name.text = item.name
        holder.rating.text = item.rating
        holder.sold.text = item.sold
        holder.price.text = item.price

        if (likeToggleEnabled) {
            holder.btnLike.setOnClickListener {
                item.isLiked = !item.isLiked
                if (item.isLiked) {
                    holder.btnLike.setImageResource(R.drawable.favorite_selector)
                    if (!FavouriteData.list.contains(item)) FavouriteData.list.add(item)
                } else {
                    holder.btnLike.setImageResource(R.drawable.ic_favorite)
                    FavouriteData.list.remove(item)
                }
            }
        } else {
            holder.btnLike.setImageResource(
                if(item.isLiked) R.drawable.favorite_selector else R.drawable.ic_favorite
            )
            holder.btnLike.isClickable = false
        }
    }

    override fun getItemCount() = list.size
}
