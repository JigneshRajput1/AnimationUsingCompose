package com.example.animationusingcompose.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentSizeChangesAnimation(
    modifier: Modifier = Modifier
) {
    ContentSizeChangesAnim()
}

@Composable
fun ContentSizeChangesAnim() {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .animateContentSize()
                .height(if (expanded) 400.dp else 200.dp)
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    expanded = !expanded
                }
        ) {
            Text(
                "Press",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Text(
            "Hello",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "ContentSizeChangesAnimation")
@Composable
private fun PreviewContentSizeChangesAnimation() {
    ContentSizeChangesAnimation()
}