package co.init.tindom.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import co.init.tindom.theme.primaryColor
import org.jetbrains.compose.resources.stringResource
import tindom.composeapp.generated.resources.Res
import tindom.composeapp.generated.resources.app_name

@Composable
fun TindomAppBar() {
    TopAppBar(
        backgroundColor = primaryColor,
        title = { Text(text = stringResource(Res.string.app_name)) }
    )
}