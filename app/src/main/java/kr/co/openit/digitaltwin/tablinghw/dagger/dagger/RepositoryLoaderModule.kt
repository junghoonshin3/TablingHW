package kr.co.openit.digitaltwin.tablinghw.dagger.dagger

import kr.co.openit.digitaltwin.tablinghw.model.TablingLoader
import kr.co.openit.digitaltwin.tablinghw.model.ModelRepository
import kr.co.openit.digitaltwin.tablinghw.model.NetManager
import kr.co.openit.digitaltwin.tablinghw.model.remote.ITablingRemoteSource
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingLocalSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ModuleRepository::class])
abstract class LoaderModule{
    @Binds
    @Singleton
    abstract fun bindLoader(modelRepository: ModelRepository): TablingLoader
}

@Module(includes = [NetModule::class, RemoteModule::class, LocalModule::class])
class ModuleRepository {
    @Provides
    @Singleton
    fun provideMainRepository(
        netManager: NetManager,
        localSource: TablingLocalSource,
        remoteSource: ITablingRemoteSource
    ): ModelRepository = ModelRepository(
        netManager, localSource, remoteSource
    )
}