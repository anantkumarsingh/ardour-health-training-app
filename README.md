# Ardour - Health and Fitness Tracking App
Ardour is a legacy Android (Java) app I built in March 2023 to bring everyday health utilities into one place. It combines simple fitness logging, calorie and water intake tracking, nearby-care lookups (hospitals, fitness centers, blood donors/donation camps), doctor search, a lightweight medicine shop view, and short blog reads—aimed at giving users a single, convenient hub for day-to-day wellness.

---

## Screenshots

| Login Screen | Home Screen | Home Screen | Home Screen |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/ff692cd6-2c8d-49fc-8149-1f5f84329da8" width="200" /> | <img src="https://github.com/user-attachments/assets/361275c4-24b1-468e-b09c-b20a0bd628c2" width="200" /> | <img src="https://github.com/user-attachments/assets/ed174aad-984b-4abc-a10d-b74c014b3efe" width="200" /> | <img src="https://github.com/user-attachments/assets/0752e625-e2bd-4953-b59e-e9300b029e61" width="200" />

| Playlist Creation Options | Create by Text Prompt | Create By Image | Create By Image (Upload) |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/1bb45a9e-ad9f-4b72-ac08-aa60faf11520" width="200" /> |<img src="https://github.com/user-attachments/assets/f7309bd8-703a-47bb-9f6b-15fa94e85005" width="200" /> | <img src="https://github.com/user-attachments/assets/28fea08d-3d2d-40c0-8dd0-6aa7dc673350" width="200" /> | <img src="https://github.com/user-attachments/assets/bca2d9ef-e42f-41e3-aa21-5fd4e750c891" width="200" />|

| Blend 2 Playlists | Playlist View | Profile Screen (Bottom) | Show All Playlists |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/d5a03d70-4c91-4367-b6e5-0890627cf929" width="200" /> | <img src="https://github.com/user-attachments/assets/8c5c112b-4828-46e0-843e-16ba3c4c5378" width="200" /> | <img src="https://github.com/user-attachments/assets/94d74ac1-af00-46f4-8b2a-3c1b7f4282f5" width="200" /> | <img src="https://github.com/user-attachments/assets/e3c159eb-ed22-4fec-a113-d591307d3f26" width="200"/> |


| Blend 2 Playlists | Playlist View | Profile Screen (Bottom) | Show All Playlists |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/139b9ded-7ab4-4610-879e-e22000c27e0c" width="200" /> |<img src="https://github.com/user-attachments/assets/2d3addc5-f5e1-4390-a731-95492bf8af8e" width="200" /> |<img src="https://github.com/user-attachments/assets/f745aacc-6878-4dab-8626-e5946ea4596f" width="200" /> | <img src="https://github.com/user-attachments/assets/b8b1bcd0-e9d5-4d75-a0db-2004692b54db" width="200"/> |

| Blend 2 Playlists | Playlist View | Profile Screen (Bottom) | Show All Playlists |
| :---: | :---: | :---: | :---: |
|<img src="https://github.com/user-attachments/assets/269cbf1c-e8b2-4db6-9a80-6599530ff2c0" width="200" /> | <img src="https://github.com/user-attachments/assets/ff638a85-11df-43b3-a29b-5cf3c637059b" width="200" /> | <img src="https://github.com/user-attachments/assets/630a5f0f-cc37-4819-abba-27a3624c3238" width="200" /> | <img src="https://github.com/user-attachments/assets/dbe36e96-03bd-4212-bd61-3f8471f06b91" width="200"/> |

| Blend 2 Playlists | Playlist View |
| :---: | :---: |
|<img src="https://github.com/user-attachments/assets/a813ab1f-b47f-4e9a-80c8-7ae8221b0656" width="200" /> | <img src="https://github.com/user-attachments/assets/63f7307e-7166-4bec-a511-8ad69708e6da" width="200" /> | 

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
