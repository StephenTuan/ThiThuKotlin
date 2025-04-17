package com.example.thithukotlin.Dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.thithukotlin.Model.Cat

@Composable
fun CatDetailDialog(cat: Cat, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Thông tin chi tiết") },
        text = {
            Column {
                Text(text = "Tên: ${cat.tags.joinToString(", ")}")
                AsyncImage(
                    model = "https://cataas.com/cat/${cat.id}",
                    contentDescription = "Cat Detail Image"
                )
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Đóng")
            }
        }
    )
}