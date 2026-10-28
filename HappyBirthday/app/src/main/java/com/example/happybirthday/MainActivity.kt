package com.example.happybirthday


import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier.padding(16.dp)
                    )

                }
            }
        }
    }
}


@Composable
fun GreetingText (message: String, from: String,modifier: Modifier = Modifier) {

    Column (verticalArrangement = Arrangement.Center, // Texto centrado verticalmente
        modifier = modifier) {
        Text(  // Mensaje que happy birthday
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center

        )

        Text( // Mensaje de quien es el destinatario
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)

            )
    }

}

// ¿Que hace modifier: Modifier = Modifier?
// Los modificadores le indican a un elemento de la IU
// cómo aparecer o comportarse en su diseño de nivel superio
@Composable
fun GreetingImage (message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty);

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null, // Descripción de la imagen
            contentScale = ContentScale.Crop, // Redimensiona la imagen para que llene toda la pantalla
            alpha = 0.5F, // Opacidad de la imagen
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)


        )
    }
}



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}