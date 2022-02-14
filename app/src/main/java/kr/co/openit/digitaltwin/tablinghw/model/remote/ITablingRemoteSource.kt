package kr.co.openit.digitaltwin.tablinghw.model.remote

import android.util.Log
import kr.co.openit.digitaltwin.tablinghw.logging.TAGs
import kr.co.openit.digitaltwin.tablinghw.model.RemoteSource
import kotlinx.coroutines.*
import kr.co.openit.digitaltwin.tablinghw.model.Recent
import kr.co.openit.digitaltwin.tablinghw.model.Save
import javax.inject.Inject

class ITablingRemoteSource @Inject constructor(
    private val api: ITablingApi
) : RemoteSource {

    override suspend fun retrieveDataRecent(): List<Recent> = withContext(Dispatchers.IO) {
        val list = api.getRecent().list
        Log.d(TAGs.retrofitTag, "Retrieved ${list.size} recent items from network")
        list
    }

    override suspend fun retrieveDataSave(): List<Save> = withContext(Dispatchers.IO) {
        val list = api.getSave().list
        Log.d(TAGs.retrofitTag, "Retrieved ${list.size} save items from network")
        list
    }
}