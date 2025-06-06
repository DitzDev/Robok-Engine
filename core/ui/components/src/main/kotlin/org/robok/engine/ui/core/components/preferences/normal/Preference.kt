package org.robok.engine.ui.core.components.preferences.normal

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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate

/*
 * A Normal preference used in settings
 * @author Aquiles Trindade (trindadedev).
 */

@Composable
fun Preference(
  modifier: Modifier = Modifier,
  icon: @Composable (() -> Unit)? = null,
  title: @Composable () -> Unit,
  description: @Composable (() -> Unit) = {},
  trailing: @Composable (() -> Unit) = {},
  onClick: (() -> Unit)? = null,
) {
  val interactionSource = remember { MutableInteractionSource() }

  PreferenceTemplate(
    modifier =
      modifier.clickable(
        indication = ripple(),
        interactionSource = interactionSource,
        onClick = { onClick?.invoke() },
      ),
    contentModifier = Modifier.fillMaxHeight().padding(vertical = 16.dp).padding(start = 16.dp),
    title = {
      ProvideTextStyle(MaterialTheme.typography.titleLarge.copy(fontSize = 19.sp)) { title() }
    },
    description = {
      ProvideTextStyle(
        MaterialTheme.typography.bodyMedium.copy(
          color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
      ) {
        description()
      }
    },
    endWidget = {
      if (icon != null) {
        Box(modifier = Modifier.padding(8.dp)) { icon() }
      }
      trailing()
    },
    enabled = true,
    applyPaddings = false,
  )
}
