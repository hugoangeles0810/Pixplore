package io.github.hugoangeles0810.pixplore.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hugoangeles0810.pixplore.domain.manager.LocalTrackingManager
import io.github.hugoangeles0810.pixplore.domain.manager.TrackingManager

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {

    @Binds
    abstract fun providesTrackingManager(local: LocalTrackingManager): TrackingManager
}