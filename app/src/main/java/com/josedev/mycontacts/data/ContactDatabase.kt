package com.josedev.mycontacts.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.josedev.mycontacts.domain.entity.Contact
import com.josedev.mycontacts.domain.repository.ContactDao

@Database(
    entities = [Contact::class],
    version = 1
    //Check about migrations
)
abstract class ContactDatabase: RoomDatabase() {

    abstract val dao: ContactDao
}