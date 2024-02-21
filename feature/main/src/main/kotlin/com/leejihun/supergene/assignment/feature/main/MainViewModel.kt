package com.leejihun.supergene.assignment.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leejihun.supergene.assignment.domain.RandomUserRepository
import com.leejihun.supergene.assignment.domain.entity.UserInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RandomUserRepository,
) : ViewModel() {
    fun insertFavoritesUser(userInfo: UserInfoEntity) {
        viewModelScope.launch {
            repository.insertFavoritesUser(userInfo.copy(isLiked = true))
        }
    }
}
