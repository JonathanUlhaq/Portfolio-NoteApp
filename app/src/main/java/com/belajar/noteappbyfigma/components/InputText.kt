package com.belajar.noteappbyfigma.components

import android.graphics.Paint.Style
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction

@Composable
fun InputText(
    inputText:MutableState<String>,
    label:String,
    isSingleLine:Boolean,
    style:TextStyle,
    fontWeight:FontWeight,
    onKeyboardAction:() -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = inputText.value ,
        textStyle = style,
        onValueChange = {inputText.value = it},
        placeholder = { Text(text = label,
                    style = style,
                    fontWeight = fontWeight)},
        singleLine = isSingleLine,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            textColor = Color.White,
            unfocusedLabelColor = Color.White,
            focusedLabelColor = Color.White,
            placeholderColor = Color.White,
            cursorColor = Color.White
        ),
        leadingIcon = { Icon(imageVector = Icons.Default.Create,
            contentDescription = "icon" )},
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            onKeyboardAction.invoke()
        },

    )
}