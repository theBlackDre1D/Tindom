package co.init.tindom.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import tindom.composeapp.generated.resources.Res
import tindom.composeapp.generated.resources.app_name

@Composable
fun TindomAppBar() {
    TopAppBar(
        backgroundColor = Color.White,
        elevation = 8.dp,
        title = { Text(text = stringResource(Res.string.app_name)) }
    )
}