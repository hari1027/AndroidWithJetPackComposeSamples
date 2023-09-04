package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier ) {
    Box(modifier = Modifier, Alignment.TopCenter) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(top = 50.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.androidlogo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F
            )
            Text(
                text = "Hari Haran",
                fontSize = 36.sp,
                color = Color(0xffff0000),
                modifier = modifier.padding(top = 10.dp)
            )
            Text(
                text = "Android Developer",
                fontSize = 16.sp,
                color = Color(0xFF3ddc84)
            )
        }
    }

    Box(modifier = Modifier, Alignment.Center){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ){
            Text(
                text = "We made the world uninhabitable for ourselves and it can only be inhabited by robots and androids...",
                fontSize = 20.sp,
                color = Color(0xFFA0522D),
                modifier = modifier.padding(bottom = 250.dp, start = 50.dp, end = 50.dp)
            )
        }
    }

    Box(modifier = Modifier, Alignment.Center){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(top = 100.dp)
        ){
            Image(
                painter = painterResource(R.drawable.androidproducts),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F
            )
        }
    }

    Box(modifier = modifier.padding(bottom = 50.dp), Alignment.BottomCenter) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            Row{
                Text(
                    text = "Mobile No:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "+91 7358571391",
                    fontSize = 16.sp,
                )
            }
            Row{
                Text(
                    text = "Email:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "hari04harry@gmail.com",
                    fontSize = 16.sp,
                )
            }
            Row{
                Text(
                    text = "Location:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Chennai",
                    fontSize = 16.sp,
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}