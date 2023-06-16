package com.example.room

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.example.room.adapter.ArtRecyclerAdapter
import com.example.room.adapter.ImageRecyclerAdapter
import com.example.room.view.ImageSearchFragment
import com.example.room.view.LoginFragment
import com.example.room.view.RegisterFragment
import javax.inject.Inject

class ModelFragmentFactory @Inject constructor(
    private val artRecyclerAdapter: ArtRecyclerAdapter,
    private val glide: RequestManager,
    private val imageRecyclerAdapter: ImageRecyclerAdapter,
) :FragmentFactory(){
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when(className){
            LoginFragment::class.java.name ->LoginFragment(artRecyclerAdapter)
            ImageSearchFragment::class.java.name ->ImageSearchFragment(imageRecyclerAdapter)
            RegisterFragment::class.java.name->RegisterFragment()

            else -> super.instantiate(classLoader, className)
        }

    }
}