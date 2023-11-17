package com.discordtime.whatudoing

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.discordtime.whatudoing.ui.theme.WhatudoingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatudoingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF00D7AD)
                ) {
                    val viewModel = viewModel<MainViewModel>()
                    val stateFromViewModel by viewModel.state.collectAsStateWithLifecycle()
                    var state by rememberSaveable {
                        mutableStateOf(true)
                    }
                    Column(
                        Modifier.padding(26.dp, 36.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Logo()
                        Row(
                            modifier = Modifier
                                .padding(top = 50.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = stateFromViewModel.name)
                            Text(text = stateFromViewModel.age.toString())
                            Text(text = stateFromViewModel.motherName)
                        }
                        Button(
                            modifier = Modifier.padding(top = 50.dp),
                            onClick = {
                                state = !state
                                viewModel.setState(StateUI("Jovi", 35, "Nathalia"))
                                Toast.makeText(
                                    applicationContext, "Will",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                            if (state) {
                                Text(text = "Test")
                            } else {
                                Text("outro texto")
                            }

                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatudoingTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF00D7AD)
        ) {
            Column(
                Modifier.padding(26.dp, 36.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Logo()
                Button(
                    modifier = Modifier.padding(top = 50.dp),
                    onClick = {}) {
                    Text(text = "Test")

                }
            }

        }
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        modifier = modifier
    )
}