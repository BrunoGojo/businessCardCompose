package com.example.businesscardcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun BusinessCardScreen(
    fullname: String,
    title: String,
    cellphone: String,
    instagram: String,
    email: String,
    imageUri: String?  // A imagem é opcional
) {
    val instagramIcon = painterResource(R.drawable.instagram)
    val whatsIcon = painterResource(R.drawable.whatsapp)
    val emailIcon = painterResource(R.drawable.gmail)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Centraliza a Column na tela
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Começa a partir do topo
        ) {
            // Se houver uma imagem selecionada, exibe-a
            imageUri?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nome e título
            Text(
                text = fullname,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            // Informações de contato
            Spacer(modifier = Modifier.height(82.dp)) // Espaço entre o título e as informações de contato
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = whatsIcon,
                        contentDescription = null,
                        modifier = Modifier.size(42.dp)
                    )
                    Image(
                        painter = instagramIcon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Image(
                        painter = emailIcon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre os ícones e os textos
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = cellphone, style = MaterialTheme.typography.bodyLarge)
                    Text(text = instagram, style = MaterialTheme.typography.bodyLarge)
                    Text(text = email, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}