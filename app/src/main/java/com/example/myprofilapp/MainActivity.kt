package com.example.myprofilapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilapp.ui.theme.MyProfilAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyProfilAppTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileHeader()

        Spacer(modifier = Modifier.height(20.dp))

        ProfileCard()

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Edit Profile")
        }
    }
}

@Composable
fun ProfileHeader() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",

                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Exaudi Amin Hutasoit",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Mahasiswa Informatika ITERA",
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProfileCard() {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            InfoItem("Email", "exaudi.123140161@student.itera.ac.id")

            InfoItem("Phone", "0895323566599")

            InfoItem("Location", "Lampung")
        }
    }
}

@Composable
fun InfoItem(label: String, value: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            label,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            modifier = Modifier.weight(2f))
    }
}