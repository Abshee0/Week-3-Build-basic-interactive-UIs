package com.example.lemonade

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
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.clickable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                LemonStep(
                    text = stringResource(R.string.lemon_select),
                    imageResId = R.drawable.lemon_tree,
                    contentDescription = stringResource(R.string.lemon_tree_content_description),
                    onClick = { currentStep = 2 }
                )
            }
            2 -> {
                LemonStep(
                    text = stringResource(R.string.lemon_squeeze),
                    imageResId = R.drawable.lemon_squeeze,
                    contentDescription = stringResource(R.string.lemon_content_description),
                    onClick = { currentStep = 3 }
                )
            }
            3 -> {
                LemonStep(
                    text = stringResource(R.string.lemon_drink),
                    imageResId = R.drawable.lemon_drink,
                    contentDescription = stringResource(R.string.lemon_drink_content_description),
                    onClick = { currentStep = 4 }
                )
            }
            4 -> {
                LemonStep(
                    text = stringResource(R.string.lemon_restart),
                    imageResId = R.drawable.lemon_restart,
                    contentDescription = stringResource(R.string.lemon_restart_content_description),
                    onClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun LemonStep(
    text: String,
    imageResId: Int,
    contentDescription: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(imageResId),
            contentDescription = contentDescription,
            modifier = Modifier
                .wrapContentSize()
                .clickable { onClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
