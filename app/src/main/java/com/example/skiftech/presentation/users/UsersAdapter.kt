package com.example.skiftech.presentation.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skiftech.databinding.UserListItemBinding
import com.example.skiftech.domain.models.User
import com.squareup.picasso.Picasso

class UsersAdapter(
    var userList: List<User>, private val clickListener: ClickListener
) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(userList[position]) {
                Picasso.get().load(this.picture?.medium).into(binding.ivUserAvatar)
                binding.tvFirstName.text = this.name?.first.toString()

                binding.clUserContainer.setOnClickListener {
                    clickListener.onClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}