package com.leejihun.supergene.assignment.feature.favorite.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.leejihun.supergene.assignment.feature.favorite.FavoriteRoute

const val FAVORITES_ROUTE = "favorites_route"

fun NavController.navigateToFavorites(navOptions: NavOptions) {
    navigate(FAVORITES_ROUTE, navOptions)
}

fun NavGraphBuilder.favoriteNavGraph(
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    composable(route = FAVORITES_ROUTE) {
        FavoriteRoute(
            padding = padding,
            onShowErrorSnackBar = onShowErrorSnackBar,
        )
    }
}
