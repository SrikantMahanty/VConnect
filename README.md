# VConnect

VConnect is an Android application that integrates ZegoCloud's UIKit to provide video and voice calling functionality.

## Features
- User authentication with user ID input
- Video and voice call initiation using ZegoCloud SDK
- Simple UI with EditText and Buttons for user interaction

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Android Studio installed
- Minimum SDK version 26 (as required by ZegoCloud SDK)
- Internet connection for API calls

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/SrikantMahanty/VConnect.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle files to install dependencies.
4. Update `AndroidManifest.xml` with necessary permissions:
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   <uses-permission android:name="android.permission.RECORD_AUDIO" />
   <uses-permission android:name="android.permission.CAMERA" />
   ```

## Dependencies
Add the following dependencies to your `build.gradle` (Module: app):
```gradle
implementation 'com.github.ZEGOCLOUD:zego_uikit_prebuilt_call_android:3.9.2'
```

## Usage
1. **Login Activity**
   - Enter your user ID.
   - Click on Login to initialize ZegoUIKit.
   
2. **Main Activity**
   - Enter the target user's ID.
   - Click on Video Call or Voice Call button to initiate a call.

## Troubleshooting
- If you encounter `Manifest merger failed`, ensure `minSdkVersion` is set to `26` or higher.
- If the emulator crashes, restart Android Studio and wipe AVD data.
- If the `button_background` attribute is missing, remove it or ensure you're using the latest version of Zego SDK.

## License
This project is licensed under the MIT License.

