package com.example.mywishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

// 데이터베이스의 구조
@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class WishDatabase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}