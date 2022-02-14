package kr.co.openit.digitaltwin.tablinghw.model.remote

import kr.co.openit.digitaltwin.tablinghw.model.Recents
import kr.co.openit.digitaltwin.tablinghw.model.Saves
import retrofit2.http.GET

interface ITablingApi {
    @GET("save")
    suspend fun getSave(): Saves

    @GET("recent")
    suspend fun getRecent(): Recents
}