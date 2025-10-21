package mx.edu.utez.tiendatenis.ui.screens

import android.util.Log.i
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import mx.edu.utez.tiendatenis.ui.theme.TiendaTenisTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mx.edu.utez.tiendatenis.R
import mx.edu.utez.tiendatenis.ui.components.texts.Label






@Composable
fun RecuContraScreen( ){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(R.drawable.tennislogo),
            contentDescription = "Logo de nuestra app"
        )

        Label("Ingresa tu correo electronico")

        TextField(
            value = "",
            onValueChange = {},
            label = { Label("Correo electrónico")}
        )




        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFDE59)
            )
        ) {
            Label("Continuar")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRecuContraScreen(){
    TiendaTenisTheme {
        RecuContraScreen()
    }
}