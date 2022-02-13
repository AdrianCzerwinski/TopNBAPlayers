package com.adrianczerwinski.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adrianczerwinski.borutoapp.navigation.SetupNavGraph
import com.adrianczerwinski.borutoapp.ui.theme.BorutoAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
         
            }
        }
    }
}