package com.tihonyakovlev.dotaheroes.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tihonyakovlev.dotaheroes.data.repository.DotaHeroInfo
import com.tihonyakovlev.dotaheroes.domain.repository.DotaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


/* var checkedByComp1 by remember {
        mutableStateOf(false)
    }
    var checkedByComp2 by remember {
        mutableStateOf(false)
    }
    var checkedByComp3 by remember {
        mutableStateOf(false)
    }
    val selectedCheckBoxes by remember(checkedByComp1, checkedByComp2, checkedByComp3) {
    mutableStateOf(
        listOf(
            checkedByComp1,
            checkedByComp2,
            checkedByComp3
        ).mapIndexedNotNull { index, b -> if (b) index + 1 else null })
}

val heroes by remember {
    derivedStateOf {
        mainState.filter {
            it.complexity in selectedCheckBoxes
        }
    }
}*/

@JvmInline
value class MainScreenState(val heroes: List<DotaHeroInfo> = emptyList())

class MainViewModel (
    private val dotaRepos: DotaRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainScreenState())
    val mainState: StateFlow<MainScreenState>
        get() = _mainState.asStateFlow()

    init {
        viewModelScope.launch {
            _mainState.update {
                MainScreenState(dotaRepos.getHeroes())
            }
        }
    }
}
