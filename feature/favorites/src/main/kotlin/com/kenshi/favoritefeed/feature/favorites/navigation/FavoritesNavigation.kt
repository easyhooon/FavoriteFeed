package com.kenshi.favoritefeed.feature.favorites.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import com.kenshi.favoritefeed.feature.favorites.FavoritesRoute

const val FAVORITES_ROUTE = "favorites_route"

fun NavController.navigateToFavorites(navOptions: NavOptions) {
    navigate(FAVORITES_ROUTE, navOptions)
}

fun NavGraphBuilder.favoritesNavGraph(
    padding: PaddingValues,
    onShowSnackBar: (UserInfoEntity) -> Unit,
) {
    composable(route = FAVORITES_ROUTE) {
        FavoritesRoute(
            padding = padding,
            onShowSnackBar = onShowSnackBar,
        )
    }
}
