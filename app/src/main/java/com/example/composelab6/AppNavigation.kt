package com.example.composelab6


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SignUp.route ,
        modifier = modifier
    ) {

        composable(Screens.SignUp.route) {
            SignUpScreen { user, pass ->
                val userObj = User(user, pass)

                val json = kotlinx.serialization.json.Json.encodeToString(userObj)
                val encoded = java.net.URLEncoder.encode(
                    json,
                    java.nio.charset.StandardCharsets.UTF_8.toString()
                )

                navController.navigate(
                    Screens.Login.createRoute(encoded)
                )
            }
        }

        composable(
            route = Screens.Login.route,
            arguments = listOf(
                navArgument("userJson") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val encodedJson =
                backStackEntry.arguments?.getString("userJson") ?: ""

            val decodedJson = java.net.URLDecoder.decode(
                encodedJson,
                java.nio.charset.StandardCharsets.UTF_8.toString()
            )

            val user =
                kotlinx.serialization.json.Json.decodeFromString<User>(decodedJson)

            LoginScreen(
                registeredUser = user.username,
                registeredPass = user.password,
                onLoginSuccess = { name ->
                    navController.navigate("home/$name")
                }
            )
        }

        composable("home/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""

            HomeScreen(
                name = name,
                onLogout = {
                    navController.navigate(Screens.SignUp.route) {
                        popUpTo(Screens.SignUp.route) { inclusive = true }
                    }
                }
            )
        }
    }
}