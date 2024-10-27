package com.cs201.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cs201.myapp.ui.theme.MyAppTheme


/*
This file will contain all the UI elements for each page of the app,
and will call the relevant functions in Functionality.kt
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val functionality = Functionality()
            val dataModel = AppDataModel()
            functionality.init(dataModel)
            val navController = rememberNavController()
            MyAppTheme {
                NavHost(navController = navController, startDestination = "home") {
                    // add other pages here
                    composable("home") {
                        HomeScreen(functionality, dataModel)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(functionality: Functionality, dataModel: AppDataModel) {
    Scaffold(){
        Text(
            text = "Home Screen",
            modifier = Modifier.padding(it)
        )
    }
}