package kernycnhyi.vlad.kotlinfrags.views

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kernycnhyi.vlad.kotlinfrags.R
import kotlinx.android.synthetic.main.custom_layout.view.*

class MyCustomView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        val typedArrayList = getContext().obtainStyledAttributes(
            attrs, R.styleable.MyCustomView,
            0, 0
        )
        val progressBarColor = typedArrayList.getColor(
            R.styleable.MyCustomView_mcv_progress_bar_color,
            0xff000000.toInt()
        )
        val title = typedArrayList.getString(R.styleable.MyCustomView_mcv_title)
        val li = getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        li.inflate(R.layout.custom_layout, this, true) as LinearLayout

        titleTextView.text = title
        customProgressBar.indeterminateTintList = ColorStateList.valueOf(progressBarColor)
        typedArrayList.recycle()
    }
}