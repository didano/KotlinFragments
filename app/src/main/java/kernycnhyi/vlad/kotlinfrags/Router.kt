package kernycnhyi.vlad.kotlinfrags

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Router(private val fragmentManager: FragmentManager, private val containerId: Int) {

    init {
        initFirstFrag()
    }

    private fun initFirstFrag() {
        fragmentManager.beginTransaction().add(containerId, FirstFragment()).commit()
    }

    fun openSecondFrag(addToBackStack: Boolean = true) {
        openFragment(SecondFragment(), addToBackStack)
    }

    fun openThirdFrag(addToBackStack: Boolean = true) {
        openFragment(ThirdFragment(), addToBackStack)
    }

    fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        if (addToBackStack) {
            fragmentManager.beginTransaction().replace(containerId, fragment)
                .addToBackStack(null)
                .commit()
        } else {
            fragmentManager.beginTransaction().replace(containerId, fragment)
                .commit()
        }
    }
}