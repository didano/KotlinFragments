package kernycnhyi.vlad.kotlinfrags.model

import kernycnhyi.vlad.kotlinfrags.R

object ArticleContent {

    const val VIEWTYPE_MAIN = 10
    const val VIEWTYPE_SECONDARY = 11
    val articleItems = mutableListOf<BaseArticleModel>()

    init {
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo, VIEWTYPE_MAIN))
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo,
                VIEWTYPE_SECONDARY
            )
        )
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo,
                VIEWTYPE_SECONDARY
            )
        )
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo,VIEWTYPE_MAIN))
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo,
                VIEWTYPE_SECONDARY
            )
        )
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo,
                VIEWTYPE_SECONDARY
            )
        )
        addItem(Article("Main Header", "Main Description", R.drawable.main_news_logo,VIEWTYPE_MAIN))
        addItem(
            Issue(
                "Secondary Header",
                "Secondary Description",
                R.drawable.secondary_news_logo,
                VIEWTYPE_SECONDARY
            )
        )
    }

    private fun addItem(article: BaseArticleModel) {
        articleItems.add(article)
    }

    data class Article(
        val header: String,
        val description: String,
        val image: Int,
        override val type: Int
    ) : BaseArticleModel(type)

    data class Issue(
        val header: String,
        val description: String,
        val image: Int,
        override val type: Int
    ) : BaseArticleModel(type)

}