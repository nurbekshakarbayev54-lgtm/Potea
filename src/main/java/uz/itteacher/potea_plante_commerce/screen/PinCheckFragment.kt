package uz.itteacher.potea_plante_commerce.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.itteacher.potea_plante_commerce.R
import uz.itteacher.potea_plante_commerce.util.PrefManager

class PinCheckFragment : Fragment() {

    private lateinit var pinEdit: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_pin_check, container, false)

        pinEdit = root.findViewById(R.id.pincodetext)
        val gridLayout = root.findViewById<GridLayout>(R.id.keyboardGrid)
        val btnCheck = root.findViewById<Button>(R.id.pincheckbtn)

        for (i in 0 until gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            if (child is Button) {
                child.setOnClickListener {
                    when (it.tag) {
                        "delete" -> deleteNumber()
                        else -> addNumber(it.tag.toString())
                    }
                }
            }
        }

        btnCheck.setOnClickListener {
            if (pinEdit.text.toString() == PrefManager.isPinCode(requireContext())) {
                findNavController().navigate(R.id.action_pinCheck_to_homeFragment)
            } else {
                pinEdit.setText("")
                pinEdit.error = "Wrong PIN"
            }
        }

        return root
    }

    private fun addNumber(num: String) {
        if (pinEdit.text.length < 4) {
            pinEdit.append(num)
        }
    }

    private fun deleteNumber() {
        val text = pinEdit.text.toString()
        if (text.isNotEmpty()) {
            pinEdit.setText(text.dropLast(1))
        }
    }
}
