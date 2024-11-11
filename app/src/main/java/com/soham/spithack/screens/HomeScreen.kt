//package com.soham.spithack.screens
//
//import android.content.Intent
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Slider
//import androidx.compose.material3.SliderDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableFloatStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.google.android.gms.maps.model.BitmapDescriptorFactory
//import com.google.android.gms.maps.model.CameraPosition
//import com.google.android.gms.maps.model.LatLng
//import com.google.maps.android.compose.GoogleMap
//import com.google.maps.android.compose.Marker
//import com.google.maps.android.compose.MarkerInfoWindow
//import com.google.maps.android.compose.MarkerState
//import com.google.maps.android.compose.rememberCameraPositionState
//import com.google.maps.android.compose.rememberMarkerState
//import com.soham.StreetViewActvity
//import com.soham.spithack.Donor
//import com.soham.spithack.R
//import com.soham.spithack.components.DonorHotelCard
//import com.soham.spithack.ui.theme.Blue
//import com.soham.spithack.ui.theme.darkBlue
//
//@Composable
//fun HomeScreen(){
//    var listOfColors = listOf(
//        Blue,
//        Color.White
//    )
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(brush = Brush.verticalGradient(
//                listOfColors,
//                startY = 0.0f,
//                endY = Float.POSITIVE_INFINITY
//            ))
//            .padding(12.dp)
//            .verticalScroll(rememberScrollState())
//    ){
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ){
//            Column(
//            ){
//                Text(
//                    text = "Feeding India NGO",
//                    color = Color.Black,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.SemiBold,
//
//                )
//                Text(
//                    text = "100+ Members",
//                    color = Color.Black,
//                    fontSize = 14.sp,
//                )
//            }
//
//
//            Image(
//                painter = painterResource(
//                    R.drawable.feed,
//                ),
//                contentScale = ContentScale.Crop,
//                contentDescription = "Image of hotel",
//                modifier = Modifier
//                    .size(54.dp)
//                    .clip(CircleShape)
//            )
//
//        }
//        Spacer(Modifier.height(18.dp))
//        Text(
//            text = "Hello, Soham!",
//            fontWeight = FontWeight.Bold,
//            fontSize = 28.sp
//        )
//        Text(
//            text = "There are 12 donors near",
//            fontWeight = FontWeight.Bold,
//            fontSize = 28.sp,
//            color = darkBlue
//        )
//        Text(
//            text = "your location",
//            fontWeight = FontWeight.Bold,
//            fontSize = 28.sp,
//            color = darkBlue
//        )
//        Spacer(Modifier.height(28.dp))
//        var sliderPosition by remember { mutableFloatStateOf(10f) }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ){
////            Text("10 Km ", fontSize = 12.sp, modifier = Modifier.weight(1f))
//            Slider(
//                value = sliderPosition,
//                onValueChange = { sliderPosition = it },
//                colors = SliderDefaults.colors(
//                    thumbColor = Color.White,
//                    activeTrackColor = darkBlue,
//                    inactiveTrackColor = Blue,
//                ),
//                steps = 5,
//                valueRange = 10f..40f,
//            )
////            Text("50 Km ", fontSize = 12.sp, modifier = Modifier.weight(1f))
//        }
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier
//                .fillMaxWidth()
//        ){
//            Text(
//                text = "Nearby Updates",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.SemiBold
//            )
//            Text(
//                text = "Within " + sliderPosition.toInt().toString() + " Kms",
//                color = darkBlue,
//                textDecoration = TextDecoration.Underline,
//                fontSize = 12.sp
//            )
//        }
//        //creating dummy donors
//        val listOfDonors = listOf<Donor>(
//            Donor(
//                "Aryan Caterers",
//                LatLng(19.123299205589248, 72.83612613058214),
//                "PavBhaji and Veg Thalis",
//                "100",
//                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/3c/c2/49/interiors-at-k-k.jpg?w=600&h=400&s=1",
//                "https://madhurasrecipe.com/wp-content/uploads/2023/06/10-Lokanchi-Bhaji-4.jpg"
//            ),
//
//        )
//        //cards
//        Spacer(Modifier.height(12.dp))
//        LazyRow(
//            modifier = Modifier
//                .fillMaxWidth()
//        ){
//            for(donor in listOfDonors){
//                item {
//                    DonorHotelCard(donor)
//                }
//            }
//        }
//
//        //
//        Spacer(Modifier.height(18.dp))
//        Text(
//            text = "Your Langars",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.SemiBold
//        )
//        Spacer(Modifier.height(12.dp))
//        val cameraPositionState = rememberCameraPositionState {
//            position = CameraPosition.fromLatLngZoom(listOfDonors[0].location, 10f)
//        }
//        GoogleMap(
//            modifier = Modifier.fillMaxWidth()
//                .height(500.dp)
//                .clip(RoundedCornerShape(18.dp)),
//            cameraPositionState = cameraPositionState
//        ) {
////            Marker(
////                state = singaporeMarkerState,
////                title = "Singapore",
////                snippet = "Marker in Singapore"
////            )
////            Marker(
////                state = singaporeMarkerState2,
////                title = "Singapore",
////                snippet = "Marker in Singapore"
////            )
//            val context = LocalContext.current
//            MarkerInfoWindow(
//                state = MarkerState(position = listOfDonors[0].location),
//                onInfoWindowClick = {
//                    val intent = Intent(context, StreetViewActvity::class.java)
//                    context.startActivity(intent)
//                },
////                icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_cargo_select)
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .border(
//                            BorderStroke(1.dp, Color.Black),
//                            RoundedCornerShape(10)
//                        )
//                        .clip(RoundedCornerShape(10))
//                        .background(Blue)
//                        .padding(20.dp)
//                        .clickable {
//                            val intent = Intent(context, StreetViewActvity::class.java)
//                            context.startActivity(intent)
//                        }
//                ) {
//                    Text("Bhavans Langar", fontWeight = FontWeight.Bold, color = Color.White)
//                    Text("Feeding 20 Children", fontWeight = FontWeight.Medium, color = Color.White)
//                }
//            }
//        }
//        Spacer(Modifier.height(150.dp))
//    }
//}

package com.soham.spithack.screens

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.soham.StreetViewActvity
import com.soham.spithack.Donor
import com.soham.spithack.R
import com.soham.spithack.components.DonorHotelCard
import com.soham.spithack.ui.theme.Blue
import com.soham.spithack.ui.theme.darkBlue

@Composable
fun HomeScreen() {
    var listOfColors = listOf(
        Blue,
        Color.White
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOfColors,
                    startY = 0.0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .padding(12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Feeding India NGO",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "100+ Members",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }

            Image(
                painter = painterResource(R.drawable.feed),
                contentScale = ContentScale.Crop,
                contentDescription = "Image of hotel",
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(Modifier.height(18.dp))
        Text(
            text = "Hello, Soham!",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Text(
            text = "There are 12 donors near",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = darkBlue
        )
        Text(
            text = "your location",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = darkBlue
        )

        Spacer(Modifier.height(28.dp))

        var sliderPosition by remember { mutableFloatStateOf(10f) }
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "${sliderPosition.toInt()} km",
                    color = darkBlue,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
                Text(
                    "40 km",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = darkBlue,
                    activeTrackColor = darkBlue,
                    inactiveTrackColor = Blue,
                ),
                valueRange = 10f..40f,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(48.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Nearby Updates",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Within ${sliderPosition.toInt()} Kms",
                color = darkBlue,
                textDecoration = TextDecoration.Underline,
                fontSize = 12.sp
            )
        }

        val listOfDonors = listOf(
            Donor(
                "Aryan Caterers",
                LatLng(19.123299205589248, 72.83612613058214),
                "PavBhaji and Veg Thalis",
                "100",
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/3c/c2/49/interiors-at-k-k.jpg?w=600&h=400&s=1",
                "https://madhurasrecipe.com/wp-content/uploads/2023/06/10-Lokanchi-Bhaji-4.jpg"
            ),
            Donor(
                "Mumbai Kitchen",
                LatLng(19.129842, 72.841521),
                "Rice and Dal Meals",
                "150",
                "https://media-cdn.tripadvisor.com/media/photo-s/15/a5/b8/cf/hotel-mumbai-kitchen.jpg",
                "https://static.toiimg.com/thumb/53338316.cms?width=1200&height=900"
            ),
            Donor(
                "Sai Prasad Foods",
                LatLng(19.115632, 72.828901),
                "South Indian Meals",
                "75",
                "https://content.jdmagicbox.com/comp/mumbai/b3/022pxx22.xx22.220521114840.q5b3/catalogue/sai-prasad-pure-veg-restaurant-kalyan-west-mumbai-pure-veg-restaurants-0gzrwlyhxx.jpg",
                "https://img.freepik.com/premium-photo/south-indian-meals-served-banana-leaf_527904-1074.jpg"
            ),
            Donor(
                "Gurukripa Langar",
                LatLng(19.132456, 72.845678),
                "Traditional Thali",
                "200",
                "https://content3.jdmagicbox.com/comp/mumbai/w5/022pxx22.xx22.180521132450.z8w5/catalogue/gurukripa-pure-veg-restaurant-mulund-west-mumbai-restaurants-0xwpw.jpg",
                "https://im.hunt.in/cg/City-Guide/thali.JPG"
            )
        )

        Spacer(Modifier.height(12.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(listOfDonors.size) { index ->
                DonorHotelCard(listOfDonors[index])
                Spacer(Modifier.width(12.dp))
            }
        }

        Spacer(Modifier.height(18.dp))
        Text(
            text = "Your Langars",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(12.dp))

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(listOfDonors[0].location, 12f)
        }

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(18.dp)),
            cameraPositionState = cameraPositionState
        ) {
            val context = LocalContext.current

            listOfDonors.forEach { donor ->
                MarkerInfoWindow(
                    state = MarkerState(position = donor.location),
                    onInfoWindowClick = {
                        val intent = Intent(context, StreetViewActvity::class.java)
                        intent.putExtra("lat", donor.location.latitude)
                        intent.putExtra("lng", donor.location.longitude)
                        context.startActivity(intent)
                    }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .border(
                                BorderStroke(1.dp, Color.Black),
                                RoundedCornerShape(10)
                            )
                            .clip(RoundedCornerShape(10))
                            .background(Blue)
                            .padding(20.dp)
                            .clickable {
                                val intent = Intent(context, StreetViewActvity::class.java)
                                intent.putExtra("lat", donor.location.latitude)
                                intent.putExtra("lng", donor.location.longitude)
                                context.startActivity(intent)
                            }
                    ) {
                        Text(
                            donor.name,
                            fontWeight = FontWeight.Bold,
                            color = darkBlue
                        )
                        Text(
                            "Feeding ${donor.quantity} people",
                            fontWeight = FontWeight.Medium,
                            color = Color.Black.copy(alpha = 0.7f)
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(150.dp))
    }
}