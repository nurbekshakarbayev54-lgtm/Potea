package uz.itteacher.potea_plante_commerce.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.itteacher.potea_plante_commerce.R
import uz.itteacher.potea_plante_commerce.adapter.PlantAdapter
import uz.itteacher.potea_plante_commerce.model.FavouriteData

class FavouritesFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        val btnFavourites = view.findViewById<ImageButton>(R.id.btnFavourites)




        val rvFavourites = view.findViewById<RecyclerView>(R.id.rvFavourites)
        rvFavourites.layoutManager = GridLayoutManager(requireContext(), 2)
        rvFavourites.adapter = PlantAdapter(FavouriteData.list, likeToggleEnabled = true)

        return view
    }
}
