package co.init.tindom.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

    BottomNavigation {
        Row {
            // Home
            BottomNavigationItem(
                icon = { Image(painterResource(Res.drawable.ic_home), null) },
                label = { Text(stringResource(Res.string.bottom_navigation_home)) },
                selected = currentRoute == HomeNavigationScreen.Home.route,
                onClick = {
                    navController.navigate(HomeNavigationScreen.Home.route)
                }
            )

            BottomNavigationItem(
                icon = { Image(painterResource(Res.drawable.ic_profile), null) },
                label = { Text(stringResource(Res.string.bottom_navigation_profile)) },
                selected = currentRoute == HomeNavigationScreen.Profile.route,
                onClick = {
                    navController.navigate(HomeNavigationScreen.Profile.route)
                }
            )

            BottomNavigationItem(
                icon = { Image(painterResource(Res.drawable.ic_settings), null) },
                label = { Text(stringResource(Res.string.bottom_navigation_settings)) },
                selected = currentRoute == HomeNavigationScreen.Settings.route,
                onClick = {
                    navController.navigate(HomeNavigationScreen.Settings.route)
                }
            )
        }
    }
}