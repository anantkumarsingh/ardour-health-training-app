# Ozark - AI Playlist Generator App
Ozark is a modern Android application built entirely with Kotlin and Jetpack Compose that leverages the power of Google's Gemini generative AI to create unique and personalized Spotify playlists. Go beyond simple search and discover music in a completely new way by giving the AI creative text prompts, analyzing images, blending your existing playlists, and more.

---

## Screenshots

| Login Screen | Permissions Screen | Home Screen (Top) | Profile Screen |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/645cf990-d73d-4df3-b330-dd91a985fad5" width="200" /> | <img src="https://github.com/user-attachments/assets/e2f7288f-83c0-48b4-80e0-db9826505205" width="200" /> | <img src="https://github.com/user-attachments/assets/ed368a5c-72b8-41ad-9798-30f9907ba2a7" width="200" /> | <img src="https://github.com/user-attachments/assets/dd761e4f-763f-419b-bc09-8d10cd6fae11" width="200" /> |

| Playlist Creation Options | Create by Text Prompt | Create By Image | Create By Image (Upload) |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/44d9cb46-4a7d-45e7-8cac-4cf1d38856fc" width="200" /> | <img src="https://github.com/user-attachments/assets/da1c8f9e-d074-41d4-89ca-7394efb5e9bd" width="200" /> | <img src="https://github.com/user-attachments/assets/30c91136-4983-45d9-abbc-c013c1e86482" width="200" /> | <img src="https://github.com/user-attachments/assets/a483bd84-0de8-4948-b2ab-8154ceb786e0" width="200" />|

| Blend 2 Playlists | Playlist View | Profile Screen (Bottom) | Show All Playlists |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/4f9a5b58-e218-4d04-8b5b-ebcc08fc8abe" width="200" /> | <img src="https://github.com/user-attachments/assets/5245e1fb-c274-40de-b65b-87d0e454ca2f" width="200" /> | <img src="https://github.com/user-attachments/assets/b38888af-f462-46d4-8ca1-78faefdc5b31" width="200" /> | <img src="https://github.com/user-attachments/assets/dff3abc4-10f3-440c-b60a-f4f6494eb3e3" width="200"/> |


---

## Features

The app is packed with features designed to provide a seamless and creative music discovery experience:

* **Dynamic AI Playlist Generation:**
    * **From Text:** Write any idea, mood, or complex prompt, and the AI will generate a tailored playlist.
    * **From Images:** Select an image from your gallery, and the AI will analyze its vibe to create a matching playlist.
    * **From AI Suggestions:** The home screen is populated with AI-generated ideas (Artists, Albums, and Prompts) that you can tap to instantly generate a new playlist.

* **AI Playlist Fusion:**
    * Select any two playlists from your own Spotify library.
    * The AI analyzes the tracks from both and intelligently creates a new "blend" playlist that captures the essence of both.

* **Seamless Spotify Integration:**
    * Secure Spotify login using the OAuth 2.0 Authorization Code Flow with PKCE.
    * **Automatic Token Refresh:** The app automatically handles expired access tokens, providing an uninterrupted user experience without requiring re-login.
    * One-tap transfer to save and open any generated playlist directly in your Spotify account.

* **Personalized Library & Profile:**
    * All generated playlists are automatically saved to a local database.
    * A dynamic profile screen shows your stats, including the total number of playlists created and songs discovered.
    * The profile also features a personalized "Discovered Artists" section based on the tracks in your saved playlists.

* **Modern, Dynamic UI:**
    * Built entirely with **Jetpack Compose** and **Material Design 3**.
    * Supports system-wide Dark Mode.
    * Features a modern, floating navigation bar and a dynamic top app bar that becomes transparent when scrolling.

---

## Technology Stack & Architecture

* **UI:** Jetpack Compose & Material 3
* **Language:** 100% Kotlin
* **Architecture:** MVVM (Model-View-ViewModel) with a Repository Pattern
* **Asynchronicity:** Kotlin Coroutines & Flow for all async operations.
* **Networking:**
    * **Retrofit:** For type-safe HTTP requests to the Spotify API.
    * **OkHttp:** For the underlying HTTP client, featuring a custom `Authenticator` for automatic token refresh and a `Logging Interceptor` for debugging.
* **AI Model:** Google's **Gemini Pro** accessed via the Firebase Vertex AI SDK.
* **Database:** **RoomDB** for local persistence of user-created playlists and tracks.
* **Image Loading:** **Coil** for asynchronously loading images from the web.
* **Data Parsing:**
    * **Kotlinx.serialization:** For parsing JSON from the Gemini AI.
    * **Gson:** For parsing JSON from the Spotify API.

---

## Setup and Installation

To build and run this project yourself, you will need to:

1.  Clone the repository: `git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git`
2.  Open the project in the latest stable version of Android Studio.
3.  Create a `local.properties` file in the root directory of the project.
4.  Add your Spotify Client ID to this file:
    ```properties
    SPOTIFY_CLIENT_ID="YOUR_CLIENT_ID_HERE"
    ```
5.  Go to your Spotify Developer Dashboard and ensure that your app is configured with the correct **Redirect URI**: `ozark://callback`.
6.  Build and run the app.

---

## Notes & Known Issues

1.  Over time, if content doesn't display correctly, please try logging out and logging back in from the profile screen.
2.  The Spotify token refresh mechanism is being improved and will be made more robust in future updates.

---

## Download

If you'd like to try the app without building it from source, you can download the latest pre-compiled APK from the **Releases** page.

**[Download the Latest Release](https://github.com/anantkumarsingh/ozark-ai-music-app/releases/latest)**

---

## LICENSE
This project is licensed under the MIT License.
