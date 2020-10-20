package kernycnhyi.vlad.kotlinfrags.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent
import kernycnhyi.vlad.kotlinfrags.model.BaseArticleModel
import kotlinx.android.synthetic.main.list_item_main.view.*
import kotlinx.android.synthetic.main.list_item_secondary.view.*

class ArticleRecyclerAdapter(var onClick:(model:BaseArticleModel)->Unit = {} ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var articleList: List<BaseArticleModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ArticleContent.VIEWTYPE_MAIN -> {
                ViewHolderOne(layoutInflater.inflate(R.layout.list_item_main, parent, false))
            }
            else -> {
                ViewHolderTwo(layoutInflater.inflate(R.layout.list_item_secondary, parent, false))
            }
        }
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (articleList[position].type) {
            ArticleContent.VIEWTYPE_MAIN -> {
                val articleElement = articleList[position] as ArticleContent.Article
                (holder as ViewHolderOne).apply {
                    itemMainHeaderText.text = articleElement.header
                    itemMainDescText.text = articleElement.description
                    itemMainImageView.setImageResource(articleElement.image)
                    itemView.setOnClickListener {
                        onClick.invoke(articleElement)
                    }
                }
            }
            ArticleContent.VIEWTYPE_SECONDARY -> {
                val issueElement = articleList[position] as ArticleContent.Issue
                (holder as ViewHolderTwo).apply {
                    itemSecHeaderText.text = issueElement.header
                    itemSecDescText.text = issueElement.description
                    itemSecImageView.setImageResource(issueElement.image)
                    itemView.setOnClickListener {
                        onClick.invoke(issueElement)
                    }
                }
            }
        }
    }


    override fun getItemViewType(position: Int): Int =
        when (articleList[position].type) {
            ArticleContent.VIEWTYPE_MAIN -> ArticleContent.VIEWTYPE_MAIN
            else -> ArticleContent.VIEWTYPE_SECONDARY
        }

    fun newList(list: List<BaseArticleModel>) {
        articleList = list
        this.notifyDataSetChanged()
    }

    inner class ViewHolderOne(view: View) : RecyclerView.ViewHolder(view) {
        val itemMainHeaderText: TextView = view.itemMainHeaderTextView
        val itemMainDescText: TextView = view.itemMainDescTextView
        val itemMainImageView: ImageView = view.itemMainImageView
    }

    inner class ViewHolderTwo(view: View) : RecyclerView.ViewHolder(view) {
        val itemSecHeaderText: TextView = view.itemSecHeaderTextView
        val itemSecDescText: TextView = view.itemSecDescTextView
        val itemSecImageView: ImageView = view.itemSecImageView
    }
}