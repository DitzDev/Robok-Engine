package org.robok.engine.templates.logic

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

import org.robok.engine.templates.CodeTemplate

open class KotlinClassTemplate : CodeTemplate() {

  override var name: String = "KotlinClass"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".kt"

  override var code: String = generateCode()

  override fun regenerate() {
    code = generateCode()
  }

  private fun generateCode(): String {
    return """
            package $packageName
            
            class $name {
              // your logic
            }
        """
      .trimIndent()
  }
}
