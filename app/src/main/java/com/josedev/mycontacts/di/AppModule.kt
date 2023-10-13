package com.josedev.mycontacts.di

import android.content.Context
import androidx.room.Room
import com.josedev.mycontacts.data.ContactDatabase
import com.josedev.mycontacts.domain.repository.ContactDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context): ContactDatabase{
        return Room.databaseBuilder(
            app,
            ContactDatabase::class.java,
            "contacts.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideContactDao(contactDatabase: ContactDatabase): ContactDao{
        return contactDatabase.dao
    }
}