package com.example.animationusingcompose.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun ContentAnimation() {
    ContentAnim()
}

@Composable
fun ContentAnim() {
    var isStart by remember { mutableStateOf(true) }
    Column {
        Text(
            text = "Content Change Animation",
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedContent(
                targetState = isStart,
                transitionSpec = {
                    if (targetState) {
                        (scaleIn() + fadeIn()).togetherWith(
                            scaleOut() + fadeOut()
                        )
                        //(slideInHorizontally { height -> height } + fadeIn()).togetherWith(
                        //slideOutHorizontally { height -> -height } + fadeOut())
                    } else {
                        (scaleIn() + fadeIn()).togetherWith(
                            scaleOut() + fadeOut()
                        )
                        //(slideInHorizontally { height -> height } + fadeIn()).togetherWith(
                        //slideOutHorizontally { height -> -height } + fadeOut())
                    }.using(SizeTransform(clip = false))
                }, label = ""
            ) { targetState ->
                if (targetState) {
                    Image(
                        painter = painterResource(id = R.drawable.punchtext),
                        contentDescription = "$targetState"
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.punch),
                        contentDescription = "",
                        modifier = Modifier.rotate(180f)
                    )
                }
            }
            Button(onClick = { isStart = !isStart }, modifier = Modifier.padding(top = 30.dp)) {
                Text("Check Animation")
            }
        }
    }
}

@Preview(name = "ContentChangesAnimation")
@Composable
private fun PreviewContentChangesAnimation() {
    ContentAnimation()
}