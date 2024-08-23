package io.github.hugoangeles0810.pixplore.infrastructure.tracking

import android.util.Log
import io.github.hugoangeles0810.pixplore.domain.tracking.TrackingManager
import javax.inject.Inject

private const val TAG = "TrackingManager"

class LocalTrackingManager @Inject constructor() : TrackingManager {

    override fun send(event: String, params: Map<String, Any>) {
        Log.d(TAG, "Sending tracking --->")
        Log.d(TAG, "event: $event")
        Log.d(TAG, "params: $params")
    }
}