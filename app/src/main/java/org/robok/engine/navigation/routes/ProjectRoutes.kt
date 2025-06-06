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
import org.robok.engine.models.project.ProjectTemplate

@Keep @Serializable data class CreateProjectRoute(val template: ProjectTemplate) : Route

@Keep @Serializable object ManageProjectsRoute : Route

@Keep @Serializable object TemplatesRoute : Route

@Keep @Serializable data class ProjectSettingsRoute(val projectPath: String) : Route
