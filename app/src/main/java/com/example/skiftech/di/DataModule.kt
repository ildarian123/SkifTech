package com.example.skiftech.di

import android.app.Application
import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.skiftech.BuildConfig
import com.example.skiftech.data.base.DataBase
import com.example.skiftech.data.network.NetworkApi
import com.example.skiftech.data.repositorys.DataBaseRepositoryImpl
import com.example.skiftech.data.repositorys.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.Nullable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {


    var BASE_URL = "https://randomuser.me/"

    @Provides
    @Singleton
    fun provideUserRepository(networkApi: NetworkApi): UserRepositoryImpl {
        return UserRepositoryImpl(networkApi)
    }

    @Provides
    @Singleton
    fun provideDataBaseRepository(db: DataBase): DataBaseRepositoryImpl {
        return DataBaseRepositoryImpl(db.userDao()!!)
    }

    private var db: DataBase? = null

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context : Context): DataBase {
        if (db == null) {
            db = databaseBuilder(
                context,
                DataBase::class.java, "user_data_base"
            )
                .allowMainThreadQueries()
                .build()
        }
        return db!!
    }

    @Provides
    @Singleton
    fun provideNetworkApi(client: OkHttpClient): NetworkApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NetworkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .build()
    }
}