package com.leejihun.supergene.assignment.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.leejihun.supergene.assignment.domain.RandomUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: RandomUserRepository
) : ViewModel() {
    val randomUserList = repository.getUserList().cachedIn(viewModelScope)
}
