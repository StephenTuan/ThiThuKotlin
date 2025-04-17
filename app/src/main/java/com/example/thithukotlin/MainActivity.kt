package com.example.thithukotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.thithukotlin.Dialog.CatDetailDialog
import com.example.thithukotlin.Model.Cat
import com.example.thithukotlin.Model.CatViewModel
import com.example.thithukotlin.ui.theme.ThiThuKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(catViewModel: CatViewModel = viewModel()) {
    val cats by catViewModel.catList.collectAsState()
    val selectedCat by catViewModel.selectedCat.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Danh sách mèo cute 😺") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(cats) { cat ->
                CatItem(cat = cat, onClick = { catViewModel.selectCat(cat) })
            }
        }

        selectedCat?.let {
            CatDetailDialog(cat = it, onDismiss = { catViewModel.dismissDialog() })
        }
    }
}

@Composable
fun CatItem(cat: Cat, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = "https://cataas.com/cat/${cat.id}",
                contentDescription = "Cat Image",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = cat.tags.joinToString(", "), style = MaterialTheme.typography.titleMedium)
        }
    }
}


