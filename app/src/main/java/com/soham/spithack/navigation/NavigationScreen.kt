package com.soham.spithack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.soham.spithack.screens.DonationHistoryScreen
import com.soham.spithack.screens.HomeScreen
import com.soham.spithack.screens.VolunteerLeaderboard

@Composable
fun NavigationScreen(modifier: Modifier, navController: NavHostController){
    NavHost(navController = navController, startDestination = NavItem.Home.route) {
        composable(NavItem.Home.route) { HomeScreen() }
        composable(NavItem.Discover.route) { VolunteerLeaderboard() }
        composable(NavItem.History.route) { DonationHistoryScreen() }
        composable(NavItem.Reward.route) { HomeScreen() }
    }
}