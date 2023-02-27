package com.example.skiftech.presentation.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skiftech.R
import com.example.skiftech.databinding.FragmentUsersBinding
import com.example.skiftech.domain.models.User
import com.example.skiftech.domain.models.UserResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(), ClickListener {

    private lateinit var binding: FragmentUsersBinding
    private val vm: UsersViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var mAdapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navController = findNavController()
        binding = FragmentUsersBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setObservers() {
        vm.users.observe(viewLifecycleOwner) {
            if (it == null) {
                Toast.makeText(requireContext(), "server error", Toast.LENGTH_LONG).show()
            }else{
                updateUserList(it)
            }

        }
    }

    private fun updateUserList(userList: UserResponse) {
        val manager: RecyclerView.LayoutManager =
            LinearLayoutManager(activity)
        mAdapter = UsersAdapter(userList.results?: listOf(), clickListener = this)
        binding.rvUsers.layoutManager = manager
        binding.rvUsers.adapter = mAdapter
    }

    private fun getData() {
        getUsers()
    }

    private fun getUsers() {
        vm.getUsers()
    }

    override fun onClick(user: User) {
        navController.navigate(R.id.action_users_fragment_to_user_info_fragment)
    }
}