package com.example.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// 추상 클래스는 구현이 필요하지 않은 메소드를 포함한 클래스
@Dao // 데이터베이스에 접근하는 메소드를 포함한 클래스
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // 중복되는 항목이 있을 경우 무시한다
    abstract suspend fun addAWish(wishEntity: Wish)
    // suspend(중단) : 비동기 함수로 만들어준다. 코루틴을 사용할 수 있게 해준다. (동시에 백그라운드에서 실행)

    // 데이터베이스에서 load로 가져오고 싶은 것이 뭔지 정의하는 곳
    @Query("Select * from `wish-table`") // wish-table에서 모든 항목을 가져온다
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract  fun updateAWish(wishEntity: Wish)

    @Delete
    abstract  fun deleteAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAllWishesById(id:Long): Flow<Wish> // id에 해당하는 항목을 가져온다 (하나의 값)
}