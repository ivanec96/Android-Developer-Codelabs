package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vistas()
            }
        }
    }




// var pantalla = 1

@Composable
fun Vistas () {
    // Estado para controlar la pantalla actual
    var pantalla by remember { mutableStateOf(1) } // Estado para controlar la pantalla actual

    // Variables para almacenar los datos del formulario
    var edad by remember {mutableStateOf("")} // Estado para la edad
    var numeroDePagas by remember {mutableStateOf("")}
    var onNumeroDePagasChange: (String) -> Unit
    var salarioBruto by remember {mutableStateOf("")}
    var onSalarioBrutoChange: (String) -> Unit // Función para actualizar el salario bruto
    var numeroHijos by remember { mutableStateOf("") }
    var onNumeroHijosChange: (String) -> Unit
    var gradoDiscapacidad by remember { mutableStateOf("") }
    var onGradoDiscapacidadChange: (String) -> Unit
    var grupoProfesional by remember { mutableStateOf("") }
    var onGrupoProfesionalChange: (String) -> Unit
    var estadoCivil by remember { mutableStateOf("") }
    var onEstadoCivilChange: (String) -> Unit

    when (pantalla) {
        1 -> BienvenidaView(cambioPantalla = { pantalla = 2 })
        2 -> FormularioView(
            // Llamada a la función FormularioView con los parámetros correspondientes
            edad = edad, onEdadChange = { edad = it },
            numeroDePagas = numeroDePagas, onNumeroDePagasChange = { numeroDePagas = it },
            salarioBruto = salarioBruto, onSalarioBrutoChange = { salarioBruto = it },
            numeroHijos = numeroHijos, onNumeroHijosChange = { numeroHijos = it },
            gradoDiscapacidad = gradoDiscapacidad, onGradoDiscapacidadChange = { gradoDiscapacidad = it },
            grupoProfesional = grupoProfesional, onGrupoProfesionalChange = { grupoProfesional = it },
            estadoCivil = estadoCivil, onEstadoCivilChange = { estadoCivil = it },

            onCalcularClick = { pantalla = 3 })
        3 -> ResultView()
     }
    }


@Composable
fun BienvenidaView (cambioPantalla : () -> Unit, // Función para cambiar de pantalla
                    modifier: Modifier = Modifier) {
    // Se ejecuta cuando se muestra la pantalla de bienvenida
    LaunchedEffect(Unit) {
        delay (2000) // Espera 2 segundos
        cambioPantalla () // Cambia a la pantalla de inicio
    }
    Column( modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(R.string.mensaje_bienvenida),
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun FormularioView (edad: String, onEdadChange: (String) -> Unit,
                    numeroDePagas: String, onNumeroDePagasChange: (String) -> Unit,
                    salarioBruto: String, onSalarioBrutoChange: (String) -> Unit,
                    numeroHijos: String, onNumeroHijosChange: (String) -> Unit,
                    gradoDiscapacidad: String, onGradoDiscapacidadChange: (String) -> Unit,
                    grupoProfesional: String, onGrupoProfesionalChange: (String) -> Unit,
                    estadoCivil: String, onEstadoCivilChange: (String) -> Unit,
                    onCalcularClick: () -> Unit ) { // Función para manejar el clic en el botón "Calcular"

    // Vista del formulario
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.titulo_vista_formulario),
        modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,)

        OutlinedTextField(

            value = edad,
            onValueChange = onEdadChange, // Llamada a la función onEdadChange de Vista()
            label = { Text("Tu edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // Permite solo números
        )

        OutlinedTextField(
            value = numeroDePagas,
            label = {Text("Total de pagas al año")},
            onValueChange = onNumeroDePagasChange, // Llamada a la función onNumeroDePagasChange de Vista()
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = salarioBruto,
            label = {Text("Salario Bruto Anual")},
            onValueChange = onSalarioBrutoChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = numeroHijos,
            label = {Text("Número de Hijos")},
            onValueChange = onNumeroHijosChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = gradoDiscapacidad,
            label = {Text("Grado de Discapacidad")},
            onValueChange = onGradoDiscapacidadChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = grupoProfesional,
            label = {Text("Grupo Profesional")},
            onValueChange = onGrupoProfesionalChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            value = estadoCivil,
            label = {Text("Estado Civil")},
            onValueChange = onEstadoCivilChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(onClick = {onCalcularClick()},
        modifier = Modifier
            .padding(top = 16.dp)
            .width(200.dp)
            .height(50.dp)
            .align(Alignment.CenterHorizontally)
        ) {
            Text("Calcular")
        }
    }
}



@Composable
 fun ResultView () {

    Column(Modifier.fillMaxWidth()) {

        Row (Modifier.weight(1f)) {
            CuadranteInfo(
                titulo =  stringResource(R.string.titulo_salario_bruto),
                descripcion = stringResource(R.string.titulo_salario_bruto),
                colorFondo = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            CuadranteInfo(
                titulo = stringResource(R.string.titulo_salario_neto),
                descripcion = stringResource(R.string.titulo_salario_neto),
                colorFondo = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)

            )
        }
        Row (Modifier.weight(1f)) {
            CuadranteInfo(
                titulo = stringResource(R.string.titulo_retencion_irpf),
                descripcion = "Hola",
                colorFondo = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            CuadranteInfo(
                titulo = stringResource(R.string.titulo_deducciones),
                descripcion = "Caracola",
                colorFondo = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Definicion de la informacion del interior del cuadrante
@Composable
fun CuadranteInfo(
    titulo: String,
    descripcion: String,
    colorFondo: Color,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = titulo,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = descripcion,
            textAlign = TextAlign.Justify
        )

     }
    }
















