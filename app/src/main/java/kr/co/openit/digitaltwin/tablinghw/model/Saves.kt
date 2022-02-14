package kr.co.openit.digitaltwin.tablinghw.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings
import kr.co.openit.digitaltwin.tablinghw.view.Item


data class Saves(
    val list: List<Save>
)

@Entity(tableName = "saves")
@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
data class Save(
    @PrimaryKey
    val restaurantIdx: Int,
    val thumbnail: String,
    val classification: String,
    val restaurantName: String,
    val rating: String,
    val reviewCount: Int,
    val summaryAddress: String,
    val isQuickBooking: Boolean,
    val isRemoteWaiting: Boolean,
    val useWaiting: Boolean,
    val useBooking: Boolean,
    val isNew: Boolean,
    val waitingCount: Int
) : Item() {

    fun upTo300(): String {
        return if (reviewCount > 300) {
            "300+"
        } else {
            reviewCount.toString()
        }
    }
}