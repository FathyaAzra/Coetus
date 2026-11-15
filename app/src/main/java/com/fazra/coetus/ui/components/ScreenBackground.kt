package com.fazra.coetus.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.ui.tooling.preview.Preview
import com.fazra.coetus.ui.theme.CoetusTheme

@Composable
fun ScreenBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBackgroundPreview() {
    CoetusTheme {
        ScreenBackground(
            modifier = Modifier.fillMaxSize()
        ) {
            // Preview content
        }
    }
}