package com.josedev.mycontacts.domain.repository

import com.josedev.mycontacts.domain.entity.Contact
import com.josedev.mycontacts.domain.entity.SortType

sealed interface ContactEvent{
    /**
     * This wil represent each interacion that the user will have with the  view
     */
    object SaveContact: ContactEvent
    data class SetFirstName(val firstName: String): ContactEvent
    data class SetLastName(val lastName: String): ContactEvent
    data class SetPhoneNumber(val phoneNumber: String): ContactEvent
    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent
    data class SortContacts(val sortType: SortType): ContactEvent
    data class DeleteContact(val contact: Contact): ContactEvent
}