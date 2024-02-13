package ru.habit.tracker.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.habit.tracker.ui.screens.btnActiveColor

@Composable
fun ColorsRadioGroup(options: MutableList<ColorsItem>) {
    val onOptionSelectedListener: (MutableList<ColorsItem>, ColorsItem) -> Unit = { list, item ->
        list.forEach {
            it.isSelected.value = it.color == item.color
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { item ->
            Surface(modifier = Modifier
                .size(36.dp)
                .clickable {
                    onOptionSelectedListener(options, item)
                }
                .clip(shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                color = item.color,
                border = BorderStroke(
                    width = 1.dp,
                    color = if (item.isSelected.value) item.borderColor else Color.Transparent
                )) {

            }
        }
    }
}

@Preview
@Composable
private fun ColorsPrev() {

}


data class ColorsItem(
    val id: Int,
    var color: Color,
    var borderColor: Color,
    var isSelected: MutableState<Boolean>,
)

