package com.soham.spithack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Volunteer(
    val name: String,
    val donationsCount: Int,
    val location: String
)

@Composable
fun VolunteerLeaderboard() {
    val primaryTeal = Color(0xFF3D8D89)
    val lightTeal = Color(0xFFE5F0F0)

    val volunteers = listOf(
        Volunteer("Aarav Sharma", 284, "Mumbai"),
        Volunteer("Priya Patel", 256, "Delhi"),
        Volunteer("Arjun Kumar", 248, "Bangalore"),
        Volunteer("Zara Khan", 235, "Chennai"),
        Volunteer("Advait Mehta", 227, "Pune"),
        Volunteer("Riya Desai", 215, "Hyderabad"),
        Volunteer("Vihaan Singh", 203, "Kolkata"),
        Volunteer("Ananya Reddy", 198, "Ahmedabad"),
        Volunteer("Dev Malhotra", 188, "Jaipur"),
        Volunteer("Ishaan Verma", 176, "Lucknow"),
        Volunteer("Mira Kapoor", 164, "Chandigarh"),
        Volunteer("Kabir Joshi", 162, "Indore"),
        Volunteer("Aisha Gupta", 160, "Bhopal"),
        Volunteer("Vivaan Sinha", 157, "Nagpur"),
        Volunteer("Diya Shah", 155, "Surat"),
        Volunteer("Rohan Trivedi", 153, "Vadodara"),
        Volunteer("Neha Menon", 149, "Cochin"),
        Volunteer("Aryan Khanna", 147, "Vizag"),
        Volunteer("Sara Ahmed", 145, "Patna"),
        Volunteer("Arnav Bose", 142, "Ranchi")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Header with total impact
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "Top Volunteers",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Total Donations: ${volunteers.sumOf { it.donationsCount }.toString()} meals shared",
                fontSize = 14.sp,
                color = primaryTeal,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(volunteers.sortedByDescending { it.donationsCount }) { volunteer ->
                VolunteerLeaderboardItem(
                    volunteer = volunteer,
                    rank = volunteers.sortedByDescending { it.donationsCount }.indexOf(volunteer) + 1,
                    primaryTeal = primaryTeal,
                    lightTeal = lightTeal
                )
            }
        }
    }
}

@Composable
fun VolunteerLeaderboardItem(
    volunteer: Volunteer,
    rank: Int,
    primaryTeal: Color,
    lightTeal: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (rank) {
                1 -> Color(0xFFFFF7E6) // Gold tint for #1
                2 -> Color(0xFFF5F5F5) // Silver tint for #2
                3 -> Color(0xFFFFF1E6) // Bronze tint for #3
                else -> lightTeal
            }
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Rank Circle with different colors for top 3
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        when (rank) {
                            1 -> Color(0xFFFFB800) // Gold
                            2 -> Color(0xFFC0C0C0) // Silver
                            3 -> Color(0xFFCD7F32) // Bronze
                            else -> primaryTeal
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "#$rank",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            // Volunteer Info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = volunteer.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = volunteer.location,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Donations Count
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${volunteer.donationsCount}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryTeal
                )
                Text(
                    text = "donations",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}