package uz.itteacher.potea_plante_commerce.screen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.itteacher.potea_plante_commerce.R

class IntroPageFragment : Fragment(R.layout.fragment_intro_page) {

    companion object {
        fun newInstance(image: Int, text: String, isLast: Boolean) =
            IntroPageFragment().apply {
                arguments = Bundle().apply {
                    putInt("img", image)
                    putString("text", text)
                    putBoolean("last", isLast)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val img = view.findViewById<ImageView>(R.id.imgPlant)
        val text = view.findViewById<TextView>(R.id.tvTitle)
        val btn = view.findViewById<Button>(R.id.btnNext)

        img.setImageResource(requireArguments().getInt("img"))
        text.text = requireArguments().getString("text")

        btn.text = if (requireArguments().getBoolean("last")) "Get Started" else "Next"

        btn.setOnClickListener {
            (parentFragment as IntroFragment).nextPage()
        }
    }
}
