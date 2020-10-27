package kernycnhyi.vlad.kotlinfrags.loaders

import android.content.Context
import androidx.loader.content.AsyncTaskLoader

class ProgressLoader(context: Context) : AsyncTaskLoader<Int>(context) {

    override fun loadInBackground(): Int? {
        for (progress in 0 until 101) {
            Thread.sleep(SLEEP_TIME)
            deliverResult(progress)
        }
        return 0
    }

    override fun onStartLoading() {
        super.onStartLoading()
        forceLoad()
    }

    companion object {
        const val SLEEP_TIME: Long = 1000
    }
}