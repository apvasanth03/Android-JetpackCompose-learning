package com.vasanth.jetpackcomposelearning.ui.features.state

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.vasanth.jetpackcomposelearning.ui.features.state.composable.WellnessScreen

class StateActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, StateActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                WellnessScreen()
            }
        }
    }
}