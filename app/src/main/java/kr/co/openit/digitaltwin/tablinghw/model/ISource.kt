package kr.co.openit.digitaltwin.tablinghw.model

interface Source {
    suspend fun retrieveDataRecent(): List<Recent>
    suspend fun retrieveDataSave(): List<Save>
}

interface LocalSource : Source {
    suspend fun refreshDataRecent(recent: List<Recent>)
    suspend fun refreshDataSave(save: List<Save>)
}

interface RemoteSource : Source