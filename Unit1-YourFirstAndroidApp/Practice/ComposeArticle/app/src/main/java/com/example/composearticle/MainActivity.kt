package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    JetPackComposeArticle()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ArticleBackground(background: Painter, description: String?, modifier: Modifier = Modifier) {
    Image(
        painter = background,
        contentDescription = description,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArticleTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, fontSize = 24.sp, modifier = modifier.padding(16.dp))
}

@Composable
fun ArticleAbstract(abstract: String, modifier: Modifier = Modifier) {
    Text(
        text = abstract,
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(start = 16.dp, end = 16.dp),
    )
}

@Composable
fun ArticleContent(content: String, modifier: Modifier = Modifier) {
    Text(text = content, textAlign = TextAlign.Justify, modifier = modifier.padding(16.dp))
}


@Composable
fun JetPackComposeArticle(modifier: Modifier = Modifier) {

    Column {
        ArticleBackground(
            background = painterResource(id = R.drawable.compose_background),
            description = null
        )
        ArticleTitle(title = stringResource(id = R.string.compose_tutorial_title))
        ArticleAbstract(abstract = stringResource(id = R.string.compose_tutorial_abstract))
        ArticleContent(content = stringResource(id = R.string.compose_tutorial_content))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        JetPackComposeArticle()
    }
}