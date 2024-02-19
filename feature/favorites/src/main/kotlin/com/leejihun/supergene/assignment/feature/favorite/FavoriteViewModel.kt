package com.leejihun.supergene.assignment.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.leejihun.supergene.assignment.domain.RandomUserRepository
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: RandomUserRepository,
) : ViewModel() {
    val favoritesUserList = repository.getFavoritesUserList().cachedIn(viewModelScope)

    fun insertFavoritesUser(userInfo: UserInfoEntity) {
        viewModelScope.launch {
            repository.insertFavoritesUser(userInfo)
        }
    }

    fun deleteFavoritesUser(userInfo: UserInfoEntity) {
        viewModelScope.launch {
            repository.deleteFavoritesUser(userInfo)
        }
    }
}
