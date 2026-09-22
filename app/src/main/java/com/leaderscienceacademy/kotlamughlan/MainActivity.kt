package com.leaderscienceacademy.kotlamughlan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AcademyApp()
                }
            }
        }
    }
}

@Composable
fun AcademyApp() {

    var role by remember { mutableStateOf("Admin") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        item {
            Text(
                text = "The Leader Science Academy",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF304FFE)
            )

            Text(
                text = "Kotla Mughlan",
                fontSize = 18.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Welcome 👋",
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$role Dashboard",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf("Admin", "Teacher", "Parent").forEach {
                            if (role == it) {
                                Button(onClick = { role = it }) {
                                    Text(it)
                                }
                            } else {
                                OutlinedButton(onClick = { role = it }) {
                                    Text(it)
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text(
                text = "Academy Overview",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            OverviewCard("👨‍🎓 Students", "250")
            OverviewCard("👨‍🏫 Teachers", "18")
            OverviewCard("💰 Fees Collected", "85%")
            OverviewCard("📅 Attendance", "92%")
            OverviewCard("📊 Performance", "88%")
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Academy Management",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            ActionCard("👨‍🎓 Student Management")
            ActionCard("💰 Fee Management")
            ActionCard("📅 Attendance")
            ActionCard("📝 Tests & Marks")
            ActionCard("📊 Results & Performance")
            ActionCard("📢 Announcements")
            ActionCard("🏆 Achievements")
            ActionCard("⚙️ Academy Settings")
        }
    }
}

@Composable
fun OverviewCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ActionCard(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(18.dp),
            fontSize = 17.sp
        )
    }
}
