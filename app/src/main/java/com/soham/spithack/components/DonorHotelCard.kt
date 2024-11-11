package com.soham.spithack.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.soham.spithack.Donor
import com.soham.spithack.Global
import com.soham.spithack.R
import com.soham.spithack.SelectHotelActivity
import com.soham.spithack.screens.SelectHotelScreen
import com.soham.spithack.ui.theme.darkBlue

@Composable
fun DonorHotelCard(donor: Donor){
    val context = LocalContext.current
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clickable {
                val intent = Intent(context, SelectHotelActivity::class.java)
                Global.donor = donor
                context.startActivity(intent)
            }
    ){
        Column(
            modifier = Modifier
                .width(300.dp)
        ){
            Box(){
                Image(
                    painter = rememberAsyncImagePainter(donor.foodImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .size(height = 160.dp, width = 300.dp),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = rememberAsyncImagePainter(donor.donorImage),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                    ){
                        Text(text = donor.name, fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                        Text(text = "Andheri, Mumbai", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Light)
                    }
                }
            }
            //texttt
            Spacer(Modifier.height(8.dp))
            Text(
                text = donor.items,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Outlined.DateRange, "", tint = Color.Gray, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Today 3:00 PM", fontSize = 10.sp, color = Color.Gray)

                }
                Spacer(Modifier.width(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Outlined.LocationOn, "", tint = Color.Gray, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("12 Kms", fontSize = 10.sp, color = Color.Gray)

                }
                Text(
                    text = "${donor.quantity} Fed",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = darkBlue
                )

            }
        }
    }
}
