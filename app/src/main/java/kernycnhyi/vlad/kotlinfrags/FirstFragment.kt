package kernycnhyi.vlad.kotlinfrags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.changeTitleEditText.addTextChangedListener(SimpleTextWatcher {
            (activity as UpdateToolbarTitle).updateTitle(it.toString())
        })


        firstBtnNext.setOnClickListener {
            (activity as NavigationInterface).openSecondFragment()
        }
    }
}
