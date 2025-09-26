# Ardour - Health and Fitness Tracking App
Ardour is a legacy Android (Java) app I built in March 2023 to bring everyday health utilities into one place. It combines simple fitness logging, calorie and water intake tracking, nearby-care lookups (hospitals, fitness centers, blood donors/donation camps), doctor search, a lightweight medicine shop view, and short blog reads—aimed at giving users a single, convenient hub for day-to-day wellness.

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

* **Fitness Tracker:** Log basic workouts/activities and keep a simple history.
* **Calorie Tracker** – Manually add meals/foods and track daily intake against goals.
* **Fitness Tracker:** Log basic workouts/activities and keep a simple history.
* **Water Intake Tracker** – Quick-add glasses/ML to stay hydrated through the day.
* **Nearby Hospitals & Fitness Centers** – Find relevant places around you using device location.
* **Blood Donors & Donation Camps** – Look up donors or local camp info (where available).
* **Medicines Shop** – Browse/search medicines with a basic catalog-style interface.
* **Search for Doctors** – Simple discovery flow to find doctors by specialty/name (data-source dependent).
* **Blogs / Articles** – Short reads with health and fitness tips.


---

## Technology Stack & Architecture

* Language: Java (Android)
* IDE / Timeframe: Android Studio Flamingo era (project created March 2023)
* Build System: Gradle with Android Gradle Plugin 7.3.1
* Android SDK: Legacy Android View system with XML layouts
* Core Android APIs: Activities/Fragments, Permissions, Location (for “nearby” features)

---

## Notes & Known Issues

* **Legacy project (for reference/demo use**). This is not a production or medically validated app and should not be used for clinical decision-making. Location and third-party data may be incomplete or outdated.
* **Old toolchain**. The code targets the Flamingo timeframe with AGP 7.3.1. To run as-is, match Gradle/AGP versions (e.g., Gradle 7.4 with AGP 7.3.1). Newer Android Studio versions may prompt upgrades that can break the build.

* **Modernization path (recommended for a fresh rebuild)**:
   * Kotlin, Jetpack Compose UI, Navigation, Room (local DB), Retrofit/OkHttp (network), Hilt (DI), Coroutines/Flow.
   * Update to current compile/target SDK, AGP 8+, Gradle 8+, and adopt runtime permissions & privacy best practices.
   * Replace/verify all data sources (donors, doctors, shops) and add proper error handling, caching, and pagination.

* **Security & Privacy**. If reviving, audit all permissions (Location, Network), add a privacy policy, secure API keys, and comply with platform and regional regulations.

*  **Repository note**. The attached code is from 2023 and is shared for archival/learning. A robust, up-to-date version should be implemented with the modern stack above.

---

## LICENSE
This project is licensed under the MIT License.
