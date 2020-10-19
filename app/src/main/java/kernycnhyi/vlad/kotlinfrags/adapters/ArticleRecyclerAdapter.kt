package kernycnhyi.vlad.kotlinfrags.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent
import kotlinx.android.synthetic.main.list_item_main.view.*
import kotlinx.android.synthetic.main.list_item_secondary.view.*

class ArticleRecyclerAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var articleList: List<Any>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View
        if (viewType == VIEW_TYPE_ONE) {
            view = layoutInflater.inflate(R.layout.list_item_main, parent, false)
            return ViewHolderOne(view)
        }
        view = layoutInflater.inflate(R.layout.list_item_secondary, parent, false)
        return ViewHolderTwo(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (articleList[position] is ArticleContent.Article) {
            val viewHolderOne = holder as ViewHolderOne
            val articleElement = articleList[position]
            articleElement as ArticleContent.Article
            viewHolderOne.apply {
                itemMainHeaderText.text = articleElement.header
                itemMainDescText.text = articleElement.description
                itemMainImageView.setImageResource(articleElement.image)
            }
        } else {
            val issueElement = articleList[position]
            issueElement as ArticleContent.Issue
            val viewHolderTwo = holder as ViewHolderTwo
            viewHolderTwo.apply {
                itemSecHeaderText.text = issueElement.header
                itemSecDescText.text = issueElement.description
                itemSecImageView.setImageResource(issueElement.image)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (articleList[position] is ArticleContent.Article) {
            return VIEW_TYPE_ONE
        }
        return VIEW_TYPE_TWO
    }

    fun refreshAdapter(list: List<Any>): ArticleRecyclerAdapter {
        articleList = list
        this.notifyDataSetChanged()
        return this
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

    companion object {
        const val VIEW_TYPE_ONE = 0
        const val VIEW_TYPE_TWO = 1
    }
}