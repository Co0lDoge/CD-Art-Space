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
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cdartspace.data.ImageData
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
    var currentImageNum by remember { mutableIntStateOf(0) }
    val imageSet = ImageData.getImagesData()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        // This spacer is used to push image to center
        Spacer(modifier = modifier)

        Card(
            modifier
                .shadow(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageSet[currentImageNum].imageRes),
                contentDescription = null,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        top = 32.dp,
                        bottom = 32.dp,
                        start = 8.dp,
                        end = 8.dp
                    )
            )
        }

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

            Row(
                modifier
                    .padding(bottom = 16.dp)
                    .padding(top = 16.dp)
            ) {
                Button(
                    onClick = { currentImageNum = onPreviousClick(currentImageNum, imageSet) },
                    modifier.weight(1f)
                ) {
                    Text(text = "Previous")
                }

                Spacer(modifier.weight(0.5f))

                Button(
                    onClick = { currentImageNum = onNextClick(currentImageNum, imageSet) },
                    modifier.weight(1f)
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

private fun onNextClick(currentImageNum: Int, imageSet: List<ImageData>): Int {
    var newValue = currentImageNum
    return if (currentImageNum < imageSet.size-1)
        ++newValue
    else
        newValue
}

private fun onPreviousClick(currentImageNum: Int, imageSet: List<ImageData>): Int {
    var newValue = currentImageNum
    return if (currentImageNum > 0)
        --newValue
    else
        newValue
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    CDArtSpaceTheme {
        ArtSpaceApp()
    }
}