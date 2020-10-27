package kernycnhyi.vlad.kotlinfrags.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class ProgressService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread() {
            for (progress in 0 until 101) {
                Thread.sleep(100)
                sendBroadcast(
                    Intent(SIMPLE_SERVICE_ACTION).putExtra(
                        KEY_PROGRESS_VALUE,
                        progress
                    )
                )
            }
            stopSelf()
        }.start()
        return START_NOT_STICKY
    }

    companion object {
        const val SIMPLE_SERVICE_ACTION = "kernycnhyi.vlad.kotlinfrags.fragments.BROADCAST_PROGRESS"
        const val KEY_PROGRESS_VALUE = "progressValue"
    }
}
