package io.github.hugoangeles0810.pixplore.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hugoangeles0810.pixplore.domain.crashreporting.ErrorReporter
import io.github.hugoangeles0810.pixplore.domain.performance.PerformanceTracer
import io.github.hugoangeles0810.pixplore.domain.tracking.TrackingManager
import io.github.hugoangeles0810.pixplore.infrastructure.crashreporting.LoggerErrorReporter
import io.github.hugoangeles0810.pixplore.infrastructure.performance.LocalPerformanceTracer
import io.github.hugoangeles0810.pixplore.infrastructure.tracking.LocalTrackingManager

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {

    @Binds
    abstract fun providesTrackingManager(local: LocalTrackingManager): TrackingManager

    @Binds
    abstract fun providesPerformanceTracer(local: LocalPerformanceTracer): PerformanceTracer

    @Binds
    abstract fun providesErrorReporter(logger: LoggerErrorReporter): ErrorReporter
}