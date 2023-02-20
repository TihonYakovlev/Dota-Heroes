package com.tihonyakovlev.dotaheroes.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams
import com.tihonyakovlev.dotaheroes.domain.repository.DotaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@JvmInline
value class DetailsScreenState(val heroParameters: HeroParams? = null)

class DetailsViewModel (
    private val dotaRepos: DotaRepository,
    id: Int
) : ViewModel() {

    private val _detailsState = MutableStateFlow(DetailsScreenState())
    val detailsState: StateFlow<DetailsScreenState>
        get() = _detailsState.asStateFlow()

    init {
        viewModelScope.launch {
            _detailsState.update {
                DetailsScreenState(dotaRepos.getParams(id = id))
            }
        }
    }
}