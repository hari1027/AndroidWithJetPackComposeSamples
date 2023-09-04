package com.example.car

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car.ui.theme.CarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(TopCenter),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Car()
                }
            }
        }
    }
}

@Composable
fun Car(){
    var listNumber by remember { mutableStateOf(1) }

    when (listNumber){
        1 -> { CarGallery(carname = "Benz" ,carfounder = "Carl Benz" , image=R.drawable.benzcarimg  )}
        2 -> { CarGallery(carname = "BMW" ,carfounder = "Karl Rapp" , image=R.drawable.bmwcarimg  )}
        3 -> { CarGallery(carname = "Kia" ,carfounder = "Song Ho-sung" , image=R.drawable.kiacarimg  )}
        4 -> { CarGallery(carname = "Scorpio" ,carfounder = " Arun Juara" , image=R.drawable.scorpiocarimg  )}
    }

    Box() {
        Column(
            modifier = Modifier
                .align(BottomStart)
                .padding(top = 700.dp)
        ) {

            Row() {
                Button(
                    onClick = {
                        if (listNumber >= 2) {
                            listNumber--
                        }
                    }) {
                    Text(
                        text = "Previous",
                    )
                }

                Spacer(modifier = Modifier.width(200.dp))

                Button(
                    onClick = {
                        if (listNumber <= 3) {
                            listNumber++
                        }
                    }) {
                    Text(
                        text = "Next",
                    )
                }
            }
        }
    }
}

@Composable
private fun CarGallery(
    carname: String,
    carfounder: String,
    @DrawableRes image : Int,
    modifier: Modifier = Modifier) {
    Box(modifier = modifier){

        Column(modifier = Modifier.padding(top=200.dp) ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp)
                    .align(alignment = CenterHorizontally)
            )
        }

        Column(modifier = Modifier
            .padding(top = 500.dp)
            .align(TopCenter)){
            Row(){
                Text(
                    text = "CarName:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
                Text(
                    text = carname,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }

            Row(){
                Text(
                    text = "CarFounder:" ,
                    fontWeight = FontWeight.Bold ,
                    fontSize = 24.sp,
                )
                Text(
                    text = carfounder,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarTheme {
        Car()
    }
}