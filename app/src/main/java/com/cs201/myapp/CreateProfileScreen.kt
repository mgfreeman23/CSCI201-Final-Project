package com.cs201.myapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateProfileScreen(
    functionality: Functionality,
    dataModel: AppDataModel,
) {
    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val major = remember { mutableStateOf("") }
    val hometown = remember { mutableStateOf("") }
    val socialMedia = remember { mutableStateOf("") }
    val hobbies = remember { mutableStateOf(listOf<String>()) } // Multi-select list for hobbies
    // list of hobby options, add more to later
    val availableHobbies = listOf("Art", "Basketball", "Baseball", "Cooking", "Dancing",
        "Football", "Video Gaming", "Hiking", "Running", "Swimming", "Baking")

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Create Your Profile", style = MaterialTheme.typography.titleLarge)

            // User input fields
            // name input
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Name") }
            )
            // age input
            OutlinedTextField(
                value = age.value,
                onValueChange = { age.value = it },
                label = { Text("Age") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // major input
            OutlinedTextField(
                value = major.value,
                onValueChange = { major.value = it },
                label = { Text("Major") }
            )
            // hometown input
            OutlinedTextField(
                value = hometown.value,
                onValueChange = { hometown.value = it },
                label = { Text("Hometown") }
            )
            // social media input
            OutlinedTextField(
                value = socialMedia.value,
                onValueChange = { socialMedia.value = it },
                label = { Text("Social Media") }
            )
            // Hobby selection input
            Text(text = "Select Hobbies")
            LazyColumn {
                items(availableHobbies.size) { index ->
                    val hobby = availableHobbies[index]
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Checkbox(
                            checked = hobbies.value.contains(hobby),
                            onCheckedChange = { isChecked ->
                                hobbies.value = if (isChecked) {
                                    hobbies.value + hobby
                                } else {
                                    hobbies.value - hobby
                                }
                            }
                        )
                        Text(text = hobby, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }

            // Button to save user data
            Button(onClick = {
                // convert string to an int for age
                val parsedAge = age.value.toIntOrNull()
                // Save all inputs to the AppDataModel or pass them to a server
                if (parsedAge != null) {
                    // call function in functionality file with user data as parameters
                    functionality.saveProfile(
                        name = name.value,
                        age = parsedAge,
                        major = major.value,
                        hometown = hometown.value,
                        hobbies = hobbies.value,
                        socialMedia = socialMedia.value
                    )
                    //onSave()
                }
                else {
                    // no integer age given, so just set a default age
                    functionality.saveProfile(
                        name = name.value,
                        age = 18,
                        major = major.value,
                        hometown = hometown.value,
                        hobbies = hobbies.value,
                        socialMedia = socialMedia.value
                    )
                    //onSave()
                }

            }) {
                Text(text = "Save")
            }
        }
    }
}



