package uz.itteacher.potea_plante_commerce.model

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class CubeTransformer : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.cameraDistance = 20000f

        when {
            position < 0 -> {
                page.pivotX = page.width.toFloat()
                page.rotationY = 90f * position
            }
            position > 0 -> {
                page.pivotX = 0f
                page.rotationY = 90f * position
            }
            else -> {
                page.rotationY = 0f
            }
        }
    }
}
