package com.example.room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.repo.ModelRepositoryIF
import com.example.room.retrofit.ImageResponse
import com.example.room.room.Model
import com.example.room.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class ModelViewModel @Inject constructor(
    private val repository:ModelRepositoryIF,
):ViewModel() {

    val modelList = repository.getModel()

    private val images = MutableLiveData<Resource<ImageResponse>>()
    val imageList : LiveData<Resource<ImageResponse>>
        get() = images

    private val selectedImage = MutableLiveData<String>()
    val selectedImageUrl : LiveData<String>
        get() = selectedImage

    private var insertArtMsg = MutableLiveData<Resource<Model>>()
    val insertModelMessage : LiveData<Resource<Model>>
        get() = insertArtMsg

    //Solving the navigation bug
    fun resetInsertModelMsg() {
        insertArtMsg = MutableLiveData<Resource<Model>>()
    }

    fun setSelectedImage(url : String) {
        selectedImage.postValue(url)
    }

    fun deleteModel(model:Model) = viewModelScope.launch {
        repository.deleteModel(model)
    }

    fun insertModel(model:Model) = viewModelScope.launch {
        repository.insertModel(model)
    }
    fun makeModel(name : String, artistName : String, year : String) {
        if (name.isEmpty() || artistName.isEmpty() || year.isEmpty() ) {
            insertArtMsg.postValue(Resource.error("Enter name, artist, year", null))
            return
        }
        val yearInt = try {
            year.toInt()
        } catch (e: Exception) {
            insertArtMsg.postValue(Resource.error("Year should be number",null))
            return
        }

        val art = Model(name, artistName, yearInt,selectedImage.value?: "")
        insertModel(art)
        setSelectedImage("")
        insertArtMsg.postValue(Resource.success(art))
    }

    fun searchForImage (searchString : String) {

        if(searchString.isEmpty()) {
            return
        }
        images.value = Resource.loading(null)
        viewModelScope.launch {
            val response = repository.searchImage(searchString)
            images.value = response
        }
    }
}