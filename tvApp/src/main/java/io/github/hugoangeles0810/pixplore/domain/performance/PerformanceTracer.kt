package io.github.hugoangeles0810.pixplore.domain.performance

interface PerformanceTracer {
    fun  newTrace(name: String): Trace
}

interface Trace {
    fun start()

    fun putAttribute(name: String, value: String)

    fun stop()
}