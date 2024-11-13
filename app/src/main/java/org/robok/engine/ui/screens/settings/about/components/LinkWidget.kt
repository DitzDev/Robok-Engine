package org.robok.engine.ui.screens.settings.about.components

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import org.robok.engine.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.models.about.Link

@Composable
fun LinkWidget(model: Link) {
  val uriHandler = LocalUriHandler.current

  PreferenceTemplate(
    modifier = Modifier.clickable { uriHandler.openUri(model.url) },
    title = { Text(fontWeight = FontWeight.Bold, text = model.name) },
    description = { Text(text = model.description) },
    startWidget = {
      Image(
        painter = painterResource(id = model.imageResId),
        contentDescription = null,
        modifier = Modifier.size(32.dp).clip(CircleShape),
      )
    },
  )
}
