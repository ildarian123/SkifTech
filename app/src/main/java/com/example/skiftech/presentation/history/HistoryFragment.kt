package com.example.skiftech.presentation.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skiftech.databinding.FragmentHistoryBinding
import com.example.skiftech.presentation.users.UsersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val vm: HistoryViewModel by viewModels()
    private lateinit var mAdapter: HistoryUserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        vm.getUsers()
    }

    private fun setObservers() {
        vm.users.observe(viewLifecycleOwner) {
            val manager: RecyclerView.LayoutManager =
                LinearLayoutManager(activity)
            mAdapter = HistoryUserAdapter(it?: listOf())
            binding.rvHistoryUsers.layoutManager = manager
            binding.rvHistoryUsers.adapter = mAdapter
        }
    }


}