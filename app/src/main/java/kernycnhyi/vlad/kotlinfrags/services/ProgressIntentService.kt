package kernycnhyi.vlad.kotlinfrags.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class ProgressIntentService : IntentService("ProgressIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        for (progress in 0 until 101) {
            Thread.sleep(100)
            sendBroadcast(
                Intent(INTENT_SERVICE_ACTION).putExtra(
                    KEY_INTSERVICE_PROGRESS_VALUE,
                    progress
                )
            )
        }
        Log.d("MyIntentService", "Stopped")
        stopSelf()
    }

    companion object {
        const val INTENT_SERVICE_ACTION =
            "kernycnhyi.vlad.kotlinfrags.fragments.BROADCAST_PROGRESS_INTENTSERVICE"
        const val KEY_INTSERVICE_PROGRESS_VALUE = "progressIntentValue"
    }
}
