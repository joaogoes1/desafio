package com.picpay.desafio.android.userlist.presentation.userlist

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.userlist.data.model.User

object UserListDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem == newItem
}