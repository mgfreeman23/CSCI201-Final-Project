package com.cs201.myapp;

/*
this class should be used for all logic, non-UI related code
functions in this class will be called by UI elements in MainActivity.kt
 */
class Functionality {
    private lateinit var dataModel: AppDataModel
    /*
    This function will be called when the app is first opened
    Anything that needs to start when the app is opened, such as any parallel threads, should be done here
     */
    fun init(dataModel: AppDataModel) {

    }

    fun saveProfile(
        name: String,
        age: Int,
        major: String,
        hometown: String,
        hobbies: List<String>,
        socialMedia: String
    ) {
        dataModel.addUserProfile(name,age,major,hometown,hobbies,socialMedia)
        // add server communication here later!!

    }

    /*
    This function will be called when the app is closed
    Anything that needs to be closed when the app is closed, such as any parallel threads, should be done here
     */
    fun close() {

    }
}
