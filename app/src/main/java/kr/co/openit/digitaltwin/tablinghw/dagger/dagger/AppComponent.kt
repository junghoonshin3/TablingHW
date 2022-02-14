package kr.co.openit.digitaltwin.tablinghw.dagger.dagger

import android.app.Application
import kr.co.openit.digitaltwin.tablinghw.dagger.dagger.viewmodelmodules.ViewModelModule
import kr.co.openit.digitaltwin.tablinghw.model.ModelRepository
import kr.co.openit.digitaltwin.tablinghw.model.remote.ITablingRemoteSource
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingDao
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingLocalSource
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kr.co.openit.digitaltwin.tablinghw.view.MainActivity
import kr.co.openit.digitaltwin.tablinghw.view.favorite.FavoriteFragment
import kr.co.openit.digitaltwin.tablinghw.view.favorite.RecentFragment
import kr.co.openit.digitaltwin.tablinghw.view.favorite.SaveFragment
import kr.co.openit.digitaltwin.tablinghw.viewmodel.FavoriteViewModel
import javax.inject.Singleton

@Component(
    modules = [AndroidSupportInjectionModule::class, ViewModelModule::class,
        FragmentModule::class, ModuleRepository::class, LocalModule::class,
        RemoteModule::class, NetModule::class, ViewModule::class, LoaderModule::class,
        RemoteSourceModule::class, LocalSourceModule::class]
)
@Singleton
interface AppComponent {
    fun inject(application: App)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun setNetModule(netModule: NetModule): Builder

        fun setLocalModule(localModule: LocalModule): Builder

        @BindsInstance
        fun bindApplication(application: Application): Builder
    }

    fun provideDao(): TablingDao

    fun provideLocalSrc(): TablingLocalSource

    fun provideRemoteSrc(): ITablingRemoteSource

    fun provideFavoriteViewModel(): FavoriteViewModel

    fun provideModelRepo(): ModelRepository
}

@Module
abstract class ViewModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeActivityAndroidInjector(): MainActivity
}

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeFavoriteFragmentViewModelInjector(): FavoriteFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeRecentFragmentViewModelInjector(): RecentFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeSaveFragmentViewModelInjector(): SaveFragment
}