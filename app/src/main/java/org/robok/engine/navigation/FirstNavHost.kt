package org.robok.engine.navigation

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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.robok.engine.navigation.routes.MainRoute
import org.robok.engine.navigation.routes.SetupRoute
import org.robok.engine.navigation.setup.SetupNavHost
import org.robok.engine.ui.platform.LocalFirstNavController
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.platform.LocalSetupNavController

@Composable
fun FirstNavHost() {
  val navController = LocalFirstNavController.current

  BaseNavHost(navController = navController, startDestination = MainRoute) {
    composable<MainRoute> {
      CompositionLocalProvider(LocalMainNavController provides rememberNavController()) {
        MainNavHost()
      }
    }
    composable<SetupRoute> {
      CompositionLocalProvider(LocalSetupNavController provides rememberNavController()) {
        SetupNavHost()
      }
    }
  }
}
