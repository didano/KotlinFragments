package kernycnhyi.vlad.kotlinfrags


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third.view.*

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_third, container, false)
        v.thirdBtnBack.setOnClickListener {
            Router(fragmentManager!!,Router.containerId).thirdBackSecond()
        }
        return v
    }


}
