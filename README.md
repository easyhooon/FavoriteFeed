# FavoriteFeed

## Development

### Required

- IDE : Android Studio Hedgehog
- JDK : Java 17을 실행할 수 있는 JDK
- Kotlin Language : 1.9.22

### Language

- Kotlin

### Libraries

- AndroidX
  - Activity Compose
  - Core
  - Lifecycle & ViewModel Compose
  - Navigation
  - Room
  - Paging3
  - StartUp

- Kotlin Libraries (Coroutine, Immutable, Serialization)
- Compose
  - Material3
  - Navigation

- Dagger Hilt
- Retrofit
- Timber
- Coil
- System UI Controller
- Compose Stable Marker
  
#### Code analysis

- Ktlint
- Detekt

#### Gradle Dependency

- Gradle Version Catalog

## Architecture
Based on [Now in Android](https://github.com/android/nowinandroid) with Clean Architecture

<img width="760" alt="image" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/2837a3b6-32f8-46aa-a102-3fb5b3e3826a">

<img width="760" alt="image" src="https://github.com/easyhooon/watcha-assignment/assets/51016231/b29020a1-69aa-482b-8af4-ddb27122a440">

## Package Structure
```
├── app
│   └── Application
├── build-logic
├── core
│   ├── data
│   ├── database
│   ├── designsystem
│   ├── domain
│   └── network
├── feature
│   ├── favorites
│   ├── home
│   └── main
│       └── MainActivity
├── gradle
│   └── libs.versions.toml
└── report
    ├── compose-metrics
    └── compose-reports
```
