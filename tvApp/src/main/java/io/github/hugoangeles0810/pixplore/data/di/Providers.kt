package io.github.hugoangeles0810.pixplore.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hugoangeles0810.pixplore.data.datasource.PhotoDatasource
import io.github.hugoangeles0810.pixplore.data.datasource.RemotePhotoDatasource

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {

    @Binds
    abstract fun providesPhotoDatasource(remote: RemotePhotoDatasource): PhotoDatasource
}