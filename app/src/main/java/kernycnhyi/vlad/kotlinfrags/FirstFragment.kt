package kernycnhyi.vlad.kotlinfrags


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_first, container, false)
        v.firstBtnNext.setOnClickListener {
            Router(fragmentManager!!, R.id.fragment_container).firstNextSecond()
        }
        return v
    }


}
