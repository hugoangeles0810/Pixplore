package io.github.hugoangeles0810.pixplore.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.hugoangeles0810.pixplore.BuildConfig
import io.github.hugoangeles0810.pixplore.infrastructure.UnplashApiService
import io.github.hugoangeles0810.pixplore.infrastructure.interceptors.UnsplashAuthorizationInterceptor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun providesOkHttpClient(
        authorizationInterceptor: UnsplashAuthorizationInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(authorizationInterceptor)
            .addNetworkInterceptor(loggingInterceptor)
            .build()

    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) BODY else NONE
        return logging
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesUnsplashApiService(retrofit: Retrofit): UnplashApiService {
        return retrofit.create(UnplashApiService::class.java)
    }

    @Provides
    @IoDispatcher
    fun providesIoDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}