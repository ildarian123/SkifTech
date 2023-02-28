package com.example.skiftech.presentation.userinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.skiftech.databinding.FragmentUserInfoBinding
import com.example.skiftech.domain.models.User
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInfoFragment : Fragment() {

    private lateinit var user: User
    private lateinit var binding: FragmentUserInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = requireArguments().getParcelable("user")!!
        setupUser(user)
    }

    private fun setupUser(user: User) {
        Picasso.get().load(user.picture?.medium).into(binding.ivUserAvatar)
        binding.tvEmail.text = user.email.toString()
        binding.tvGender.text = user.gender.toString()
        binding.tvFirstName.text = user.name?.first.toString()
        binding.tvLastName.text = user.name?.last.toString()
    }
}