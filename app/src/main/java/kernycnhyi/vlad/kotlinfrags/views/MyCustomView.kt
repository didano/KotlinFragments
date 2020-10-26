package kernycnhyi.vlad.kotlinfrags.views

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kernycnhyi.vlad.kotlinfrags.R
import kotlinx.android.synthetic.main.custom_layout.view.*

class MyCustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr) {

    private val PROGRESS_VALUE: Int = 50

    private var title: String? = context.getString(R.string.mock_header_text)
        set(value) {
            field = value
            titleTextView.text = value
        }

    private var progressColor: ColorStateList? =
        ColorStateList.valueOf(resources.getColor(R.color.colorBlue))
        set(value) {
            field = value
            customProgressBar.progressTintList = value
        }

    private var progressValue: Int = PROGRESS_VALUE
        set(value) {
            field = value
            customProgressBar.progress = value
        }

    init {
        View.inflate(getContext(), R.layout.custom_layout, this)
        with(
            context.obtainStyledAttributes(
                attributeSet, R.styleable.MyCustomView,
                0, 0
            )
        ) {
            progressValue = this.getInt(R.styleable.MyCustomView_mcv_progress_value, PROGRESS_VALUE)
            progressColor = this.getColorStateList(R.styleable.MyCustomView_mcv_progress_bar_color)
            title = this.getString(R.styleable.MyCustomView_mcv_title)
            recycle()
        }
    }

    fun setProgress(progress: Int) {
        progressValue = progress
    }
}