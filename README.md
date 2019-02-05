<h1 align="center">IgnoreBatteryOptimisationChecker<a href="https://github.com/AndroFlo/IgnorebatteryoptimisationcheckerApp"><img src="https://jitpack.io/v/AndroFlo/IgnorebatteryoptimisationcheckerApp.svg"></a></h1>
<h4 align="center">Android Library</h4>
<h3 align="center">This library is a fork of <a href="https://github.com/javiersantos/AppUpdater">AppUpdated</a></h3>


<p align="center">Android Library that checks fif our application is whitelisted in the system battery saver. If not by default a dialog is displayed and the user can clic on the "Settings" button to launch the ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS intent. </p>


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
