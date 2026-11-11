package com.example.cuandrantecompose


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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuandrantecompose.ui.theme.CuandranteComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuandranteComposeTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuandranteView()
                }
                }
            }
        }
    }


@Composable
fun CuandranteView () {

    Column(Modifier.fillMaxWidth()) {

        Row (Modifier.weight(1f)) {
            CuadranteInfo(
                titulo =  stringResource(R.string.titulo1),
                descripcion = stringResource(R.string.descripcion1),
                colorFondo = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            CuadranteInfo(
                titulo = stringResource(R.string.titulo2),
                descripcion = stringResource(R.string.descripcion2),
                colorFondo = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)

            )
        }
        Row (Modifier.weight(1f)) {
            CuadranteInfo(
                titulo = stringResource(R.string.titulo3),
                descripcion = stringResource(R.string.descripcion3),
                colorFondo = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            CuadranteInfo(
                titulo = stringResource(R.string.titulo4),
                descripcion = stringResource(R.string.descripcion4),
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

    Column (modifier = modifier
        .fillMaxSize()
        .background(colorFondo)
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text (
            text = titulo,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text (
            text = descripcion,
            textAlign = TextAlign.Justify
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuandranteComposeTheme {
        CuandranteView()
    }
}