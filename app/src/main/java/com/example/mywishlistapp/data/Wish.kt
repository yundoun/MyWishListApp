package com.example.mywishlistapp.data

//Wishlist 항목인 Wish의 외형을 설정한다
// 즉 항목의 property를 설정한다
data class Wish(
    val id : Long = 0L,
    val title : String = "",
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
