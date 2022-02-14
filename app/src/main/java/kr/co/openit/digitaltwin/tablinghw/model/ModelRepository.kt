package kr.co.openit.digitaltwin.tablinghw.model

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class ModelRepository @Inject constructor(
    private val netManager: NetManager,
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource
) : TablingLoader {

    override suspend fun getRecentList(): List<Recent> {
        return if (netManager.isConnectedToInternet)
            retrieveRemoteRecent()
        else
            retrieveLocalRecent()
    }

    override suspend fun getSaveList(): List<Save> {
        return if (netManager.isConnectedToInternet)
            retrieveRemoteSave()
        else
            retrieveLocalSave()
    }

    private suspend fun retrieveRemoteRecent(): List<Recent> {

        val recents = remoteSource.retrieveDataRecent()
        localSource.refreshDataRecent(recents)
        return recents
    }

    private suspend fun retrieveRemoteSave(): List<Save> {

        val saves = remoteSource.retrieveDataSave()
        localSource.refreshDataSave(saves)
        return saves
    }

    private suspend fun retrieveLocalRecent(): List<Recent> = localSource.retrieveDataRecent()

    private suspend fun retrieveLocalSave(): List<Save> = localSource.retrieveDataSave()
}

class NetManager @Inject constructor(private val applicationContext: Context) {

    val isConnectedToInternet: Boolean
        @SuppressLint("MissingPermission")
        get() {
            val conManager =
                applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = conManager.activeNetworkInfo
            return network != null && network.isConnected
        }
}
