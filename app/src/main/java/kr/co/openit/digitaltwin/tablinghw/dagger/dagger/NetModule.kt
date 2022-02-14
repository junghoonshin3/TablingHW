package kr.co.openit.digitaltwin.tablinghw.dagger.dagger

import android.content.Context
import kr.co.openit.digitaltwin.tablinghw.model.NetManager
import dagger.*
import javax.inject.Singleton

@Module
class NetModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideNetManager(): NetManager = NetManager(context)
}