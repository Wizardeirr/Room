package com.example.room.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.room.R
import com.example.room.adapter.ImageRecyclerAdapter
import com.example.room.databinding.FragmentImageSearchBinding
import com.example.room.util.BaseVBFragment
import javax.inject.Inject


class ImageSearchFragment @Inject constructor(

    private val imageRecyclerAdapter:ImageRecyclerAdapter

) : BaseVBFragment<FragmentImageSearchBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(): FragmentImageSearchBinding {
        return FragmentImageSearchBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }

}