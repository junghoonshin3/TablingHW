package kr.co.openit.digitaltwin.tablinghw.dagger.dagger

import android.content.Context
import androidx.room.Room
import kr.co.openit.digitaltwin.tablinghw.model.LocalSource
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingDao
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingLocalSource
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingRoomDataBase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [LocalModule::class])
abstract class LocalSourceModule {
    @Binds
    @Singleton
    abstract fun bindLocalSource(tablingLocalSource: TablingLocalSource): LocalSource
}

@Module
class LocalModule(private val context: Context) {
    companion object {
        const val databaseName = "product_database"
    }

    @Provides
    @Singleton
    fun provideDataBase(): TablingRoomDataBase =
        Room.databaseBuilder(
            context.applicationContext,
            TablingRoomDataBase::class.java,
            databaseName
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(tablingRoomDataBase: TablingRoomDataBase): TablingDao =
        tablingRoomDataBase.tablingDao()

    @Provides
    @Singleton
    fun provideLocalSource(tablingDao: TablingDao): TablingLocalSource =
        TablingLocalSource(tablingDao)
}