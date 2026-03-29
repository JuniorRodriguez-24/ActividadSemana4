package com.example.actividadsemana4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "principal") {
                composable("principal") { PrincipalScreen(navController) }
                composable("detalle/{cedula}/{nombre}/{apellido}/{telefono}/{direccion}/{email}") { backStackEntry ->
                    Detalle(
                        cedula = backStackEntry.arguments?.getString("cedula") ?: "",
                        nombre = backStackEntry.arguments?.getString("nombre") ?: "",
                        apellido = backStackEntry.arguments?.getString("apellido") ?: "",
                        telefono = backStackEntry.arguments?.getString("telefono") ?: "",
                        direccion = backStackEntry.arguments?.getString("direccion") ?: "",
                        email = backStackEntry.arguments?.getString("email") ?: "",
                    )
                }
            }
        }
    }
}

@Composable
fun PrincipalScreen(navController: NavController) {

    var cedula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(
                value = cedula,
                onValueChange = { cedula = it },
                label = { Text("Cedula") })
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") })
            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") })
            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Telefono") })
            OutlinedTextField(
                value = direccion,
                onValueChange = { direccion = it },
                label = { Text("Direccion") })
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") })

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {

                navController.navigate("detalle/$cedula/$nombre/$apellido/$telefono/$direccion/$email")
            }) {
                Text("Enviar")
            }
        }
    }
}

@Composable
fun Detalle(cedula: String, nombre: String, apellido: String, telefono: String, direccion: String, email: String) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("La cedula es: $cedula", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))

            Text("El nombre es: $nombre", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))

            Text("El apellido es: $apellido", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))

            Text("El telefono es: $telefono", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))

            Text("La direccion es: $direccion", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))

            Text("El email es: $email", style = MaterialTheme.typography.bodyLarge)
        }
    }
}