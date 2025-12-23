package uz.itteacher.potea_plante_commerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.itteacher.potea_plante_commerce.R
import uz.itteacher.potea_plante_commerce.adapter.PlantAdapter
import uz.itteacher.potea_plante_commerce.model.FavouriteData
import uz.itteacher.potea_plante_commerce.model.PlantModel

class HomeFragment : Fragment() {

    private val data = mutableListOf<PlantModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rvSpecial = view.findViewById<RecyclerView>(R.id.rvSpecial)
        val rvPopular = view.findViewById<RecyclerView>(R.id.rvPopular)
        val btnFavourites = view.findViewById<ImageButton>(R.id.btnFavourites)

        data.add(PlantModel("Prayer Plant", "$29", "⭐ 4.8", "4,268 Sold", R.drawable.img))
        data.add(PlantModel("ZZ Plant", "$25", "⭐ 4.7", "3,884 Sold", R.drawable.img_2))
        data.add(PlantModel("Sansevieria", "$32", "⭐ 4.5", "2,156 Sold", R.drawable.img_3))
        data.add(PlantModel("Sansevieria", "$32", "⭐ 4.5", "2,156 Sold", R.drawable.img_1))

        rvSpecial.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvSpecial.adapter = PlantAdapter(data)
        rvPopular.layoutManager = GridLayoutManager(requireContext(), 2)
        rvPopular.adapter = PlantAdapter(data, likeToggleEnabled = true)


        btnFavourites.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_favouritesFragment)

        }


        return view
    }
}
