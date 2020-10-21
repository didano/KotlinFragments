package kernycnhyi.vlad.kotlinfrags.interfaces

import kernycnhyi.vlad.kotlinfrags.model.ArticleContent

interface NavigationInterface {
    fun openFirstFragment()
    fun openSecondFragment()
    fun openThirdFragment(issue: ArticleContent.Issue)
}