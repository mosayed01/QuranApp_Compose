package com.mosayed.myapplication.presentation.screen_sura.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mosayed.myapplication.R

@Composable
fun Head(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "menu",
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "menu",
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "menu",
        )


    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    Head()

}