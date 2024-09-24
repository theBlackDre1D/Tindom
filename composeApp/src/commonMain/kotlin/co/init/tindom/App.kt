package co.init.tindom

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.init.tindom.resources.Strings
import co.init.tindom.theme.primaryColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tindom.composeapp.generated.resources.Res
import tindom.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    backgroundColor = primaryColor,
                    title = { Text(text = Strings.get("app_name")) }
                )
            },
            bottomBar = {
                BottomNavigation {
                    Row {
                        BottomNavigationItem(
                            icon = { Text("O") },
                            label = { Text("Home") },
                            selected = true,
                            onClick = {
                                // TODO
                            }
                        )

                        BottomNavigationItem(
                            icon = { Text("O") },
                            label = { Text("Home") },
                            selected = true,
                            onClick = {
                                // TODO
                            }
                        )

                        BottomNavigationItem(
                            icon = { Text("O") },
                            label = { Text("Home") },
                            selected = true,
                            onClick = {
                                // TODO
                            }
                        )
                    }
                }
            }
        ) {
            var showContent by remember { mutableStateOf(false) }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
            }
        }
    }
}