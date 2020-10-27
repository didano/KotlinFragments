package kernycnhyi.vlad.kotlinfrags.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kernycnhyi.vlad.kotlinfrags.R
import kernycnhyi.vlad.kotlinfrags.interfaces.NavigationInterface
import kernycnhyi.vlad.kotlinfrags.interfaces.UpdateToolbarTitle
import kernycnhyi.vlad.kotlinfrags.services.ProgressIntentService
import kernycnhyi.vlad.kotlinfrags.services.ProgressService
import kernycnhyi.vlad.kotlinfrags.utils.SimpleTextWatcher
import kernycnhyi.vlad.kotlinfrags.utils.inflateExt
import kotlinx.android.synthetic.main.fragment_first.*

class CustomViewFragment : Fragment() {

    lateinit var progressBroadcastReceiver: BroadcastReceiver

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
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.unregisterReceiver(progressBroadcastReceiver)
    }

    private fun initBroadcastReceiver() {
        progressBroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.action) {
                    ProgressIntentService.INTENT_SERVICE_ACTION ->
                        customCardViewIntentService.setProgress(
                            intent.getIntExtra(
                                "progressIntentValue",
                                0
                            )
                        )
                    ProgressService.SIMPLE_SERVICE_ACTION ->
                        customCardViewService.setProgress(intent.getIntExtra("progressValue", 0))
                }
            }
        }
    }


}
