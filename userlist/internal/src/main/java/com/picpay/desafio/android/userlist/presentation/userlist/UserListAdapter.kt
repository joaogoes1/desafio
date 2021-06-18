package com.picpay.desafio.android.userlist.presentation.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.userlist.data.model.User
import com.picpay.desafio.android.userlist.databinding.ListItemUserBinding

class UserListAdapter : ListAdapter<User, UserListItemViewHolder>(UserListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemUserBinding.inflate(inflater, parent, false)
        return UserListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}