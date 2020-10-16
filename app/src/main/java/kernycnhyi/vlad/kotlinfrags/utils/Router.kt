package kernycnhyi.vlad.kotlinfrags.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kernycnhyi.vlad.kotlinfrags.fragments.FirstFragment
import kernycnhyi.vlad.kotlinfrags.fragments.SecondFragment
import kernycnhyi.vlad.kotlinfrags.fragments.ThirdFragment

class Router(private val fragmentManager: FragmentManager, private val containerId: Int) {

    fun initFirstFrag() {
        fragmentManager.beginTransaction().add(containerId,
            FirstFragment()
        ).commit()
    }

    fun openFirstFrag(addToBackStack: Boolean = true) {
        openFragment(FirstFragment(), addToBackStack)
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