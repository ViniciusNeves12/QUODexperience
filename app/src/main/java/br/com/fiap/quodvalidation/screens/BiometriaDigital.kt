import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.quodvalidation.R
import kotlin.random.Random

@Composable
fun BiometriaDigital() {

    var isAuthenticating by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("Pressione para autenticar") }
    var messageColor by remember { mutableStateOf(Color.Gray) }
    var fingerprintColor by remember { mutableStateOf(Color.Gray) }

    fun simulateBiometricAuth() {
        isAuthenticating = true
        isSuccess = false
        message = "Validando biometria..."
        messageColor = Color.Gray
        fingerprintColor = Color.Gray

        val authenticationResult = Random.nextBoolean()

        Thread.sleep(2000)

        isAuthenticating = false
        if (authenticationResult) {
            isSuccess = true
            message = "Autenticação bem-sucedida!"
            messageColor = Color.Green
            fingerprintColor = Color.Green
        } else {
            isSuccess = false
            message = "Falha na autenticação. Tente novamente."
            messageColor = Color.Red
            fingerprintColor = Color.Red
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
                Image(
                    painter = painterResource(id = R.drawable.logoquod),
                    contentDescription = "logo",
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Experience",
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp
                )
            }
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
                            text = "Autenticação Biométrica",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.cinza_quod),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                        Image(
                            painter = painterResource(id = R.drawable.fingerprint_24),
                            contentDescription = "Fingerprint",
                            modifier = Modifier
                                .size(200.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(16.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(fingerprintColor)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Text(
                            text = message,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = messageColor,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Button(
                            onClick = {
                                simulateBiometricAuth()
                            },
                            enabled = !isAuthenticating,
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSuccess) Color.Green else Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(
                                text = if (isSuccess) "Sucesso" else "Validar",
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
