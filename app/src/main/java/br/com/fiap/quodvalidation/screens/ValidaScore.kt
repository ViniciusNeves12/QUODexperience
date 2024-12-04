import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
fun ScoreAntifraude() {
    var cpf by remember { mutableStateOf("") }
    var score by remember { mutableStateOf<Int?>(null) }
    var scoreColor by remember { mutableStateOf(Color.Gray) }

    fun calculateScore() {
        score = Random.nextInt(1, 1001)
        scoreColor = when (score!!) {
            in 1..300 -> Color.Red
            in 301..600 -> Color.Yellow
            else -> Color.Green
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
                    contentDescription = "Logo",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Score Antifraude",
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Button(
                            onClick = { calculateScore() },
                            enabled = cpf.isNotBlank(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(
                                text = "Validar Score",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        score?.let {
                            Text(
                                text = "Score: $it",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = scoreColor,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}
