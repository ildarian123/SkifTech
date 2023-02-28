package com.example.skiftech.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skiftech.data.base.models.UserDb
import com.example.skiftech.databinding.UserHistoryListItemBinding
import com.squareup.picasso.Picasso

class HistoryUserAdapter(
    var userList: List<UserDb>
) : RecyclerView.Adapter<HistoryUserAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: UserHistoryListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            UserHistoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(userList[position]) {
                Picasso.get().load(this.picture).into(binding.ivUserAvatar)
                binding.tvEmail.text = this.email.toString()
                binding.tvGender.text = this.gender.toString()
                binding.tvFirstName.text = this.firstName.toString()
                binding.tvLastName.text = this.lastName.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}