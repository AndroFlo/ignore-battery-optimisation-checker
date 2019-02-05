<h1 align="center">IgnoreBatteryOptimisationChecker<a href="https://github.com/AndroFlo/IgnorebatteryoptimisationcheckerApp#how-to-include"><img src="https://jitpack.io/v/javiersantos/AppUpdater.svg"></a></h1>
<h4 align="center">Android Library</h4>

<p align="center">Android Library that checks for updates on Google Play, GitHub, Amazon, F-Droid or your own server. This library notifies your apps' updates by showing a Material dialog, Snackbar or notification. Check out the <a href="https://github.com/javiersantos/AppUpdater/wiki">wiki</a>.</p>


## How to include
Add the repository to your project **build.gradle**:
```Gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

And add the library to your module **build.gradle**:
```Gradle
dependencies {
    implementation 'com.github.javiersantos:AppUpdater:2.7'
}
```

## Usage

### Activity / Fragment
By default, the basic usage will show a default dialog when a new version is found on the Play Store (otherwise nothing will be shown). By calling the `.check()` method, the library will work in background. You can cancel it at any time by calling `.stop()`. Other customizations are explained below.

```Kotlin
IgnoreBatteryOptimisationChecker(this)
                .check()
```

## License
	Copyright 2019 Audigué Florian
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
