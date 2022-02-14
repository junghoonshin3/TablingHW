package kr.co.openit.digitaltwin.tablinghw.dagger.dagger

import kr.co.openit.digitaltwin.tablinghw.model.RemoteSource
import kr.co.openit.digitaltwin.tablinghw.model.remote.ITablingRemoteSource
import kr.co.openit.digitaltwin.tablinghw.model.remote.ITablingApi
import kr.co.openit.digitaltwin.tablinghw.model.remote.NetworkUrl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = [RemoteModule::class])
abstract class RemoteSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteSource(ITablingRemoteSource: ITablingRemoteSource): RemoteSource
}

@Module
class RemoteModule{

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(NetworkUrl.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    internal fun provideAPI(retrofit: Retrofit): ITablingApi = retrofit.create(ITablingApi::class.java)

    @Provides
    @Singleton
    fun provideRemoteSource(api: ITablingApi): ITablingRemoteSource = ITablingRemoteSource(api)
}
