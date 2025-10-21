package mx.edu.utez.tiendatenis.ui.components.inputs

import androidx.compose.runtime.Composable

@Composable
fun EditText(label: String, onValueChange: () -> Unit, value: String){
    EditText(
        value = value,
        onValueChange = onValueChange,
        label = label
    )

}