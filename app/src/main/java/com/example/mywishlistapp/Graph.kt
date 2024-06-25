package com.example.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.example.mywishlistapp.data.WishDatabase
import com.example.mywishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }
    // by lazy : 프로퍼티를 초기화하는 데 사용되는 람다를 지연 초기화한다.
    // 변수 초기화가 필요할 때에만 사용되도록 한다. 즉, 어플을 연 순간 모둔 것을 처음부터 load 하는 것이 아니라 접근이 필요할 때만 load한다.


    // 데이터베이스 생성 시 어떤 Context에서 할 지 알아야 하므로 provide 함수를 통해 데이터베이스 초기화
    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wish-db")
            .build()
        
    }

}