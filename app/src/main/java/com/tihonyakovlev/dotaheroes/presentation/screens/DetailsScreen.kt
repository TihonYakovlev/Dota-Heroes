package com.tihonyakovlev.dotaheroes.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.tihonyakovlev.dotaheroes.data.repository.params.HeroParams
import com.tihonyakovlev.dotaheroes.presentation.darkMode
import com.tihonyakovlev.dotaheroes.presentation.screens.destinations.HeroesListScreenDestination
import com.tihonyakovlev.dotaheroes.presentation.viewmodels.DetailsViewModel
import com.tihonyakovlev.dotaheroes.ui.theme.Purple500
import com.tihonyakovlev.dotaheroes.ui.theme.Purple700
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Destination
@Composable
fun HeroesDetailsScreen(
    navigator: DestinationsNavigator,
    id: Int,
    detailsViewModel: DetailsViewModel = getViewModel { parametersOf(id) }
) {
    val detailState by detailsViewModel.detailsState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Информация о герое",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.navigate(HeroesListScreenDestination) }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                backgroundColor = Color.Magenta,
                contentColor = Color.White,
                elevation = 12.dp,
                actions = {
                    Spacer(modifier = Modifier.width(30.dp))
                    Switch(checked = darkMode, onCheckedChange = { darkMode = !darkMode })
                }
            )
        }, content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (detailState.heroParameters == null) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .wrapContentSize(align = Alignment.Center),

                                )
                        }
                    }
                } else {
                    item {
                        detailState.let {
                            it.heroParameters?.let { it1 -> DetailsCard(param = it1) }
                        }
                    }
                }
            }
        })

}




@Composable
fun DetailsCard(param: HeroParams) {
    val imgPainter = rememberImagePainter(data = param.thumb_image)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = imgPainter,
                    contentDescription = "Image",
                    modifier = Modifier.size(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = param.bio_loc,
                color = Purple500
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "ХАРАКТЕРИСТИКИ",
                        fontSize = 24.sp,
                        color = Purple500,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
            Text(
                text = "Сложность:   ${param.complexity}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Здоровье:   ${param.max_health}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Мана:   ${param.max_mana}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Сила:   ${param.str_base}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ловкость:   ${param.agi_base}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Урон:   ${param.damage_min}-${param.damage_max}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Защита:   ${param.armor}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Дальность зрения:   ${param.sight_range_day}/${param.sight_range_night}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Дальность атаки:   ${param.attack_range}",
                fontSize = 20.sp,
                color = Purple700,
                fontWeight = FontWeight.Bold
            )
        }
    }
}