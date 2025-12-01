package com.soham.classplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.soham.classplan.home.ClassPlanApp
import com.soham.classplan.ui.theme.ClassPlanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassPlanTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ClassPlanApp()
                }
            }
        }
    }
}
