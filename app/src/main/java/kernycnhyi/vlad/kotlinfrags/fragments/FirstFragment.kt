package kernycnhyi.vlad.kotlinfrags.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kernycnhyi.vlad.kotlinfrags.interfaces.NavigationInterface
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.utils.SimpleTextWatcher
import kernycnhyi.vlad.kotlinfrags.interfaces.UpdateToolbarTitle
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeTitleEditText.addTextChangedListener(SimpleTextWatcher {
            (activity as? UpdateToolbarTitle)?.updateTitle(it.toString())
        })


        firstBtnNext.setOnClickListener {
            (activity as? NavigationInterface)?.openSecondFragment()
        }
    }
}
