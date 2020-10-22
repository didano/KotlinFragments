package kernycnhyi.vlad.kotlinfrags

import android.os.Bundle
import kernycnhyi.vlad.kotlinfrags.base.BasicActivity
import kernycnhyi.vlad.kotlinfrags.interfaces.NavigationInterface
import kernycnhyi.vlad.kotlinfrags.interfaces.UpdateToolbarTitle
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent

class MainActivity : BasicActivity(), UpdateToolbarTitle,
    NavigationInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFirstFragment()
    }

    override fun updateTitle(str: String) {
        supportActionBar?.title = str
    }

    override fun openFirstFragment() {
        router.openFirstFrag(true)
    }

    override fun openThirdFragment(issue: ArticleContent.Issue) {
        router.openThirdFrag(issue, true)
    }

    override fun openSecondFragment() {
        router.openSecondFrag(true)
    }
}
