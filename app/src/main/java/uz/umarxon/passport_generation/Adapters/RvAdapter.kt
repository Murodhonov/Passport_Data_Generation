package uz.umarxon.passport_generation.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.umarxon.passport_generation.Entity.User
import uz.umarxon.passport_generation.databinding.RvItemBinding

class RvAdapter(private val list: List<User>,var myClick: MyClick) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(private var itemRv: RvItemBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: User, position: Int) {
            itemRv.name.text = "${position + 1}.${user.name}"
            itemRv.passId.text = user.pass_id

            itemRv.root.setOnClickListener{
                myClick.click(user)
            }
        }
    }

    interface MyClick{
        fun click(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}