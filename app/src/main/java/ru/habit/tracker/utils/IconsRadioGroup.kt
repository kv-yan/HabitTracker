package ru.habit.tracker.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.habit.tracker.R

@Composable
fun IconsRadioGroup(options: MutableList<IconsItem>) {
    val onOptionSelectedListener: (MutableList<IconsItem>, IconsItem) -> Unit = { list, item ->
        list.forEach {
            it.isSelected.value = it.icon == item.icon
        }
    }


    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { item ->
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = if (item.isSelected.value) Color(0xffd7ebe9) else Color.White)
                    .border(
                        border = BorderStroke(
                            1.dp, if (item.isSelected.value) Color(0xff89ccc5) else Color.White
                        ), shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        onOptionSelectedListener(options, item)
                    }) {

                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun IconsPrev() {
    val icons = remember {
        mutableListOf<IconsItem>(
            IconsItem(icon = R.drawable.ic_icon_1, isSelected = mutableStateOf(true)),
            IconsItem(icon = R.drawable.ic_icon_2, isSelected = mutableStateOf(false)),
            IconsItem(icon = R.drawable.ic_icon_3, isSelected = mutableStateOf(false)),
            IconsItem(icon = R.drawable.ic_icon_4, isSelected = mutableStateOf(false)),
        )
    }


    IconsRadioGroup(options = icons)
}


data class IconsItem(
    var icon: Int,
    var isSelected: MutableState<Boolean>,
)

