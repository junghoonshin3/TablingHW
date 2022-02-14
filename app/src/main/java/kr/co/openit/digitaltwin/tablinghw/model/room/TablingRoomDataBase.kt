package kr.co.openit.digitaltwin.tablinghw.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.openit.digitaltwin.tablinghw.model.Recent
import kr.co.openit.digitaltwin.tablinghw.model.Save
import kr.co.openit.digitaltwin.tablinghw.model.room.TablingDao

// DataBase class (provides in dagger.source.source.module)

@Database(entities = [Recent::class, Save::class], version = 1, exportSchema = false)
abstract class TablingRoomDataBase : RoomDatabase() {

    abstract fun tablingDao(): TablingDao

}