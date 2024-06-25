package com.example.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.example.mywishlistapp.data.WishDatabase
import com.example.mywishlistapp.data.WishRepository

// object 키워드를 사용하여 sigleton 객체를 생성한다.
// singleton(싱글톤)은 어플리케이션에 단 하나의 instance(인스턴스)만 존재하는 클래스
// 즉, 다른 이름을 부여하는 다른 Graph를 만들 수 없다는 의미
// 따라서, 이 Graph는 앱의 나머지 부분에 dependency(종속 항목)을 제공하는 Service Locator(서비스 로케이터) 역할을 한다.

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