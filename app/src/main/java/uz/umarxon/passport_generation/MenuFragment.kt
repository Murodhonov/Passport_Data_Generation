package uz.umarxon.passport_generation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_menu.view.*
import uz.umarxon.road_rules.Utils.Data

class MenuFragment : Fragment() {

    lateinit var root:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_menu, container, false)

        root.all_people.setOnClickListener {
            findNavController().navigate(R.id.listFragment)
        }

        root.add_people.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        return root
    }

    override fun onStart() {
        super.onStart()

        Data.isHome = true
    }


}