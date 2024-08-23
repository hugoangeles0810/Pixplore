package io.github.hugoangeles0810.pixplore.domain.crashreporting

interface ErrorReporter {

    fun report(
        throwable: Throwable,
        metadata: Map<String, Any> = emptyMap(),
        handled: Boolean = false
    )

}