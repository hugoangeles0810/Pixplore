package io.github.hugoangeles0810.pixplore.infrastructure.performance

import android.util.Log
import io.github.hugoangeles0810.pixplore.domain.performance.PerformanceTracer
import io.github.hugoangeles0810.pixplore.domain.performance.Trace
import javax.inject.Inject

private const val TAG = "PerformanceTracer"

class LocalPerformanceTracer @Inject constructor() : PerformanceTracer {

    override fun newTrace(name: String): Trace {
        return LocalTrace(name)
    }
}

class LocalTrace(
    private val name: String
) : Trace {

    private val attributes = mutableMapOf<String, String>()
    private var startTimestamp: Long = 0L

    override fun start() {
        startTimestamp = System.nanoTime()
    }

    override fun putAttribute(name: String, value: String) {
        attributes[name] = value
    }

    override fun stop() {
        val duration = System.nanoTime() - startTimestamp

        Log.d(TAG, "Sending performance trace ---->")
        Log.d(TAG, "Event: $name")
        Log.d(TAG, "Duration: $duration nanoseconds")
        Log.d(TAG, "Attributes: $attributes")

    }
}