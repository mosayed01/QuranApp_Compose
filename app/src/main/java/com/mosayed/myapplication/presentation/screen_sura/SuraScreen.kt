package com.mosayed.myapplication.presentation.screen_sura

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mosayed.myapplication.R
import com.mosayed.myapplication.presentation.screen_sura.componants.Head

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuraScreen(navHostController: NavHostController) {
    ///Head
    Head(title = R.string.app_name)

    ///Mid

    ///List{cardItem}

}
