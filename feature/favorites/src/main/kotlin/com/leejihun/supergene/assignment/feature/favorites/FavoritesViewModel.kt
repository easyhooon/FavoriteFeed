package com.leejihun.supergene.assignment.feature.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leejihun.supergene.assignment.domain.RandomUserRepository
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: RandomUserRepository,
) : ViewModel() {
    // val favoritesUserList = repository.getFavoritesUserList().cachedIn(viewModelScope)
    val favoritesUserList = repository.getFavoritesUserList()

    fun deleteFavoritesUser(userInfo: UserInfoEntity) {
        viewModelScope.launch {
            repository.deleteFavoritesUser(userInfo)
        }
    }
}
