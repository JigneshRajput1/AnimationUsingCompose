package com.example.animationusingcompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationusingcompose.ui.screen.ContentAnimation
import com.example.animationusingcompose.ui.screen.ContentSizeChangesAnimation
import com.example.animationusingcompose.ui.screen.ValueBaseAnimation
import com.example.animationusingcompose.ui.screen.VisibilityChangesAnimation
import com.example.animationusingcompose.ui.theme.AnimationUsingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationUsingComposeTheme {
                InitSetUp()
            }
        }
    }
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun InitSetUp() {
        var count by remember { mutableIntStateOf(0) }
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            AnimatedContent(
                modifier = Modifier.weight(1f),
                targetState = count,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { fullWidth -> fullWidth }
                        ) togetherWith
                                slideOutHorizontally(
                                    animationSpec = tween(300),
                                    targetOffsetX = { fullWidth -> -fullWidth }
                                )
                    } else {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { fullWidth -> -fullWidth }
                        ) togetherWith
                                slideOutHorizontally(
                                    animationSpec = tween(300),
                                    targetOffsetX = { fullWidth -> fullWidth }
                                )
                    }
                }, label = ""
            ) { targetCount ->
                when (targetCount) {
                    0 -> {
                        VisibilityChangesAnimation()
                    }

                    1 -> {
                        ContentSizeChangesAnimation()
                    }

                    2 -> {
                        ContentAnimation()
                    }

                    3 -> {
                        ValueBaseAnimation()
                    }

                    else -> {}
                }
            }
            Row(modifier = Modifier.background(Color.Gray).padding(30.dp)) {
                Button(modifier = Modifier.weight(1f).padding(end = 15.dp), onClick = { if (count>0)count-- }) {
                    Text("previous", fontSize = 16.sp)
                }
                Button(modifier = Modifier.weight(1f).padding(start = 15.dp), onClick = { if (count<3)count++ }) {
                    Text("next", fontSize = 16.sp)
                }
            }
        }
    }
}
