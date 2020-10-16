package kernycnhyi.vlad.kotlinfrags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Router(supportFragmentManager,R.id.fragment_container).initFirstFrag()
    }
}
