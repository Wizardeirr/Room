package com.example.room.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.databinding.FragmentRegisterBinding
import com.example.room.util.BaseVBFragment
import com.example.room.viewmodel.ModelViewModel
import javax.inject.Inject

class RegisterFragment : BaseVBFragment<FragmentRegisterBinding>() {
    private lateinit var viewModel:ModelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getViewBinding(): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(layoutInflater)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.artImageView.setOnClickListener {
            val action=RegisterFragmentDirections.actionRegisterFragmentToImageSearchFragment()
            findNavController().navigate(action)
        }
        binding.saveButton.setOnClickListener {


        }
    }

}