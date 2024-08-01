package com.example.animationusingcompose.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationusingcompose.R

@Composable
fun VisibilityChangesAnimation() {
    StateBasedAnim()
}

@Composable
fun StateBasedAnim() {
    val scrollState = rememberScrollState()
    var fadeInOutVisible by remember { mutableStateOf(true) }
    var slideInOutVisible by remember { mutableStateOf(true) }
    var slideInOutHorizontalVisible by remember { mutableStateOf(true) }
    var slideInOutVerticalVisible by remember { mutableStateOf(true) }
    var expandInShrinkOutVisible by remember { mutableStateOf(true) }
    var expandShrinkHorizontallyVisible by remember { mutableStateOf(true) }
    var expandShrinkVerticallyVisible by remember { mutableStateOf(true) }
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        Text(
            text = "Visibility Changes Animation",
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { fadeInOutVisible = !fadeInOutVisible }) {
                Text(text = "FadeIn & FadeOut")
            }
            AnimatedVisibility(visible = fadeInOutVisible, enter = fadeIn(), exit = fadeOut()) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { slideInOutVisible = !slideInOutVisible }) {
                Text(text = "SlideIn & SlideOut")
            }
            AnimatedVisibility(
                visible = slideInOutVisible,
                enter = slideIn(animationSpec = tween(200)) { fullSize ->
                    IntOffset(
                        fullSize.width / 4,
                        -50
                    )
                },
                exit = slideOut(animationSpec = tween(200)) { fullSize ->
                    IntOffset(
                        -fullSize.width / 4,
                        -50
                    )
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { slideInOutHorizontalVisible = !slideInOutHorizontalVisible }) {
                Text(text = "SlideIn & SlideOut Horizontally")
            }
            AnimatedVisibility(
                visible = slideInOutHorizontalVisible,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { slideInOutVerticalVisible = !slideInOutVerticalVisible }) {
                Text(text = "SlideIn & SlideOut Vertically")
            }
            AnimatedVisibility(
                visible = slideInOutVerticalVisible,
                enter = slideInVertically(),
                exit = slideOutVertically()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { expandInShrinkOutVisible = !expandInShrinkOutVisible }) {
                Text(text = "expandIn & shrinkOut")
            }
            AnimatedVisibility(
                visible = expandInShrinkOutVisible,
                enter = expandIn(animationSpec = tween(800), expandFrom = Alignment.TopCenter) ,
                exit = shrinkOut(animationSpec = tween(800), shrinkTowards = Alignment.BottomEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { expandShrinkHorizontallyVisible = !expandShrinkHorizontallyVisible }) {
                Text(text = "expand & shrink Horizontally")
            }
            AnimatedVisibility(
                visible = expandShrinkHorizontallyVisible,
                enter = expandHorizontally(),
                exit = shrinkHorizontally()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .height(115.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { expandShrinkVerticallyVisible = !expandShrinkVerticallyVisible }) {
                Text(text = "expand & shrink Vertically")
            }
            AnimatedVisibility(
                visible = expandShrinkVerticallyVisible,
                enter = expandVertically(expandFrom = Alignment.Top),
                exit = shrinkVertically(shrinkTowards = Alignment.Top)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.composelogo),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(name = "VisibilityChangesAnimation")
@Composable
private fun PreviewVisibilityChangesAnimation() {
    VisibilityChangesAnimation()
}