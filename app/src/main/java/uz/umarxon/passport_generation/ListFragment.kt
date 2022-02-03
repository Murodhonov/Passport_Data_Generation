package uz.umarxon.passport_generation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_list.view.*
import uz.umarxon.passport_generation.Adapters.RvAdapter
import uz.umarxon.passport_generation.Database.AppDatabase
import uz.umarxon.passport_generation.Entity.User
import uz.umarxon.road_rules.Utils.Data

class ListFragment : Fragment() {

    lateinit var root:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        root =  inflater.inflate(R.layout.fragment_list, container, false)

        root.back_arrow.setOnClickListener {
            findNavController().popBackStack()
        }

        return root
    }

    override fun onResume() {
        super.onResume()

        Data.isHome = false

        root.rv.adapter = RvAdapter(AppDatabase.getInstance(root.context).userDao().getAllUser() as ArrayList<User>,object : RvAdapter.MyClick{
            override fun click(user: User) {
                findNavController().navigate(R.id.viewFragment, bundleOf("user" to user))
            }
        })
    }

}