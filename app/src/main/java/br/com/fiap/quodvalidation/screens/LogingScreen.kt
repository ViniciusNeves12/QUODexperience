package br.com.fiap.quodvalidation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.quodvalidation.R
import br.com.fiap.quodvalidation.calcularIMC
import br.com.fiap.quodvalidation.determinarClassificacaoIMC

@Composable
fun LoginScreen(navController: NavController) {

    var user = remember {
        mutableStateOf("")
    }

    var senha = remember {
        mutableStateOf("")
    }

    var imc by remember {
        mutableStateOf(0.0)
    }

    var statusImc by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // ---- header ---------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(colorResource(id = R.color.cinza_quod))
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.logoquod),
                    contentDescription = "logo",
                    modifier = Modifier
                        .clip(shape = RectangleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Experience",
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp
                )
            }
            // --- formulário
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .offset(y = (-130).dp)
                        .fillMaxWidth(),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xfff9f6f6)),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Login",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.cinza_quod),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "user",
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.cinza_quod)
                        )
                        OutlinedTextField(
                            value = user.value,
                            onValueChange = {user.value = it},
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(text = "Digite seu User")
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.cinza_quod),
                                focusedBorderColor = colorResource(id = R.color.cinza_quod)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Senha",
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.cinza_quod)
                        )
                        OutlinedTextField(
                            value = senha.value,
                            onValueChange = {senha.value = it},
                            modifier = Modifier.fillMaxWidth(),
                            visualTransformation = PasswordVisualTransformation(),
                            placeholder = {
                                Text(
                                    text = "Digite sua Senha"
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.cinza_quod),
                                focusedBorderColor = colorResource(id = R.color.cinza_quod)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                 navController.navigate("menu")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.cinza_quod))
                        ) {
                            Text(
                                text = "Logar",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}