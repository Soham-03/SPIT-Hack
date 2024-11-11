package com.soham.spithack.navigation

import com.soham.spithack.R

sealed class NavItem(
    val title: String,
    val Icon: Int,
    val route:String,
    val selectedICon: Int
){
    object Home:NavItem("Home", R.drawable.house,"home", selectedICon = R.drawable.house)
    object Discover:NavItem("Leaderboard",R.drawable.podium,"discover", selectedICon = R.drawable.podium)
    object History:NavItem("History",R.drawable.history,"History", selectedICon = R.drawable.history)
    object Reward:NavItem("Reward",R.drawable.dashboard,"reward", selectedICon = R.drawable.dashboard)}
