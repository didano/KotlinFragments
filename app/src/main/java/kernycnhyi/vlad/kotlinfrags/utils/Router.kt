package kernycnhyi.vlad.kotlinfrags.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kernycnhyi.vlad.kotlinfrags.fragments.CustomViewFragment
import kernycnhyi.vlad.kotlinfrags.fragments.SecondFragment
import kernycnhyi.vlad.kotlinfrags.fragments.ThirdFragment
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent

class Router(private val fragmentManager: FragmentManager, private val containerId: Int) {


    fun openFirstFrag(addToBackStack: Boolean = true) {
        openFragment(CustomViewFragment(), addToBackStack)
    }

    fun openSecondFrag(addToBackStack: Boolean = true) {
        openFragment(SecondFragment(), addToBackStack)
    }

    fun openThirdFrag(issue: ArticleContent.Issue, addToBackStack: Boolean = true) {
            openFragment(ThirdFragment.newInstance(issue), addToBackStack)
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
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