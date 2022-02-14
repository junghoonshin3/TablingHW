package kr.co.openit.digitaltwin.tablinghw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kr.co.openit.digitaltwin.tablinghw.model.Recent
import kr.co.openit.digitaltwin.tablinghw.model.Save
import kr.co.openit.digitaltwin.tablinghw.model.TablingLoader
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    val loader: TablingLoader
) : ViewModel() {

    private val _recentList = MutableLiveData<MutableList<Recent>>()
    private val _saveList = MutableLiveData<MutableList<Save>>()
    private lateinit var viewModelJob: Job

    init {
        loadRecentData()
        loadSaveData()
    }

    fun loadRecentData() {
        viewModelJob = viewModelScope.launch {
            val recent = loader.getRecentList()
            _recentList.postValue(recent.toMutableList())
        }
    }

    fun loadSaveData() {
        viewModelJob = viewModelScope.launch {
            val save = loader.getSaveList()
            _saveList.postValue(save.toMutableList())
        }
    }

    fun getSaveList(): LiveData<MutableList<Save>> = _saveList

    fun getRecentList(): LiveData<MutableList<Recent>> = _recentList

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}