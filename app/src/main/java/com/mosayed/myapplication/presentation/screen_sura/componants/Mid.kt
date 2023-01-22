package com.mosayed.myapplication.presentation.screen_sura.componants

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mosayed.myapplication.R

@Composable
fun LastReadSection(
//    lastRead: Sura
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorScheme.primary,
                        colorScheme.secondary
                    )
                )
            )
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
//            containerColor =
        )

    ) {

        Image(
            painterResource(id = R.drawable.book),
            contentDescription = "",
            modifier = Modifier
                .padding(bottom = 12.dp)
                .size(250.dp)
                .blur(1.57.dp),

            )
    }

}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
fun PrevLastReadSection() {
    LastReadSection()
}