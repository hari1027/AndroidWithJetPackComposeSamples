package com.example.jetpacksample2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacksample2.ui.theme.JetpackSample2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackSample2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
   SuccessTaskNotification(
       message = stringResource(R.string.jetpack_compose_tutorial2_text1),
       description = stringResource(R.string.jetpack_compose_tutorial2_text2),
       imagePainter = painterResource(R.drawable.jetpack_compose_tutorial2_pic)
   )
}

@Composable
    private fun SuccessTaskNotification(
    message:String,
    description:String,
    imagePainter : Painter,
    modifier: Modifier = Modifier,
    ){
Column(modifier = modifier, verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){
    Image(
        painter = imagePainter,
        contentDescription = null
    )
    Text(
        text = message,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.
        padding(top = 16.dp , bottom = 8.dp)
    )
    Text(
        text = description,
        fontSize = 16.sp ,
        modifier = modifier
    )
}
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackSample2Theme {
        Greeting()
    }
}