package org.robok.engine.navigation.routes

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep @Serializable object SettingsRoute : Route

@Keep @Serializable object SettingsAppRoute : Route

@Keep @Serializable object SettingsCodeEditorRoute : Route

@Keep @Serializable object AboutRoute : Route

@Keep @Serializable object AboutLibrariesRoute : Route

@Keep @Serializable object SettingsDebugRoute : Route

@Keep @Serializable object SettingsDebugLoggingRoute : Route

@Keep @Serializable object SettingsAppThemeColorsRoute : Route
