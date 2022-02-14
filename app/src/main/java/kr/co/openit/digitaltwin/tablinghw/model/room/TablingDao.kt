package kr.co.openit.digitaltwin.tablinghw.model.room

import androidx.room.*
import kr.co.openit.digitaltwin.tablinghw.model.Recent
import kr.co.openit.digitaltwin.tablinghw.model.Save

@Dao
interface TablingDao {
    @Query("SELECT * from recents")
    suspend fun getRecents(): List<Recent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecent(recents: List<Recent>): List<Long>

    @Query("SELECT COUNT(*) FROM recents")
    suspend fun countOfRowsRecent(): Int

    @Query("SELECT * from saves")
    suspend fun getSaves(): List<Save>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaves(saves: List<Save>): List<Long>

    @Query("SELECT COUNT(*) FROM saves")
    suspend fun countOfRowsSaves(): Int


}