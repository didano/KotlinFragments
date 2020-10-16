package kernycnhyi.vlad.kotlinfrags.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kernycnhyi.vlad.kotlinfrags.R
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_third, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thirdBtnBack.setOnClickListener { fragmentManager?.popBackStack() }
    }
}
