package kernycnhyi.vlad.kotlinfrags.model

import kernycnhyi.vlad.kotlinfrags.R

object ArticleContent {

    val articleItems = mutableListOf<Any>()

    init {
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo))
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo))
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo))
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo
            )
        )
    }

    private fun addItem(article: Any) {
        articleItems.add(article)
    }

    data class Article(
        val header: String,
        val description: String,
        val image: Int
    )

    data class Issue(
        val header: String,
        val description: String,
        val image: Int
    )
}