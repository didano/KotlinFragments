package kernycnhyi.vlad.kotlinfrags

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), UpdateToolbarTitle, NavigationInterface {

    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        router = Router(supportFragmentManager, R.id.fragment_container)
    }

    override fun updateTitle(str: String) {
        supportActionBar?.title = str
    }

    override fun openThirdFragment() {
        router.openThirdFrag(true)
    }

    override fun openSecondFragment() {
        router.openSecondFrag(true)
    }
}
