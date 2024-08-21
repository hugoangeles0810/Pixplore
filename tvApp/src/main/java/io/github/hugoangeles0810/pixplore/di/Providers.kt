package io.github.hugoangeles0810.pixplore.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.hugoangeles0810.pixplore.BuildConfig
import io.github.hugoangeles0810.pixplore.data.UnplashApiService
import io.github.hugoangeles0810.pixplore.data.interceptors.UnsplashAuthorizationInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvidersModule {

    @Provides
    fun providesApplication(@ApplicationContext appContext: Context): Application {
        return appContext.applicationContext as Application
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(authorizationInterceptor: UnsplashAuthorizationInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(authorizationInterceptor)
            .build()

    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesUnsplashApiService(retrofit: Retrofit): UnplashApiService {
        return retrofit.create(UnplashApiService::class.java)
    }
}