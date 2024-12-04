package br.com.fiap.quodvalidation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.AlignmentLine
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
fun MenuScreen(navController: NavController) {

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
                    .height(1000.dp)
            ) {
                Card(
                    modifier = Modifier
                        .offset(y = (-130).dp)
                        .fillMaxWidth()
                        .height(1000.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xfff9f6f6)),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Menu",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.cinza_quod),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .height(1000.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("biometriaface")

                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "Biometria Facial",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("biometriadedo")

                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "Biometria digital",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("documento")

                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "Análise de documento",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("sim")
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "SIM SWAP",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("cadastral")
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "Autenticação Cadastral",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("score")
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "Score Antifraude",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = Color.Green),
                                horizontalArrangement = Arrangement.SpaceAround

                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .height(70.dp)
                                        .fillMaxWidth()
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("login")
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                            .height(70.dp), // Tamanho fixo 100x100
                                        shape = RoundedCornerShape(16.dp), // Bordas arredondadas com 16.dp
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) // Cor de fundo cinza
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth(),
                                                text = "Sair",
                                                fontSize = 16.sp,
                                                color = Color.White // Cor do texto
                                            )
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}