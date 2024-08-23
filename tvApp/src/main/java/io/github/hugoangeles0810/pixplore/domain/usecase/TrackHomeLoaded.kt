package io.github.hugoangeles0810.pixplore.domain.usecase

import io.github.hugoangeles0810.pixplore.domain.tracking.TrackingManager
import javax.inject.Inject

private const val EVENT = "screen_loaded"
private const val PARAM = "screen"
private const val HOME = "home"

class TrackHomeLoaded @Inject constructor(
    private val trackingManager: TrackingManager
) {

    operator fun invoke() {
        trackingManager.send(
            event = EVENT,
            params = mapOf(PARAM to HOME)
        )
    }
}