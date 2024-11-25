package com.cs201.myapp

import androidx.compose.runtime.mutableStateListOf

/*
this class will contain all the data that the app needs to store
most if not all the data in this class should be stored as MutableState<T>
to allow for autoupdating of the ui when these variables change
*/
class AppDataModel {
    // hold user profile data
    private val userProfiles = mutableStateListOf<UserProfile>()

    constructor() {
        // initialize any data that needs to be initialized
    }
    // adding a new user profile
    fun addUserProfile(
        name: String,
        age: Int,
        major: String,
        hometown: String,
        hobbies: List<String>,
        socialMedia: String
    ) {
        userProfiles.add(UserProfile(name, age, major, hometown, hobbies, socialMedia))
    }
   // user profile class structure
    data class UserProfile(
        val name: String,
        val age: Int,
        val major: String,
        val hometown: String,
        val hobbies: List<String>,
        val socialMedia: String
    )
}