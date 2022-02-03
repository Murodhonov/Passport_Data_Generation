package uz.umarxon.passport_generation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import uz.umarxon.road_rules.Utils.Data

class HomeFragment : Fragment() {

    lateinit var root:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        Data.isHome = false

        return root
    }

    override fun onStart() {
        super.onStart()
        val anim = AnimationUtils.loadAnimation(root.context,R.anim.anim)
        root.startAnimation(anim)

        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                findNavController().navigate(R.id.menuFragment)
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
    }

}