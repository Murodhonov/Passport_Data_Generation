package uz.umarxon.passport_generation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_view.view.*
import uz.umarxon.passport_generation.Entity.User
import uz.umarxon.passport_generation.databinding.FragmentViewBinding
import uz.umarxon.road_rules.Utils.Data

class ViewFragment : Fragment() {

    lateinit var root:View
    lateinit var binding:FragmentViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        root =  inflater.inflate(R.layout.fragment_view, container, false)
        binding = FragmentViewBinding.inflate(layoutInflater)

        val user = arguments?.getSerializable("user") as User

        root.back_arrow.setOnClickListener {
            findNavController().popBackStack()
        }

        root.title.text = user.name
        root.image.setImageURI(Uri.parse(user.image))
        root.pass_id.text = "Passport id: ${user.pass_id}"
        root.region.text =  "Viloyati: ${user.region}"
        root.address.text =  "Adress: ${user.address}"
        root.full_name.text =  "${user.surname} ${user.name} ${user.lastname}"
        root.male_femlae.text =  "Jinsi: ${user.male_female}"
        root.pass_exp_date.text =  "Passport muddati: ${user.passport_exp}"
        root.pass_given_time.text =  "Passport olingan vaqti: ${user.passport_given}"

        return root
    }

    override fun onStart() {
        super.onStart()
        Data.isHome = false
    }


}