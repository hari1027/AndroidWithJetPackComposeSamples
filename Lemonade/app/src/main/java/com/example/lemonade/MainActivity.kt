package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade( modifier: Modifier = Modifier) {

    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    when(currentStep) {
       1-> {
         Column(
             modifier = modifier,
             horizontalAlignment = Alignment.CenterHorizontally
         )
         {
             Image(
                 painter = painterResource(R.drawable.lemon_tree),
                 contentDescription = null,
                 modifier = Modifier
                     .clickable {
                         currentStep = 2
                         squeezeCount = (2..4).random()
                     }
             )

             Spacer(modifier = Modifier.height(16.dp))

             Text(
                 text = stringResource(R.string.lemonTree),
                 fontSize = 18.sp
             )
         }
       }

        2->{
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            squeezeCount--
                            if(squeezeCount == 0)
                            currentStep = 3
                        }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.lemon_sqeeze),
                    fontSize = 18.sp
                )
            }
        }
        3->{
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Image(
                    painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                                currentStep = 4
                        }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.lemonade),
                    fontSize = 18.sp
                )
            }
        }
        4->{
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Image(
                    painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            currentStep = 1
                        }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.emptyGlass),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Lemonade()
    }
}