package kernycnhyi.vlad.kotlinfrags.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent

class ArticleRecyclerAdapter(private val articleList: List<ArticleContent.Article>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.list_item_main, parent, false)
            return ViewHolderOne(view)
        }
        view = layoutInflater.inflate(R.layout.list_item_secondary, parent, false)
        return ViewHolderTwo(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (articleList[position].priority) {
            val viewHolderOne = holder as ViewHolderOne
            viewHolderOne.itemMainHeaderText.text = articleList[position].header
            viewHolderOne.itemMainDescText.text = articleList[position].description
            viewHolderOne.itemMainImageView.setImageResource(articleList[position].image)
        } else {
            val viewHolderTwo = holder as ViewHolderTwo
            viewHolderTwo.itemSecHeaderText.text = articleList[position].header
            viewHolderTwo.itemSecDescText.text = articleList[position].description
            viewHolderTwo.itemSecImageView.setImageResource(articleList[position].image)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (articleList[position].priority) {
            return 0
        }
        return 1
    }

    inner class ViewHolderOne(view: View) : RecyclerView.ViewHolder(view) {
        val itemMainHeaderText: TextView = view.findViewById(R.id.itemMainHeaderTextView)
        val itemMainDescText: TextView = view.findViewById(R.id.itemMainDescTextView)
        val itemMainImageView: ImageView = view.findViewById(R.id.itemMainImageView)
    }

    inner class ViewHolderTwo(view: View) : RecyclerView.ViewHolder(view) {
        val itemSecHeaderText: TextView = view.findViewById(R.id.itemSecHeaderTextView)
        val itemSecDescText: TextView = view.findViewById(R.id.itemSecDescTextView)
        val itemSecImageView: ImageView = view.findViewById(R.id.itemSecImageView)
    }
}