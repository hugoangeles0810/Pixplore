package io.github.hugoangeles0810.pixplore.domain.tracking


interface TrackingManager {

    fun send(event: String, params: Map<String, Any>)
}