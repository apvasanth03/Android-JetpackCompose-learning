package com.vasanth.jetpackcomposelearning.ui.features.basics

import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vasanth.jetpackcomposelearning.R
import com.vasanth.jetpackcomposelearning.ui.common.theme.JetpackComposeLearningTheme

// region Activity Methods.
class ComposeBasicsActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, ComposeBasicsActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLearningTheme {
                ComposeBasicsScreen()
            }
        }
    }
}
// endregion

// region ComposeBasicsScreen
@Composable
fun ComposeBasicsScreen() {
    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

    Column {
        TopBar()
        if (shouldShowOnBoarding) {
            OnBoardingScreen(
                onContinueClicked = {
                    shouldShowOnBoarding = false
                }
            )
        } else {
            Greetings()
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun ComposeBasicsScreenPreview() {
    JetpackComposeLearningTheme {
        ComposeBasicsScreen()
    }
}

// endregion

// region TopBar
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.compose_basic)) }
    )
}
// endregion

// region OnBoarding
@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() {
    JetpackComposeLearningTheme {
        OnBoardingScreen(
            onContinueClicked = {}
        )
    }
}
//endregion

// region Greetings
@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        items(names) {
            Greeting(name = it)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )

    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
            IconButton(
                onClick = { expanded = !expanded }
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(id = R.string.show_less)
                    } else {
                        stringResource(id = R.string.show_more)
                    }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "GreetingsPreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
    JetpackComposeLearningTheme {
        Greetings()
    }
}
// endregion