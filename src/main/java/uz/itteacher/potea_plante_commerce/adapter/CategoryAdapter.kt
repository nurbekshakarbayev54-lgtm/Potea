package uz.itteacher.potea_plante_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.itteacher.potea_plante_commerce.R
import uz.itteacher.potea_plante_commerce.model.CategoryModel

class CategoryAdapter(
    private val list: List<CategoryModel>
) : RecyclerView.Adapter<CategoryAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tv: TextView = view.findViewById(R.id.tvCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = list[position]
        holder.tv.text = item.name
        holder.tv.isSelected = item.isSelected

        holder.tv.setOnClickListener {
            list.forEach { it.isSelected = false }
            item.isSelected = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = list.size
}
