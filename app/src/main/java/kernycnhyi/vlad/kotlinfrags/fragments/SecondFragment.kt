package kernycnhyi.vlad.kotlinfrags.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.adapters.ArticleRecyclerAdapter
import kernycnhyi.vlad.kotlinfrags.interfaces.NavigationInterface
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    private val recyclerAdapter by lazy {
        ArticleRecyclerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        secNextBtn.setOnClickListener {
            (activity as? NavigationInterface)?.openThirdFragment()
        }
        secBackBtn.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }
        recyclerAdapter.newList(ArticleContent.articleItems)
    }
}
