package kernycnhyi.vlad.kotlinfrags.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent
import kernycnhyi.vlad.kotlinfrags.utils.toastDialogText
import kotlinx.android.synthetic.main.dialog_one_layout.*

class DialogOne private constructor() : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_one_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            mainDialogHeadTextView.apply {
                text = it.getString(DIALOG_TITLE_KEY)
                setOnClickListener {
                    context.toastDialogText(text.toString())
                }
            }
            mainDialogDescTextView.apply {
                text = it.getString(DIALOG_DESCRIPTION_KEY)
                setOnClickListener {
                    context.toastDialogText(text.toString())
                }
            }
        }
    }

    companion object Builder {
        const val DIALOG_TITLE_KEY = "dialogTitle"
        const val DIALOG_DESCRIPTION_KEY = "dialogDesc"
        var title: String = ArticleContent.MOCK_HEADER
        var description: String = ArticleContent.MOCK_DESCRIPTION

        private fun onNewInstance(
            title: String,
            description: String
        ): DialogOne = DialogOne().apply {
            arguments = Bundle().apply {
                putString(DIALOG_TITLE_KEY, title)
                putString(DIALOG_DESCRIPTION_KEY, description)
            }
        }

        fun setTitle(titleResource: String): Builder {
            this.title = titleResource
            return this
        }

        fun setDescription(descResource: String): Builder {
            this.description = descResource
            return this
        }

        fun build(): DialogOne = onNewInstance(title, description)

    }
}