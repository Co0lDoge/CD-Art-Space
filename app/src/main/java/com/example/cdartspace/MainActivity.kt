package com.example.cdartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cdartspace.ui.theme.CDArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CDArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("CoolDoge's Art Space")
                }
            )
        },
    ) { innerPadding ->
        Surface(
            modifier = modifier.padding(innerPadding)
        ) {
            ArtSpaceScreen()
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // This spacer is used to push image to center
        Spacer(modifier = modifier)

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )

        // Bottom part of the column
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Artwork Title",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Artwork Artist"
            )

            Row(modifier = modifier.padding(bottom = 16.dp)) {
                Button(onClick = { /*TODO*/ }, modifier.weight(1f)) {
                    Text(text = "Previous")
                }
                Button(onClick = { /*TODO*/ }, modifier.weight(1f)) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    CDArtSpaceTheme {
        ArtSpaceApp()
    }
}