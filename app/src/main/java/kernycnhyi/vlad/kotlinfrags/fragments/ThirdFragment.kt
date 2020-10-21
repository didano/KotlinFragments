package kernycnhyi.vlad.kotlinfrags.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment private constructor() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_third, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thirdBtnBack.setOnClickListener { fragmentManager?.popBackStack() }
        arguments?.let {
            thirdFragTV.text = arguments?.getString(HEADER_KEY)
            thirdFragDescription.text = arguments?.getString(DESCRIPTION_KEY)
            newsLogoIV.setImageResource(arguments!!.getInt(IMAGE_ID_KEY))
        }
    }

    companion object {
        private const val HEADER_KEY = "headerKey"
        private const val DESCRIPTION_KEY = "descriptionKey"
        private const val IMAGE_ID_KEY = "imgIdKey"

        fun newInstance(
            issue: ArticleContent.Issue
        ): Fragment = ThirdFragment().apply {
            this.arguments = Bundle().apply {
                putString(HEADER_KEY, issue.header)
                putString(DESCRIPTION_KEY, issue.description)
                putInt(IMAGE_ID_KEY, issue.image)
            }
        }
    }
}
