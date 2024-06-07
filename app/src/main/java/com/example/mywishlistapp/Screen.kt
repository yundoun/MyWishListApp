package com.example.mywishlistapp


// sealed class란 추상 클래스로 상속 받는 자식 클래스의 종류를 제한하는 특성을 가지고 있다.
// 즉, 컴파일러에서 sealed class의 자식 클래스가 어떤 것이 있는지 알 수 있다.
sealed class Screen(val route:String) {
    object HomeScreen : Screen("home_screen")
    object AddScreen : Screen("add_screen")

}