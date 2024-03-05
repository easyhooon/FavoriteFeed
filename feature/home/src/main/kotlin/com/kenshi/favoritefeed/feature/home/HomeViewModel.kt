package com.kenshi.favoritefeed.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.kenshi.favoritefeed.domain.RandomUserRepository
import com.kenshi.favoritefeed.domain.entity.UserInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RandomUserRepository,
) : ViewModel() {
    private val favoritesUserList = repository.getFavoritesUserList()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val randomUserList = repository.getUserList()
        .cachedIn(viewModelScope)
        .combine(favoritesUserList) { pagingData, favoritesUsers ->
            pagingData.map { userInfo ->
                userInfo.copy(isLiked = favoritesUsers.find { it.email == userInfo.email } != null)
            }
        }

    fun insertFavoritesUser(userInfo: UserInfoEntity) {
        viewModelScope.launch {
            repository.insertFavoritesUser(userInfo.copy(isLiked = true))
        }
    }

    fun deleteFavoritesUser(userInfo: UserInfoEntity) {
        viewModelScope.launch {
            repository.deleteFavoritesUser(userInfo)
        }
    }
}
