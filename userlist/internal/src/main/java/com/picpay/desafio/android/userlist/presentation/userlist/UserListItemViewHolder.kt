package com.picpay.desafio.android.userlist.presentation.userlist

import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.commons.extensions.hide
import com.picpay.desafio.android.commons.extensions.show
import com.picpay.desafio.android.userlist.R
import com.picpay.desafio.android.userlist.data.model.User
import com.picpay.desafio.android.userlist.databinding.ListItemUserBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserListItemViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.name.text = user.name
        binding.username.text = user.username
        binding.progressBar.show()
        Picasso
            .get()
            .load(user.img)
            .error(R.drawable.ic_round_account_circle)
            .into(binding.picture, object : Callback {
                override fun onSuccess() {
                    binding.progressBar.hide()
                }

                override fun onError(e: Exception?) {
                    binding.progressBar.hide()
                }
            })
    }
}