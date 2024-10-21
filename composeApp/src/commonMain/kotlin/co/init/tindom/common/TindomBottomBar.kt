package co.init.tindom.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import tindom.composeapp.generated.resources.Res
import tindom.composeapp.generated.resources.bottom_navigation_home
import tindom.composeapp.generated.resources.bottom_navigation_profile
import tindom.composeapp.generated.resources.bottom_navigation_settings
import tindom.composeapp.generated.resources.ic_home
import tindom.composeapp.generated.resources.ic_profile
import tindom.composeapp.generated.resources.ic_settings

sealed class HomeNavigationScreen(
    val icon: DrawableResource,
    val label: StringResource,
    val route: String
) {
    data object Home : HomeNavigationScreen(Res.drawable.ic_home, Res.string.bottom_navigation_home, "home")
    data object Profile : HomeNavigationScreen(Res.drawable.ic_profile, Res.string.bottom_navigation_profile, "profile")
    data object Settings : HomeNavigationScreen(Res.drawable.ic_settings, Res.string.bottom_navigation_settings, "settings")
}

@Composable
fun TindomBottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavigationScreens = listOf(
        HomeNavigationScreen.Home,
        HomeNavigationScreen.Profile,
        HomeNavigationScreen.Settings
    )
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row {
            bottomNavigationScreens.forEach { screen ->
                BottomNavigationItem(
                    modifier = Modifier.padding(bottom = 8.dp),
                    icon = { Image(painterResource(screen.icon), null) },
                    label = { Text(stringResource(screen.label)) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        if (screen.route != currentRoute) {
                            navController.navigate(screen.route)
                        }
                    }
                )
            }
        }
    }
}