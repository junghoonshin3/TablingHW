package kr.co.openit.digitaltwin.tablinghw.model.room

import android.util.Log
import kr.co.openit.digitaltwin.tablinghw.logging.TAGs
import kr.co.openit.digitaltwin.tablinghw.model.LocalSource
import kr.co.openit.digitaltwin.tablinghw.model.Recent
import kr.co.openit.digitaltwin.tablinghw.model.Save
import javax.inject.Inject

// Source-class which injected to the ModelRepository for working with database

class TablingLocalSource @Inject constructor(
    private val tablingDao: TablingDao
) : LocalSource {

    override suspend fun refreshDataRecent(recent: List<Recent>) {
        tablingDao.insertRecent(recent)
    }

    override suspend fun refreshDataSave(saves: List<Save>) {
        tablingDao.insertSaves(saves)
    }

    override suspend fun retrieveDataRecent(): List<Recent> {
        val recents = tablingDao.getRecents()
        Log.d(TAGs.roomTag, "Retrieved ${recents.size} items from database")

        return recents.ifEmpty { emptyList() }
    }

    override suspend fun retrieveDataSave(): List<Save> {
        val saves = tablingDao.getSaves()
        Log.d(TAGs.roomTag, "Retrieved ${saves.size} items from database")

        return saves.ifEmpty { emptyList() }
    }
}