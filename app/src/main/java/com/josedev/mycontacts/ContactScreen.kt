package com.josedev.mycontacts

import android.text.Layout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.josedev.mycontacts.ui.theme.ContactEvent
import com.josedev.mycontacts.ui.theme.ContactState
import com.josedev.mycontacts.ui.theme.SortType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit
) {
    Scaffold (
        modifier = Modifier.padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(ContactEvent.ShowDialog)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a contact")
            }
        }
    ) {padding ->

        if(state.isAddingContact){
            AddContactDialog(state = state, onEvent = onEvent)
        }

        LazyColumn(
            contentPadding =  padding,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ){
            item {
                Row (
                    modifier = Modifier
                        .fillMaxSize()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    SortType.values().forEach { sortType ->
                        Row (
                            modifier = Modifier
                                .clickable {
                                    onEvent(ContactEvent.SortContacts(sortType))
                                },
                            verticalAlignment = CenterVertically
                        ){
                            RadioButton(
                                selected = state.sortType == sortType,
                                onClick = {
                                    onEvent(ContactEvent.SortContacts(sortType))
                                })
                            
                            Text(text = sortType.name)
                        }
                    }
                }
            }

            items(state.contacts){contact ->
                // TODO  make a new composable from here
                Row(
                    modifier =Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column (
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "${contact.firstName} ${contact.lastName}",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                            )
                        Text(
                            text = "${contact.phoneNumber}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light)
                    }

                    IconButton(onClick = { onEvent(ContactEvent.DeleteContact(contact))}) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete contact"
                        )
                    }

                }
            }
        }
    }
}