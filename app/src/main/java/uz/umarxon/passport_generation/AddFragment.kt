package uz.umarxon.passport_generation

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog.view.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_add.view.address
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragment_view.view.*
import uz.umarxon.passport_generation.Adapters.RvAdapter
import uz.umarxon.passport_generation.Database.AppDatabase
import uz.umarxon.passport_generation.Entity.User
import uz.umarxon.passport_generation.databinding.FragmentAddBinding
import uz.umarxon.road_rules.Utils.Data
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class AddFragment : Fragment() {

    lateinit var root: View
    lateinit var binding: FragmentAddBinding
    lateinit var adapter: RvAdapter
    lateinit var db: AppDatabase
    var image = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        root = inflater.inflate(R.layout.fragment_add, container, false)
        binding = FragmentAddBinding.inflate(layoutInflater)

        root.imageAdd.setOnClickListener {
            getImageContent.launch("image/*")
        }

        root.back_arrow12.setOnClickListener {
            findNavController().popBackStack()
        }

        root.btn_save.setOnClickListener {
            val name = root.name.text.toString().trim()
            val surname = root.surname.text.toString().trim()
            val lastname = root.lastname.text.toString().trim()
            val region = when (root.spinner_region.selectedItemPosition) {
                0 -> {
                    ""
                }
                1 -> {
                    "Farg'ona"
                }
                2 -> {
                    "Andijon"
                }
                else -> {
                    "Namangan"
                }
            }

            val city = root.city.text.toString().trim()
            val address = root.address.text.toString().trim()
            val pass_given_time = root.time.text.toString().trim()
            val pass_exp = root.expiration_date.text.toString().trim()
            val male_female = when (root.spinner_male_female.selectedItemPosition) {
                0 -> {
                    ""
                }
                1 -> {
                    "Erkak"
                }
                else -> {
                    "Ayol"
                }
            }

            if (name.isNotEmpty() && surname.isNotEmpty() && lastname.isNotEmpty() && region.isNotEmpty() && city.isNotEmpty() && address.isNotEmpty() && pass_given_time.isNotEmpty() && pass_exp.isNotEmpty() && male_female.isNotEmpty()) {

                val alert = BottomSheetDialog(root.context,R.style.SheetDialog)

                val itemView = LayoutInflater.from(root.context).inflate(R.layout.dialog,null,false)
                alert.setContentView(itemView)

                itemView.yes.setOnClickListener {
                    val rand = java.util.Random()

                    val str = "ABCDEFGHIJKLMNOPQRSTUVXYZ"
                    var matn = ""
                    for (i in 0..1) {
                        val randomNumber = rand.nextInt(str.length)
                        matn += str[randomNumber]
                    }
                    for (i in 0..6) {
                        val randomNumber = rand.nextInt(9)
                        matn += randomNumber
                    }

                    val id = matn

                    AppDatabase.getInstance(root.context).userDao().addUser(User(name,surname,lastname,region,city,address,pass_given_time,pass_exp,male_female,image,id))
                    Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                    alert.hide()
                }

                itemView.no.setOnClickListener {
                    alert.hide()
                }

                alert.show()

            } else {
                Toast.makeText(context, "Ma'lumotlar yetarli emas", Toast.LENGTH_SHORT).show()
            }

        }

        return root
    }

    override fun onStart() {
        super.onStart()
        Data.isHome = false
    }

    @SuppressLint("SimpleDateFormat")
    private val getImageContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri ->
            uri ?: return@registerForActivityResult
            root.imageAdd.setImageURI(uri)

            val inputStream = activity?.contentResolver?.openInputStream(uri)
            val simpleDateFormat = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val file = File(activity?.filesDir, "${simpleDateFormat}rasm.jpg")
            val fileOutputStream = FileOutputStream(file)
            inputStream?.copyTo(fileOutputStream)

            inputStream?.close()
            fileOutputStream.close()

            image = file.absolutePath
        }
}