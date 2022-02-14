package kr.co.openit.digitaltwin.tablinghw.model

interface Source {
    suspend fun retrieveDataRecent(): List<Recent>
    suspend fun retrieveDataSave(): List<Save>
}

interface LocalSource : Source {
    suspend fun refreshDataRecent(exhibits: List<Recent>)
    suspend fun refreshDataSave(exhibits: List<Save>)
}

interface RemoteSource : Source