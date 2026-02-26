# Compose Navigation Lab

This project demonstrates a simple navigation flow in a Jetpack Compose application. It includes screens for Sign Up, Login, and a Home screen, showcasing how to pass data between destinations.

## Navigation Flow

The application follows this navigation flow:

1.  **Sign Up Screen**: The user is first presented with a sign-up screen to create a username and password.
2.  **Login Screen**: Upon signing up, the user data is serialized into a JSON string and passed to the login screen. The user can then log in using the credentials they just created.
3.  **Home Screen**: After a successful login, the app navigates to the home screen, which displays a welcome message with the user's name. The home screen also has a logout button to return to the sign-up screen.

## Technologies Used

*   **Jetpack Compose**: The UI is built entirely with Jetpack Compose, a modern declarative UI toolkit for Android.
*   **Compose Navigation**: Navigation between screens is handled using the Jetpack Compose Navigation library.
*   **Kotlinx Serialization**: User data is passed between screens by serializing and deserializing a `User` data class to and from a JSON string.
