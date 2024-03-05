package com.kenshi.favoritefeed.feature.main

import com.kenshi.favoritefeed.core.designsystem.R

internal enum class MainTab(
    val iconResId: Int,
    val selectedIconResId: Int,
    val contentDescription: String,
    val route: String,
) {
    HOME(
        iconResId = R.drawable.ic_home,
        selectedIconResId = R.drawable.ic_home_filled,
        contentDescription = "홈",
        route = "home_route",
    ),
    FAVORITE(
        iconResId = R.drawable.ic_favorite_outlined_black,
        selectedIconResId = R.drawable.ic_favorite_filled_black,
        contentDescription = "즐겨찾기",
        route = "favorites_route",
    ),
    ;

    companion object {
        operator fun contains(route: String): Boolean {
            return entries.map { it.route }.contains(route)
        }

        fun find(route: String): MainTab? {
            return entries.find { it.route == route }
        }
    }
}
