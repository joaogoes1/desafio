package com.picpay.desafio.android.userlist.presentation.userlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.picpay.desafio.android.commons.extensions.hide
import com.picpay.desafio.android.commons.extensions.show
import com.picpay.desafio.android.userlist.R
import com.picpay.desafio.android.userlist.databinding.UserListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserListFragment : Fragment(R.layout.user_list_fragment) {

    private val binding: UserListFragmentBinding by viewBinding(UserListFragmentBinding::bind)
    private val viewModel: UserListViewModel by viewModels()
    private val adapter = UserListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setupObservers()
        viewModel.loadUserList()
    }

    private fun setupObservers() {
        viewModel.viewState.list.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        viewModel.viewState.state.observe(viewLifecycleOwner, {
            when (it) {
                UserListViewState.State.SUCCESS -> {
                    binding.userListProgressBar.hide()
                    binding.recyclerView.show()
                }
                UserListViewState.State.LOADING -> {
                    binding.userListProgressBar.show()
                    binding.recyclerView.hide()
                }
                else -> {}
            }
        })
    }
}
