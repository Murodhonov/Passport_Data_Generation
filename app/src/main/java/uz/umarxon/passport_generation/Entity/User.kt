package uz.umarxon.passport_generation.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User :Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var name: String? = null
    var surname: String? = null
    var lastname: String? = null
    var region: String? = null
    var city: String? = null
    var address: String? = null
    var passport_given: String? = null
    var passport_exp: String? = null
    var male_female: String? = null
    var image: String? = null
    var pass_id:String? = null

    constructor(
        id: Int?,
        name: String?,
        surname: String?,
        lastname: String?,
        region: String?,
        city: String?,
        address: String?,
        passport_given: String?,
        passport_exp: String?,
        male_female: String?,
        image: String?,
        pass_id: String?,
    ) {
        this.id = id
        this.name = name
        this.surname = surname
        this.lastname = lastname
        this.region = region
        this.city = city
        this.address = address
        this.passport_given = passport_given
        this.passport_exp = passport_exp
        this.male_female = male_female
        this.image = image
        this.pass_id = pass_id
    }

    constructor(
        name: String?,
        surname: String?,
        lastname: String?,
        region: String?,
        city: String?,
        address: String?,
        passport_given: String?,
        passport_exp: String?,
        male_female: String?,
        image: String?,
        pass_id: String?,
    ) {
        this.name = name
        this.surname = surname
        this.lastname = lastname
        this.region = region
        this.city = city
        this.address = address
        this.passport_given = passport_given
        this.passport_exp = passport_exp
        this.male_female = male_female
        this.image = image
        this.pass_id = pass_id
    }

    constructor()

    override fun toString(): String {
        return "User(id=$id, name=$name, surname=$surname, lastname=$lastname, region=$region, city=$city, address=$address, passport_given=$passport_given, passport_exp=$passport_exp, male_female=$male_female, image=$image, pass_id=$pass_id)"
    }
}