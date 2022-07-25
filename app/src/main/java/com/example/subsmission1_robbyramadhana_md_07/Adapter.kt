package com.example.subsmission1_robbyramadhana_md_07

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.subsmission1_robbyramadhana_md_07.DetailUser.Companion.EXTRA_USER
import com.example.subsmission1_robbyramadhana_md_07.databinding.ListUserBinding

class Adapter : RecyclerView.Adapter<Adapter.UserViewHolder>() {

    private val listUser = ArrayList<DataUser>()

    fun setAllData(data: List<DataUser>) {
        listUser.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class UserViewHolder(private val view: ListUserBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(user: DataUser) {

            view.apply {
                txtName.text = user.name
                txtCompany.text = user.company
                txtLocation.text = user.location
            }

            Glide.with(itemView.context)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(view.imgAvatar)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailUser::class.java)
                intent.putExtra(EXTRA_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }
}
