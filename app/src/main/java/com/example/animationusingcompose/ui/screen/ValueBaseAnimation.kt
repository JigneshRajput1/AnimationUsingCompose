package com.example.animationusingcompose.ui.screen

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    //for one time animation
    var isRotated by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360F else 0F,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    //for infinite animation
    var isContinueRotating by rememberSaveable { mutableStateOf(false) }
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val continueRotationAngle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )
    // Decide which rotation value to use
    val rotation = if (isContinueRotating) continueRotationAngle else rotationAngle

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
                    .rotate(rotation)
                    .size(150.dp)
            )
            Button(
                onClick = {
                    isRotated = !isRotated
                    isContinueRotating = false
                },
                modifier = Modifier
                    .padding(top = 50.dp)
                    .width(200.dp)
            ) {
                Text(text = "Rotate Fan")
            }
            Row(
                modifier = Modifier.padding(20.dp)
            ) {
                Button(
                    onClick = { isContinueRotating = false },
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                ) {
                    Text(text = "Stop")
                }
                Button(
                    onClick = { isContinueRotating = true },
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f)
                ) {
                    Text(text = "Start")
                }
            }
        }
    }
}

@Preview(name = "ValueBaseAnimation")
@Composable
private fun PreviewValueBaseAnimation() {
    ValueBaseAnimation()
}