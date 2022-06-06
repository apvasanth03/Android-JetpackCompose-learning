package com.vasanth.jetpackcomposelearning.ui.features

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vasanth.jetpackcomposelearning.R
import com.vasanth.jetpackcomposelearning.ui.common.theme.JetpackComposeLearningTheme
import com.vasanth.jetpackcomposelearning.ui.features.basics.ComposeBasicsActivity

class MainActivity : AppCompatActivity() {

    // region Activity Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                MainScreen()
            }
        }
    }
    // endregion

    // region MainScreen
    @Composable
    fun MainScreen() {
        Surface {
            Column {
                TopBar()
                Catalogue()
            }
        }

    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun MainScreenPreview() {
        JetpackComposeLearningTheme {
            MainScreen()
        }
    }
    // end MainScreen

    // region TopBar
    @Composable
    fun TopBar() {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) }
        )
    }
    // endregion

    // region Catalogue
    @Composable
    fun Catalogue() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // 1. Compose Basic
            Button(
                onClick = { navigateToComposeBasicScreen() },
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.compose_basic))
            }
        }
    }
    // endregion

    // region HelperMethods
    private fun navigateToComposeBasicScreen() {
        val intent = ComposeBasicsActivity.getIntent(this)
        startActivity(intent)
    }
    // endregion
}
