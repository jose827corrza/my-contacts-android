package com.josedev.mycontacts.ui.theme

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Contact::class],
    version = 1
    //Check about migrations
)
abstract class ContactDatabase: RoomDatabase() {

    abstract val dao: ContactDao
}