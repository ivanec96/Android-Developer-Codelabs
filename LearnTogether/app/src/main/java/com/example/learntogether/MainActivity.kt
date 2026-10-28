package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ComposableArticleCard()
            }
        }
    }
}

@Composable
fun ComposableArticleCard() {
    ArticleCard(
        tittle = stringResource(R.string.tittle),
        paragraph1 = stringResource (R.string.compose_short_desc),
        paragraph2 = stringResource(R.string.compose_long_desc),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun ArticleCard (tittle: String, paragraph1: String, paragraph2: String, imagePainter: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image (painter = imagePainter, contentDescription = null)
        Text (
            text = tittle,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)

        )
        Text (
            text = paragraph1,
            modifier = Modifier
                .padding(start = 16.dp , end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text (
            text = paragraph2,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableArticleCardPreview() {
    LearnTogetherTheme {
        Surface {
            ComposableArticleCard()
        }
    }
}