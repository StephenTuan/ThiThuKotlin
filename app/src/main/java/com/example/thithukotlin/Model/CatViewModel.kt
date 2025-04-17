package com.example.thithukotlin.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thithukotlin.Repository.CatRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CatViewModel : ViewModel() {
    private val repository = CatRepository()

    private val _catList = MutableStateFlow<List<Cat>>(emptyList())
    val catList: StateFlow<List<Cat>> = _catList

    private val _selectedCat = MutableStateFlow<Cat?>(null)
    val selectedCat: StateFlow<Cat?> = _selectedCat

    init {
        fetchCats()
    }

    private fun fetchCats() {
        viewModelScope.launch {
            _catList.value = repository.getCats()
        }
    }

    fun selectCat(cat: Cat) {
        _selectedCat.value = cat
    }

    fun dismissDialog() {
        _selectedCat.value = null
    }
}
