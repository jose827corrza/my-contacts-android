package com.josedev.mycontacts.ui.theme

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    //Insert annotation can create a problem, but can be change the strategy, instead aborting  we can select to do nothing
    //Or, we can use @Upsert, which is a mix of Insert and Update
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts ORDER BY firstName ASC")
    suspend fun getContactsOrderedByFirstName(): Flow<List<Contact>>
    //We use flows because it can be useful to emit  and notify us when a change has been made

    @Query("SELECT * FROM contacts ORDER BY lastName ASC")
    suspend fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY phoneNumber ASC")
    suspend fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}