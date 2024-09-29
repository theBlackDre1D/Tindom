package co.init.tindom

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.init.tindom.common.HomeNavigationScreen
import co.init.tindom.common.TindomAppBar
import co.init.tindom.common.TindomBottomBar
import co.init.tindom.features.home.HomeScreen
import co.init.tindom.features.profile.ProfileScreen
import co.init.tindom.features.settings.SettingsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TindomAppBar() },
            bottomBar = { TindomBottomBar(navController) }
        ) {
//            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = HomeNavigationScreen.Home.route) {
                composable(HomeNavigationScreen.Home.route) { HomeScreen(navController) }
                composable(HomeNavigationScreen.Profile.route) { ProfileScreen(navController) }
                composable(HomeNavigationScreen.Settings.route) { SettingsScreen(navController) }
            }
        }
    }
}