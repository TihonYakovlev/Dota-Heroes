    package com.tihonyakovlev.dotaheroes.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.tihonyakovlev.dotaheroes.data.repository.DotaHeroInfo
import com.tihonyakovlev.dotaheroes.presentation.darkMode
import com.tihonyakovlev.dotaheroes.presentation.screens.destinations.HeroesDetailsScreenDestination
import com.tihonyakovlev.dotaheroes.presentation.viewmodels.MainViewModel
import com.tihonyakovlev.dotaheroes.ui.theme.Purple700
import org.koin.androidx.compose.getViewModel


@RootNavGraph(start = true)
@Destination
@Composable
fun HeroesListScreen(
    navigator: DestinationsNavigator,
    mainViewModel: MainViewModel = getViewModel()
) {

    val mainState by mainViewModel.mainState.collectAsState()

    var checkedByComp1 by remember {
        mutableStateOf(false)
    }
    var checkedByComp2 by remember {
        mutableStateOf(false)
    }
    var checkedByComp3 by remember {
        mutableStateOf(false)
    }


    if (mainState.heroes.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center),

                )
        }
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "List of Dota 2 Heroes",
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    },
                    backgroundColor = Color.Magenta,
                    contentColor = Color.White,
                    elevation = 12.dp,
                    actions = {
                        Spacer(modifier = Modifier.width(30.dp))
                        Switch(checked = darkMode, onCheckedChange = {
                            darkMode = !darkMode
                        })
                    }
                )
            }, content = {
                LazyColumn {
                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Complexity 1:", color = Purple700)
                            Checkbox(
                                checked = checkedByComp1,
                                onCheckedChange = { checked1_ ->
                                    checkedByComp1 = checked1_
                                }
                            )
                            Text(text = "2: ", color = Purple700)
                            Checkbox(
                                checked = checkedByComp2,
                                onCheckedChange = { checked1_ ->
                                    checkedByComp2 = checked1_
                                }
                            )
                            Text(text = "3: ", color = Purple700)
                            Checkbox(
                                checked = checkedByComp3,
                                onCheckedChange = { checked1_ ->
                                    checkedByComp3 = checked1_
                                }
                            )
                        }
                    }
                    items(mainState.heroes) { hero: DotaHeroInfo ->
                        if (checkedByComp1 && hero.complexity == 1) {
                            HeroCard(navigator = navigator, hero = hero)
                        }
                        if (checkedByComp2 && hero.complexity == 2) {
                            HeroCard(navigator = navigator, hero = hero)
                        }
                        if (checkedByComp3 && hero.complexity == 3) {
                            HeroCard(navigator = navigator, hero = hero)
                        }
                        if (!checkedByComp3 && !checkedByComp2 && !checkedByComp1) {
                            HeroCard(navigator = navigator, hero = hero)
                        }
                    }
                }
            })
    }

}


@Destination
@Composable
fun HeroCard(navigator: DestinationsNavigator, hero: DotaHeroInfo) {
    val heroImg = rememberImagePainter(data = hero.image)
    val heroAttributeImg = rememberImagePainter(data = hero.attribute_img)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .clickable { navigator.navigate(HeroesDetailsScreenDestination(id = hero.id)) }
            .padding(5.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
    )
    {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),
                contentAlignment = Alignment.CenterStart,

                ) {
                Card(elevation = 10.dp, shape = RoundedCornerShape(8.dp)) {
                    Image(
                        painter = heroImg,
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                            .size(168.dp)
                            .fillMaxSize()
                    )
                }
            }
            Column {
                Row {
                    Text(
                        text = hero.name_loc,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Purple700
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = heroAttributeImg,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                            .size(25.dp)
                    )
                }
                Text(
                    text = "Complexity: ${hero.complexity}",
                    color = Purple700
                )
            }
        }
    }
}