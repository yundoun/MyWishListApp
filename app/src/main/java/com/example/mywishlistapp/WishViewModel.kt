package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository
) : ViewModel(){

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString:String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString:String){
        wishDescriptionState = newString
    }

    // var getAllWishes로 wish를 다 가져오기 위해서는 Flow를 사용해야 한다.
    // 모든 Wish의 List, 즉 Wish의 모든 데이터를 가져오기 위해서는 Flow<List<Wish>>를 사용해야 한다.
    lateinit var getAllWishes: Flow<List<Wish>>
    // lateinit : 나중에 초기화할 수 있는 변수를 선언할 때 사용한다.
    // 객체 생성 중 초기화할 수 없는 속성이 있지만 초기화 후 non-null로 사용할 수 있는 속성을 선언할 때 사용한다.
    // Flow란? : 비동기적으로 값을 생성하는 컬렉션으로, 값을 한 번에 하나씩 생성한다.

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    } // init : 초기화 블록으로, 객체가 생성될 때 초기화되는 코드를 작성한다.
    // 이제 getAllWishes가 empty 상태가 아니다.

    // 아래 함수는 모두 suspend 함수로, 코루틴을 사용하여 백그라운드에서 실행된다. (?)

    fun addWish(wish : Wish){
        viewModelScope.launch(Dispatchers.IO) { // Dispatchers.IO : 최적화 된 스레드를 사용하여 백그라운드 작업을 수행한다.
            wishRepository.addAWish(wish= wish)
        }
    }

    fun getAWishById(id:Long) : Flow<Wish> {
        return wishRepository.getAWishById(id)
    }

    fun updateWish(wish : Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish= wish)
        }
    }

    fun deleteWish(wish : Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish)
        }
    }
}















