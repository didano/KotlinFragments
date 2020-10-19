package kernycnhyi.vlad.kotlinfrags.model

import kernycnhyi.vlad.kotlinfrags.R

object ArticleContent {

    val articleItems = mutableListOf<Article>()

    init {
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo, true))
        addItem(
            Article(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(
            Article(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo, true))
        addItem(
            Article(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(
            Article(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo, true))
        addItem(
            Article(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
    }

    private fun addItem(article: Article) {
        articleItems.add(article)
    }

    data class Article(
        val header: String,
        val description: String,
        val image: Int,
        val priority: Boolean = false
    )
}