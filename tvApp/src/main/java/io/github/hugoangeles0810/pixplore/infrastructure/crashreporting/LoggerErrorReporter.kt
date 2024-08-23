package io.github.hugoangeles0810.pixplore.infrastructure.crashreporting

import android.util.Log
import io.github.hugoangeles0810.pixplore.domain.crashreporting.ErrorReporter
import javax.inject.Inject

class LoggerErrorReporter @Inject constructor() : ErrorReporter {

    private val TAG = "LoggerCrashReporter"

    override fun report(throwable: Throwable, metadata: Map<String, Any>, handled: Boolean) {
        Log.e(TAG, "An error happen --->", throwable)
        Log.e(TAG, "metadata: $metadata", )
    }
}