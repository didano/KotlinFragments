package kernycnhyi.vlad.kotlinfrags.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.DialogFragment
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.model.ArticleContent
import kotlinx.android.synthetic.main.dialog_one_layout.*

class DialogOne private constructor(
    private var listener: AdapterView.OnItemClickListener?,
    private var title: String,
    private var description: String
) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_one_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener { listener }
        mainDialogDescTextView.text = description
        mainDialogHeadTextView.text = title
    }

    companion object Builder {
        var listener: AdapterView.OnItemClickListener? = null
        var title: String = ArticleContent.MOCK_HEADER
        var description: String = ArticleContent.MOCK_DESCRIPTION

        fun setOnClickListener(listener: AdapterView.OnItemClickListener?): Builder {
            this.listener = listener
            return this
        }

        fun setTitle(titleResource: String): Builder {
            this.title = titleResource
            return this
        }

        fun setDescription(descResource: String): Builder {
            this.description = descResource
            return this
        }

        fun build(): DialogOne = DialogOne(listener, title, description)

    }
}