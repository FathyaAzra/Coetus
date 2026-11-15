package com.fazra.coetus.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fazra.coetus.R
import com.fazra.coetus.ui.components.CoetusActionButton
import com.fazra.coetus.ui.components.CoetusOutlinedActionButton
import com.fazra.coetus.ui.components.ScreenBackground
import com.fazra.coetus.ui.theme.CoetusTheme

@Composable
fun IntroScreenRoot(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    IntroScreen(
        onAction = { action ->
            when(action) {
                IntroAction.OnSignInClick -> onSignInClick()
                IntroAction.OnSignUpClick -> onSignUpClick()
            }
        }
    )
}

@Composable
fun IntroScreen(
    onAction: (IntroAction) -> Unit
) {
    ScreenBackground() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            // Center content
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CoetusLogoVertical()

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(R.string.welcome_to_coetus),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.coetus_description),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // Bottom buttons
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 48.dp)
            ) {
                CoetusOutlinedActionButton(
                    text = stringResource(R.string.sign_in),
                    isLoading = false,
                    onClick = {
                        onAction(IntroAction.OnSignInClick)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                CoetusActionButton(
                    text = stringResource(R.string.sign_up),
                    isLoading = false,
                    onClick = {
                        onAction(IntroAction.OnSignUpClick)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun CoetusLogoVertical(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.coetus_logo_round),
            contentDescription = "Coetus Logo",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

}

@Preview
@Composable
private fun IntroScreenPreview() {
    CoetusTheme() {
        IntroScreen(
            onAction = {}
        )
    }
}