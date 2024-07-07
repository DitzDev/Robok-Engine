package dev.trindade.robokide.ui.activities

import android.os.Bundle

import androidx.activity.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.draw.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.input.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.*

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.theme.*
import dev.trindade.robokide.ui.models.toolbar.*
import dev.trindade.robokide.ui.editor.*
import dev.trindade.robokide.terminal.*

import robok.trindade.compiler.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val terminal = RobokTerminal(this)
        val compilerListener = object : RobokCompiler.CompilerListener {
            override fun onCompiled(logs: String) {
                terminal.show()
            }
        }
        val compiler = RobokCompiler(this, compilerListener)
        setContent {
            RobokTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Content(compiler)
                }
            }
        }
    }

    @Composable
    fun Content(compiler: RobokCompiler) {
        var code by remember { mutableStateOf("package dev.trindade.robokproject;\n\npublic class MyNewScript {\n\n String[] credits = [\"TH Dev\", \"trindadedev\"];\nint apples = 0;\n}") }
        
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            HighlightingEditor(
                value = code,
                onValueChange = { newValue -> code = newValue },
                syntaxType = "java",
                modifier = Modifier.fillMaxSize()
            )

            Button(
                onClick = { compiler.compile(code) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                Image(
                   painter = painterResource(id = R.drawable.run_image),
                   contentDescription = "Run",
                   modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}