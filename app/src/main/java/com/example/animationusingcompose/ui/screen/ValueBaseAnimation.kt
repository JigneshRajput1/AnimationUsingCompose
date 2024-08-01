package com.example.animationusingcompose.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationusingcompose.R

@Composable
fun ValueBaseAnimation() {
    AnimateAsFloatContent()
}

@Composable
private fun AnimateAsFloatContent() {
    var isRotated by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360F else 0f,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    Column {
        Text(
            text = "Value Based Animation",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.W600,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 15.dp)
        )
        Divider(
            modifier = Modifier.padding(top = 15.dp),
            thickness = 2.dp,
            color = Color.Black
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fan),
                contentDescription = "fan",
                modifier = Modifier
                    .rotate(rotationAngle)
                    .size(150.dp)
            )
            Button(
                onClick = { isRotated = !isRotated },
                modifier = Modifier
                    .padding(top = 50.dp)
                    .width(200.dp)
            ) {
                Text(text = "Rotate Fan")
            }
        }
    }
}

@Preview(name = "ValueBaseAnimation")
@Composable
private fun PreviewValueBaseAnimation() {
    ValueBaseAnimation()
}