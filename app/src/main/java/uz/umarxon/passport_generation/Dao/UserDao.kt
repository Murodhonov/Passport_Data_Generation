package uz.umarxon.passport_generation.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.umarxon.passport_generation.Entity.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user:User)

    @Query("select * from user")
    fun getAllUser():List<User>
}