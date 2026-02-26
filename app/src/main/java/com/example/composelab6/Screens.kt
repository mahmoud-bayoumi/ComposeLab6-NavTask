sealed class Screens(val route: String) {
    object SignUp : Screens("signup")
    object Login : Screens("login/{userJson}") {
        fun createRoute(userJson: String) = "login/$userJson"
    }
    object Home : Screens("home/{name}")
}