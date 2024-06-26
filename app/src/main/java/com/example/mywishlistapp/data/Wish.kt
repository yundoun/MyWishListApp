package com.example.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Wishlist 항목인 Wish의 외형을 설정한다
// 즉 항목의 property를 설정한다

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true) // 자동으로 증가하는 id를 설정한다
    val id : Long = 0L,
    @ColumnInfo(name = "wish-title") //
    val title : String = "",
    @ColumnInfo(name = "wish-desc")
    val description : String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "Google Watch 2 구매"),
        Wish(title = "Google Watch 3", description = "Google Watch 3 구매"),
        Wish(title = "Google Watch 4", description = "Google Watch 4 구매"),
        Wish(title = "Google Watch 5", description = "Google Watch 5 구매"),
    )
}
