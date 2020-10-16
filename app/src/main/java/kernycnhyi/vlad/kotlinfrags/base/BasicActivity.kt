package kernycnhyi.vlad.kotlinfrags.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.utils.Router

abstract class BasicActivity : AppCompatActivity() {

    val router: Router by lazy {
        Router(
            supportFragmentManager,
            R.id.fragment_container
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
