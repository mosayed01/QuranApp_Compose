package com.mosayed.myapplication.presentation.screen_sura

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.mosayed.myapplication.R
import com.mosayed.myapplication.presentation.screen_sura.componants.Top

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuraScreen(navHostController: NavHostController) {
    ///Top
    Top(title = stringResource(id = R.string.app_name))

    ///Head

    ///List{cardItem}

}
