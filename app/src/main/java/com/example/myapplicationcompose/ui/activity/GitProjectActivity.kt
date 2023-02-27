package com.example.myapplicationcompose.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationcompose.ui.screen.TopBar
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import com.example.myapplicationcompose.util.toTime
import com.example.myapplicationcompose.viewmodel.GitProjectViewModel

class GitProjectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val name by rememberSaveable {
                mutableStateOf(intent.getStringExtra("name") ?: "")
            }
            MyApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Column() {
                    TopBar(title = name, onBack = { finish() })
                    Content(name)
                }
            }
        }
    }
}


@Composable
fun Content(pName:String, viewModel: GitProjectViewModel = viewModel()) {

    val commits by viewModel.commit.collectAsState()

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.getCommits(pName)
    })

    LazyColumn(modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)){
        items(commits){
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(5.dp))
                .shadow(1.dp)
            ) {
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(text = it.commit.message, textDecoration = null)
                    Row {
                        Text(text = "${it.commit.committer.name} ： ", fontSize = 13.sp, color = Color.Gray)
                        Text(text = it.commit.committer.email, fontSize = 13.sp, color = Color.Gray)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        Text(text = it.commit.committer.date.toTime(), fontSize = 13.sp, color = Color.Gray)
                    }
                }
            }
        }
    }

}