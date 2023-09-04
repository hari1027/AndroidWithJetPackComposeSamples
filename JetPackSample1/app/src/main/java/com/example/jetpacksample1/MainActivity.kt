package com.example.jetpacksample1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacksample1.ui.theme.JetPackSample1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackSample1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingTexts()
                }
            }
        }
    }
}

@Composable
fun GreetingTexts() {
    ArticleCard(
        title = stringResource(R.string.jetpack_compose_tutorial_heading),
        shortDescription = stringResource(R.string.jetpack_compose_tutorial1_text1),
        longDescription = stringResource(R.string.jetpack_compose_tutorial1_text2),
        imagePainter = painterResource(R.drawable.jetpack_compose_tutorial1_pic)
    )
}

@Composable
    private fun ArticleCard(
        title: String,
        shortDescription: String,
        longDescription: String,
        imagePainter: Painter,
        modifier: Modifier = Modifier,
    )
{
    Column(modifier = modifier, verticalArrangement = Arrangement.Center){
        Image(
            painter = imagePainter,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackSample1Theme {
        GreetingTexts()
    }
}