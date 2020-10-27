package kernycnhyi.vlad.kotlinfrags.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.interfaces.NavigationInterface
import kernycnhyi.vlad.kotlinfrags.interfaces.UpdateToolbarTitle
import kernycnhyi.vlad.kotlinfrags.loaders.ProgressLoader
import kernycnhyi.vlad.kotlinfrags.services.ProgressIntentService
import kernycnhyi.vlad.kotlinfrags.services.ProgressService
import kernycnhyi.vlad.kotlinfrags.utils.SimpleTextWatcher
import kernycnhyi.vlad.kotlinfrags.utils.inflateExt
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CustomViewFragment : Fragment(), LoaderManager.LoaderCallbacks<Int> {

    lateinit var progressBroadcastReceiver: BroadcastReceiver
    lateinit var loader: Loader<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = container?.inflateExt(R.layout.fragment_first)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeTitleEditText.addTextChangedListener(SimpleTextWatcher {
            (activity as? UpdateToolbarTitle)?.updateTitle(it.toString())
        })

        firstBtnNext.setOnClickListener {
            (activity as? NavigationInterface)?.openSecondFragment()
        }

        initBroadcastReceiver()
        val intentFilter = IntentFilter(ProgressService.SIMPLE_SERVICE_ACTION)
        intentFilter.addAction(ProgressIntentService.INTENT_SERVICE_ACTION)
        activity?.registerReceiver(progressBroadcastReceiver, intentFilter)

        activity?.startService(Intent(context, ProgressService::class.java))
        activity?.startService(Intent(context, ProgressIntentService::class.java))

        coroutineSetProgress()
        handlerSetProgress("HandlerThread")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loader = activity!!.supportLoaderManager.initLoader(23, null, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.unregisterReceiver(progressBroadcastReceiver)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Int> {
        Log.d("LoaderFinish", "$id")
        loader = ProgressLoader(context!!)
        return loader
    }

    override fun onLoadFinished(loader: Loader<Int>, data: Int?) {
        Log.d("LoaderFinish", "$data")
        customCardViewLoader.setProgress(data!!)
    }

    override fun onLoaderReset(loader: Loader<Int>) {}

    private fun coroutineSetProgress() {
        CoroutineScope(Default).launch {
            for (progress in 0 until 101) {
                delay(SLEEP_VALUE)
                customCardViewCouroutines.setProgress(progress)
            }
        }
    }

    fun handlerSetProgress(handlerName: String) {
        val handlerThread = HandlerThread(handlerName)
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        handler.post {
            for (progress in 0 until 101) {
                Thread.sleep(SLEEP_VALUE)
                customCardView.setProgress(progress)
            }
            handlerThread.quit()
        }
    }

    private fun initBroadcastReceiver() {
        progressBroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.action) {
                    ProgressIntentService.INTENT_SERVICE_ACTION ->
                        customCardViewIntentService.setProgress(
                            intent.getIntExtra(
                                "progressIntentValue",
                                DEFAULT_INT_VALUE
                            )
                        )
                    ProgressService.SIMPLE_SERVICE_ACTION ->
                        customCardViewService.setProgress(
                            intent.getIntExtra(
                                "progressValue",
                                DEFAULT_INT_VALUE
                            )
                        )
                }
            }
        }
    }

    companion object {
        const val DEFAULT_INT_VALUE = 0
        const val SLEEP_VALUE: Long = 1000
    }


}
