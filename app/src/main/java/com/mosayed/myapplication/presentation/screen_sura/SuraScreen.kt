package com.mosayed.myapplication.presentation.screen_sura

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mosayed.myapplication.R

@Composable
fun SuraScreen(
    navHostController: NavHostController,
    viewModel: SuraViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    SuraScreenContent(
        onSuraClick = { suraNumber ->
            navHostController.navigate("aya_screen/$suraNumber")
        },
        state = state.value
    )
}

@Composable
private fun SuraScreenContent(
    onSuraClick: (Int) -> Unit,
    state: SuraUiState
) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "menu",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_notifications),
                contentDescription = "notifications",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(30.dp)
            )
        }


        LazyColumn() {
            items(state.suraList) { suraItem ->
                SuraItem(onSuraClick = onSuraClick, suraItem = suraItem)
            }
        }
    }
}

@Composable
private fun SuraItem(onSuraClick: (Int) -> Unit, suraItem: SuraUiState.SuraItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onSuraClick(suraItem.suraNumber) },
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = suraItem.suraNumber.toString(),
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .paint(painter = painterResource(id = R.drawable.star))
                .padding(top = 8.dp),
            textAlign = TextAlign.Center
        )

        Column {
            Text(
                text = suraItem.name,
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.primary),
            )
            Text(
                text = "${suraItem.revelationType}, ${suraItem.numberOfAyahs}Ayat",
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.primary),
            )
        }
    }
}
