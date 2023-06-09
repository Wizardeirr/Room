package com.example.room.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.adapter.ArtRecyclerAdapter
import com.example.room.databinding.FragmentLoginBinding
import com.example.room.util.BaseVBFragment
import com.example.room.viewmodel.ModelViewModel
import javax.inject.Inject


class LoginFragment @Inject constructor(

    private val artRecyclerAdapter: ArtRecyclerAdapter
) : BaseVBFragment<FragmentLoginBinding>() {
    private lateinit var viewModel: ModelViewModel

    private val swipeCallback=object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition=viewHolder.layoutPosition
            val deleteModel=artRecyclerAdapter.models[layoutPosition]
            viewModel.deleteModel(deleteModel)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ModelViewModel::class.java)
        binding.recyclerViewArt.adapter=artRecyclerAdapter
        binding.recyclerViewArt.layoutManager=LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            val action=LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
        subscribeData()

    }
    fun subscribeData(){
        viewModel.modelList.observe(viewLifecycleOwner, Observer {
            artRecyclerAdapter.models=it
        })
    }

}