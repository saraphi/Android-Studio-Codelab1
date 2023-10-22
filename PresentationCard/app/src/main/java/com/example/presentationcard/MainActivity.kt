package com.example.presentationcard

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentationCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PresentationCard("Sara", description = "Soy estudiante de la Escuela de Ingeniería Informática en la ULPGC. " +
                            "Me encantaría especializarme en la Computación Gráfica y mi pasión, aparte de la programación" +
                            "es el arte digital y la música.")
                }
            }
        }
    }
}


@Composable
fun Presentation(name: String, description: String, modifier: Modifier) {
    val icon = painterResource(R.drawable.icon)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(190.dp)
                .padding(
                    bottom = 20.dp
                )
        )
        Text(
            text = name,
            fontSize = 25.sp,
            lineHeight = 5.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = description,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(50.dp)
        )
    }
}
@Composable
fun PresentationCard(name: String, description: String, modifier: Modifier = Modifier) {
    val background = painterResource(R.drawable.background)
    Box(
        modifier = modifier
    ) {
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
            alpha = 0.8F
        )
        Presentation(
            name = name,
            description = description,
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview"
)
@Composable
fun PresentationPreview() {
    PresentationCardTheme {
        PresentationCard(
            "Sara González Ramírez",
            description = "Soy estudiante de la Escuela de Ingeniería Informática en la ULPGC. " +
                    "Me encantaría especializarme en la Computación Gráfica y mi pasión, aparte de la programación" +
                    "es el arte digital y la música.",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}