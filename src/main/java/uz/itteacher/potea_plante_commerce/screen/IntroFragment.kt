package uz.itteacher.potea_plante_commerce.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.itteacher.potea_plante_commerce.R
import uz.itteacher.potea_plante_commerce.model.CubeTransformer
import uz.itteacher.potea_plante_commerce.model.IntroPagerAdapter
import uz.itteacher.potea_plante_commerce.util.PrefManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var viewPager: ViewPager2



/**
 * A simple [Fragment] subclass.
 * Use the [IntroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IntroFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view?.cameraDistance = 20000f





        val pages = listOf(
            IntroPageFragment.newInstance(
                R.drawable.plant1,
                "We provide high quality plants just for you",
                false
            ),
            IntroPageFragment.newInstance(
                R.drawable.plant2,
                "Your satisfaction is our number one priority",
                false
            ),
            IntroPageFragment.newInstance(
                R.drawable.plant3,
                "Let's Shop Your Favorite Plants with Potea Now!",
                true
            )
        )
        val root = inflater.inflate(R.layout.fragment_intro, container, false)
        viewPager = root.findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = IntroPagerAdapter(this, pages)
        viewPager.setPageTransformer(CubeTransformer())

            return root
        }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment IntroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IntroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    fun nextPage() {
        if (viewPager.currentItem < 2)
            viewPager.currentItem++
        else {
            PrefManager.setIntroSeen(requireContext(), true)
            findNavController().navigate(R.id.action_introFragment_to_createPinCodeFragment)
        }
    }
}