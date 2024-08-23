package io.github.hugoangeles0810.pixplore.domain.manager

import android.util.Log
import javax.inject.Inject

private const val TAG = "TrackingManager"

interface TrackingManager {

    fun send(event: String, params: Map<String, Any>)
}

class LocalTrackingManager @Inject constructor() : TrackingManager {

    override fun send(event: String, params: Map<String, Any>) {
        Log.d(TAG, "Sending tracking --->")
        Log.d(TAG, "event: $event")
        Log.d(TAG, "params: $params")
    }
}