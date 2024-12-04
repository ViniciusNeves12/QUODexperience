import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.quodvalidation.R
import kotlin.random.Random

@Composable
fun AutenticacaoCadastral() {
    var cpf by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var isAuthenticating by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("Preencha os dados para validação.") }
    var messageColor by remember { mutableStateOf(Color.Gray) }

    fun simulateCadastroValidation() {
        isAuthenticating = true
        isSuccess = false
        message = "Validando dados cadastrais..."
        messageColor = Color.Gray

        val validationResult = Random.nextBoolean()

        Thread.sleep(2000)

        isAuthenticating = false
        if (validationResult) {
            isSuccess = true
            message = "Dados cadastrados validados com sucesso!"
            messageColor = Color.Green
        } else {
            isSuccess = false
            message = "Falha na validação dos dados. Tente novamente."
            messageColor = Color.Red
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(colorResource(id = R.color.cinza_quod))
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Autenticação Cadastral",
                    color = colorResource(id = R.color.white),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .offset(y = (-130).dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = cpf,
                            onValueChange = { cpf = it },
                            label = { Text("CPF") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = nome,
                            onValueChange = { nome = it },
                            label = { Text("Nome") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = endereco,
                            onValueChange = { endereco = it },
                            label = { Text("Endereço") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = telefone,
                            onValueChange = { telefone = it },
                            label = { Text("Telefone") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = message,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = messageColor,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Button(
                            onClick = { simulateCadastroValidation() },
                            enabled = !isAuthenticating && cpf.isNotBlank() && nome.isNotBlank() && endereco.isNotBlank() && telefone.isNotBlank(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSuccess) Color.Green else Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(
                                text = if (isSuccess) "Validado" else "Validar",
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
