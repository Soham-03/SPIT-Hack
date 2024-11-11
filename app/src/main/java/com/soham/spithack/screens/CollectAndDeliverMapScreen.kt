//package com.soham.spithack.screens
//
//import android.content.Intent
//import android.net.Uri
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.core.content.ContextCompat.startActivity
//import com.google.android.gms.maps.model.ButtCap
//import com.google.android.gms.maps.model.CameraPosition
//import com.google.android.gms.maps.model.JointType
//import com.google.android.gms.maps.model.LatLng
//import com.google.maps.android.compose.GoogleMap
//import com.google.maps.android.compose.MapProperties
//import com.google.maps.android.compose.MapType
//import com.google.maps.android.compose.MapUiSettings
//import com.google.maps.android.compose.Marker
//import com.google.maps.android.compose.Polyline
//import com.google.maps.android.compose.rememberCameraPositionState
//import com.google.maps.android.compose.rememberMarkerState
//import com.soham.spithack.ui.theme.Blue
//import com.soham.spithack.ui.theme.darkBlue
//import kotlin.random.Random
//
//
//@Composable
//fun CollectAndDeliverMapScreen(){
//    val context = LocalContext.current
//    var listOfColors = listOf(
//        Blue,
//        Color.White
//    )
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(brush = Brush.verticalGradient(
//                listOfColors,
//                startY = 0.0f,
//                endY = Float.POSITIVE_INFINITY
//            ))
//            .padding(12.dp)
//    ){
//        Column(
//            modifier = Modifier
//                .weight(1.5f)
//        )
//        {
//            Text(
//                text = "Optimized",
//                fontWeight = FontWeight.Bold,
//                fontSize = 28.sp
//            )
//            Text(
//                text = "Delivery Route",
//                fontWeight = FontWeight.Bold,
//                fontSize = 28.sp,
//                color = darkBlue
//            )
//        }
//
//        Spacer(Modifier.height(12.dp))
//        Box(
//            modifier = Modifier
//                .weight(12f)
//        ){
//            ShowMapPloyLine()
//        }
//
//        Spacer(Modifier.height(12.dp))
//        Button(
//            onClick = {
//                val uri =
//                    "http://maps.google.com/maps?daddr=19.223217,73.157940" + "+to:19.229584206084226,73.1593526332295+to:19.227259258763144,73.15558520409336+to:19.230678733045064,73.1538689787762+to:19.229551304155827,73.1501968079793"
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                intent.setClassName(
//                    "com.google.android.apps.maps",
//                    "com.google.android.maps.MapsActivity"
//                )
//                if (intent.resolveActivity(context.packageManager) != null) {
//                    context.startActivity(intent)
//                }
//            },
//            colors = ButtonDefaults.buttonColors(
//                containerColor = darkBlue,
//                contentColor = Color.White
//            ),
//            shape = RoundedCornerShape(40.dp),
//            modifier = Modifier
//                .padding(horizontal = 12.dp)
//                .fillMaxWidth()
//                .weight(1f)
//        ) {
//            Text(
//                "Start Navigation",
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 14.sp,
//            )
//        }
//    }
//}
//
//@Composable
//fun ShowMapPloyLine(){
//    val atasehir = LatLng(40.9971, 29.1007)
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(atasehir, 10f)
//    }
//
//    var uiSettings by remember {
//        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
//    }
//    var properties by remember {
//        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
//    }
//
//    val routeCoordinates = listOf(
//        LatLng(40.9967,29.0570), // Starting point
//        LatLng(40.9900,30.0570), // Waypoint 1
//        LatLng(41.0322,29.0216), // Waypoint 2
//        LatLng(41.0333,29.0910)  // Ending point
//    )
//
//    GoogleMap(
//        modifier = Modifier
//            .fillMaxSize()
//            .clip(RoundedCornerShape(20.dp)),
//        cameraPositionState = cameraPositionState,
//        properties = properties,
//        uiSettings = uiSettings
//    ) {
//        for(mark in routeCoordinates){
//            Marker(
//                state = rememberMarkerState(position = mark),
//                title = "Langar",
//                snippet = Random.nextInt(100).toString(),
//            )
//        }
//        Polyline(
//            points = routeCoordinates,
//            clickable = true,
//            color = darkBlue,
//            width = 5f,
//            jointType = JointType.BEVEL,
//            endCap = ButtCap()
//        )
//    }
//}

package com.soham.spithack.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.ButtCap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.soham.spithack.ui.theme.Blue
import com.soham.spithack.ui.theme.darkBlue
import kotlin.random.Random

@Composable
fun CollectAndDeliverMapScreen() {
    val context = LocalContext.current
    var listOfColors = listOf(
        Blue,
        Color.White
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOfColors,
                    startY = 0.0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1.5f)
        ) {
            Text(
                text = "Optimized",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Text(
                text = "Delivery Route",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = darkBlue
            )
        }

        Spacer(Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .weight(12f)
        ) {
            ShowMapPloyLine()
        }

        Spacer(Modifier.height(12.dp))
        Button(
            onClick = {
                // Updated coordinates for Mumbai regions
                val uri = "http://maps.google.com/maps?daddr=19.2183,72.9780" + // Thane
                        "+to:19.0330,73.0297" + // Navi Mumbai
                        "+to:19.0760,72.8777" + // Mumbai Central
                        "+to:19.1136,72.8697" + // Bandra
                        "+to:19.1759,72.9484"   // Powai
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setClassName(
                    "com.google.android.apps.maps",
                    "com.google.android.maps.MapsActivity"
                )
                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = darkBlue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                "Start Navigation",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun ShowMapPloyLine() {
    // Center the map on Greater Mumbai region
    val mumbaiBombay = LatLng(19.0760, 72.8777)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(mumbaiBombay, 11f)
    }

    var uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }

    // Updated coordinates for regions around Mumbai
    val routeCoordinates = listOf(
        LatLng(19.2183, 72.9780), // Thane
        LatLng(19.0330, 73.0297), // Navi Mumbai
        LatLng(19.0760, 72.8777), // Mumbai Central
        LatLng(19.1136, 72.8697), // Bandra
        LatLng(19.1759, 72.9484)  // Powai
    )

    GoogleMap(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp)),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
    ) {
        for (mark in routeCoordinates) {
            Marker(
                state = rememberMarkerState(position = mark),
                title = when(mark) {
                    routeCoordinates[0] -> "Thane"
                    routeCoordinates[1] -> "Navi Mumbai"
                    routeCoordinates[2] -> "Mumbai Central"
                    routeCoordinates[3] -> "Bandra"
                    routeCoordinates[4] -> "Powai"
                    else -> "Location"
                },
                snippet = "Stop ${Random.nextInt(100)}"
            )
        }
        Polyline(
            points = routeCoordinates,
            clickable = true,
            color = darkBlue,
            width = 5f,
            jointType = JointType.BEVEL,
            endCap = ButtCap()
        )
    }
}