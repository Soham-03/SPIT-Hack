package com.soham.spithack.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
//import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.People
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

data class DonationRecord(
    val id: Int,
    val donorName: String,
    val foodType: String,
    val quantity: String,
    val collectionDate: LocalDate,
    val collectionLocation: String,
    val distributionDate: LocalDate,
    val distributionLocation: String,
    val beneficiaries: Int,
    val status: DonationStatus
)

enum class DonationStatus {
    COMPLETED, IN_PROGRESS, SCHEDULED
}

@Composable
fun DonationHistoryScreen() {
    val primaryTeal = Color(0xFF3D8D89)
    val lightTeal = Color(0xFFE5F0F0)

    // Sample donation history data
    val donations = listOf(
        DonationRecord(
            1,
            "Raj Foods",
            "Fresh Produce",
            "50 kg",
            LocalDate.now(),
            "Andheri, Mumbai",
            LocalDate.now(),
            "Dharavi Community Center",
            100,
            DonationStatus.COMPLETED
        ),
        DonationRecord(
            2,
            "Hotel Sunshine",
            "Prepared Meals",
            "75 meals",
            LocalDate.now().minusDays(1),
            "Bandra, Mumbai",
            LocalDate.now().minusDays(1),
            "Mahim Shelter Home",
            75,
            DonationStatus.COMPLETED
        ),
        DonationRecord(
            3,
            "Fresh Mart",
            "Groceries",
            "30 kg",
            LocalDate.now().minusDays(2),
            "Powai, Mumbai",
            LocalDate.now().minusDays(2),
            "Govandi Food Bank",
            60,
            DonationStatus.COMPLETED
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "Donation History",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Total Impact: ${donations.sumOf { it.beneficiaries }} people served",
                fontSize = 14.sp,
                color = primaryTeal,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // Donation List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(donations) { donation ->
                DonationHistoryItem(
                    donation = donation,
                    primaryTeal = primaryTeal,
                    lightTeal = lightTeal
                )
            }
        }
    }
}

@Composable
fun DonationHistoryItem(
    donation: DonationRecord,
    primaryTeal: Color,
    lightTeal: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = lightTeal)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header with donor name and status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = donation.donorName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                StatusChip(status = donation.status)
            }

            // Food details
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = donation.foodType,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = " • ${donation.quantity}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }

            Divider(
                modifier = Modifier.padding(vertical = 12.dp),
                color = primaryTeal.copy(alpha = 0.1f)
            )

            // Collection details
            Row(
                modifier = Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = primaryTeal,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Collected from: ${donation.collectionLocation}",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Distribution details
            Row(
                modifier = Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = primaryTeal,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Distributed at: ${donation.distributionLocation}",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Impact details
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null,
                    tint = primaryTeal,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "${donation.beneficiaries} people served",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = primaryTeal,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun StatusChip(status: DonationStatus) {
    val (backgroundColor, textColor) = when (status) {
        DonationStatus.COMPLETED -> Color(0xFFE0F2F1) to Color(0xFF00897B)
        DonationStatus.IN_PROGRESS -> Color(0xFFFFF3E0) to Color(0xFFFF9800)
        DonationStatus.SCHEDULED -> Color(0xFFF3E5F5) to Color(0xFF9C27B0)
    }

    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = status.name,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}