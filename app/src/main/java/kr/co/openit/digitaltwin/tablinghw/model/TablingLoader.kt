package kr.co.openit.digitaltwin.tablinghw.model

interface TablingLoader {
    suspend fun getRecentList(): List<Recent>
    suspend fun getSaveList(): List<Save>

}