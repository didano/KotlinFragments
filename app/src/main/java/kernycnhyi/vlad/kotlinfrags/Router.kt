package kernycnhyi.vlad.kotlinfrags

import androidx.fragment.app.FragmentManager

class Router(private val fragmentManager: FragmentManager, private val containerId: Int) {

    fun initFirstFrag() {
        fragmentManager.beginTransaction().add(containerId, FirstFragment()).commit()
    }

    fun firstNextSecond() {
        fragmentManager.beginTransaction().replace(containerId, SecondFragment())
            .addToBackStack(null)
            .commit()
    }

    fun secondNextThird() {

        fragmentManager.beginTransaction().replace(containerId, ThirdFragment())
            .addToBackStack(null)
            .commit()
    }

    fun secondBackFirst() {
        fragmentManager.popBackStack()
    }

    fun thirdBackSecond() {
        fragmentManager.popBackStack()
    }

    companion object {
        const val containerId = R.id.fragment_container
    }

}