package com.soham.spithack.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.android.gms.maps.model.ButtCap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.soham.spithack.CollectAndDeliverMapActivity
import com.soham.spithack.Donor
import com.soham.spithack.R
import com.soham.spithack.ui.theme.Blue
import com.soham.spithack.ui.theme.darkBlue
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun SelectHotelScreen(donor: Donor){
    val latLng1 = donor.location
    val latLng2 = LatLng(19.044515513389126, 72.82038123153215)
    val context = LocalContext.current
    var listOfColors = listOf(
        Blue,
        Color.White
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                listOfColors,
                startY = 0.0f,
                endY = Float.POSITIVE_INFINITY
            ))
            .padding(12.dp)
    ){
        Text(
            text = "Pick Up order",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Text(
            text = "at "+donor.name,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = darkBlue
        )
        Text(
            text = "Andheri, Mumbai",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(Modifier.height(12.dp))
        Row(){
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFE9EDF1)),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    Icons.Filled.LocationOn,
                    "",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .padding(4.dp)
                )
                Text(calculateDistance(latLng1, latLng2).toFloat().toString()+" KMs", fontSize = 12.sp, color = Color.DarkGray)
                Spacer(Modifier.width(4.dp))
            }
            Spacer(Modifier.width(20.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFE9EDF1)),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    Icons.Filled.DateRange,
                    "",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .padding(4.dp)
                )
                Text("Today 3:00 PM - 5:00 PM", fontSize = 12.sp, color = Color.DarkGray)
                Spacer(Modifier.width(4.dp))
            }
        }
        Spacer(Modifier.height(12.dp))
        ShowMap(donor.location)
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Donation",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        //item1
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = rememberAsyncImagePainter(donor.foodImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .width(54.dp)
                        .height(54.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                ){
                    Text(
                        text = "Pav Bhaji",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                    )
                    Text(
                        text = "Made today morning",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                    )
                }
            }

            Text(
                text = "110 Plates",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = darkBlue
            )
        }
        //item2
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = rememberAsyncImagePainter("https://imgmedia.lbb.in/media/2023/03/6411b941fa27e75aedfac9eb_1678883137224.jpg"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .width(54.dp)
                        .height(54.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                ){
                    Text(
                        text = "Veg Thali",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                    )
                    Text(
                        text = "Made today afternoon",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                    )
                }
            }

            Text(
                text = "30 Plates",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = darkBlue
            )
        }
        Text(
            text = "Make",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color(0xFFE9EDF1)
        )
        Text(
            text = "A",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color(0xFFE9EDF1)
        )
        Text(
            text = "Difference",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = darkBlue
        )

        Button(
            onClick = {
                val intent = Intent(context, CollectAndDeliverMapActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = darkBlue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Accept Collect & Deliver",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            )
        }
        
    }
}

fun calculateDistance(point1: LatLng, point2: LatLng): Double {
    val earthRadius = 6371.0 // Earth's radius in kilometers

    val lat1 = point1.latitude * PI / 180
    val lat2 = point2.latitude * PI / 180
    val deltaLat = (point2.latitude - point1.latitude) * PI / 180
    val deltaLng = (point2.longitude - point1.longitude) * PI / 180

    val a = sin(deltaLat / 2) * sin(deltaLat / 2) +
            cos(lat1) * cos(lat2) *
            sin(deltaLng / 2) * sin(deltaLng / 2)

    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return (earthRadius * c * 100).roundToInt() / 100.0 // Returns distance in kilometers
}

@Composable
fun ShowMap(donorLocation: LatLng){
    val Frcrce = LatLng(19.044515513389126, 72.82038123153215)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(Frcrce, 15f)
    }

    var uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }

    val routeCoordinates = listOf(
        Frcrce, // Starting point
        donorLocation // Ending point
    )

    GoogleMap(
        modifier = Modifier.height(200.dp)
            .clip(RoundedCornerShape(20.dp)),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
    ) {
        Polyline(
            points = routeCoordinates,
            clickable = true,
            color = darkBlue,
            width = 10f,
            jointType = JointType.BEVEL,
            endCap = ButtCap()
        )
    }
}

@Preview
@Composable
fun Previewgg(){
//    SelectHotelScreen()

}