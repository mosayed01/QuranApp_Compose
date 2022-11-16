package com.mosayed.myapplication.presentation.screen_sura.componants

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mosayed.myapplication.R

@ExperimentalMaterial3Api
@Composable
fun Top(
    title: String,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
        Icon(
            painter = painterResource(id = R.drawable.menue_icon),
            contentDescription = ""
        )
    },
    )
}