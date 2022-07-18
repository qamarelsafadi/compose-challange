/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.IconSizeMedium
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.backgroundColor
import com.example.androiddevchallenge.ui.theme.primaryColor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = backgroundColor) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.offset(y = (-50).dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bg_art),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.padding(top = 16.dp),
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "",
                )

            }

            BodySection()

            Box(
                modifier = Modifier.offset(y = (50).dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.rotate(180f),
                    painter = painterResource(id = R.drawable.ic_bg_art),
                    contentDescription = null
                )

                Text(modifier = Modifier.clickable { },
                    text = "I am new here, i need an account",
                    color = primaryColor)
            }
        }
    }
}

@Composable
fun BodySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign in",
            color = primaryColor,
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))

        Spacer(modifier = Modifier.height(30.dp))
        NameTextField()

        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField()

        Spacer(modifier = Modifier.height(30.dp))
        SignInButton()
    }
}

@Composable
fun NameTextField() {
    var name by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .clip(CircleShape)
            .border(color = Color.Gray.copy(alpha = 0.5f), width = 2.dp, shape = CircleShape)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier.size(IconSizeMedium)
            )
        },
        maxLines = 1,
        value = name,
        onValueChange = {
            name = it
        },
    )
}


@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .clip(CircleShape)
            .border(color = Color.Gray.copy(alpha = 0.5f), width = 2.dp, shape = CircleShape)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier.size(IconSizeMedium)
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        maxLines = 1,
        value = password,
        onValueChange = {
            password = it
        },
    )
}


@Composable
fun SignInButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
        onClick = {

        }
    ) {
        Icon(Icons.Default.Send, tint = Color.White, contentDescription = null)
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}
/*
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}*/
