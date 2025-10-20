package mx.edu.utez.tiendatenis.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.tiendatenis.R
import mx.edu.utez.tiendatenis.ui.theme.TiendaTenisTheme

@Composable
fun RecuContra2Screen( ){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        Text(
            text =  "Ingresa el código que enviamos al correo"
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("*  *  *  *") }
        )

        Text(
            text =  "Ingresa tu nueva contraseña"
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") }
        )

        Text(
            text =  "Confirma tu contraseña"
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") }
        )




        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFDE59)
            )
        ) {
            Text(
                text = "Recuperar contraseña"
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRecuContra2Screen() {
    TiendaTenisTheme {
        RecuContra2Screen()
    }
}
