package uz.umarxon.passport_generation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import uz.umarxon.road_rules.Utils.Data

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    override fun onBackPressed() {
        if(Data.isHome){
            finish()
        }else{
            findNavController(R.id.my_host).popBackStack()
        }
    }
}