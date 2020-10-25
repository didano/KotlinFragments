package kernycnhyi.vlad.kotlinfrags.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun ViewGroup.inflateExt(layoutResource: Int): View =
    LayoutInflater.from(context).inflate(layoutResource, this, false)


fun Context.toastDialogText(str: String?) =
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()

