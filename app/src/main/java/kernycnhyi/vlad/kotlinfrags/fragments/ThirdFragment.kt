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
            thirdFragTV.text = arguments?.getString(ArticleContent.HEADER_KEY)
            thirdFragDescription.text = arguments?.getString(ArticleContent.DESCRIPTION_KEY)
            newsLogoIV.setImageResource(arguments!!.getInt(ArticleContent.IMAGE_ID_KEY))
        }
    }

    companion object {
        fun newInstance(
            issue: ArticleContent.Issue?
        ): Fragment {
            val fragment = ThirdFragment()
            issue?.let {
                val args = Bundle()
                args.putString(ArticleContent.HEADER_KEY, issue.header)
                args.putString(ArticleContent.DESCRIPTION_KEY, issue.description)
                args.putInt(ArticleContent.IMAGE_ID_KEY, issue.image)
                fragment.arguments = args
                return fragment
            }
            return fragment
        }
    }
}
