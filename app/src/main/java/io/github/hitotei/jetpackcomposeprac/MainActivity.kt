package io.github.hitotei.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hitotei.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.padding(all = 3.dp)
                ) {
                    Column {
                        Greeting("Android")
                        ReplyList(
                            replyList = listOf(
                                Pair("Tanaka", "Hello ;)"),
                                Pair("Sato", "Hellooooo"),
                                Pair("Hayashi", "hi"),
                                Pair("Kobayashi", "(≧▽≦)"),
                                Pair("Mori", "HELLO"),
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "$name : Hello",
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun Reply(name: String, content: String) {
    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = content,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun ReplyList(replyList: List<Pair<String, String>>) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 5.dp)
    ){
        items(replyList) { reply ->
            Reply(name = reply.first, content = reply.second)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePracTheme {
        Greeting("Android")
    }
}