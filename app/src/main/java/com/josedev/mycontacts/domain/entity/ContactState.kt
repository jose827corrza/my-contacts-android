package com.josedev.mycontacts.domain.entity

import com.josedev.mycontacts.domain.entity.Contact
import com.josedev.mycontacts.domain.entity.SortType

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME
)
