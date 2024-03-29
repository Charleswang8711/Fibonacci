package com.example.zencontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zencontrol.ui.theme.ZenControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZenControlTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    val fabList = getFibonacci(100000)

                    Column (
                        modifier = Modifier
                            .background(Color.LightGray)
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.LightGray,
                                contentColor = Color.LightGray
                            ),
                        ) {
                            Text(
                                text = stringResource(id = R.string.app_button_text),
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Divider(
                            thickness = 1.dp,
                            color = Color.Gray
                        )

                        LazyColumn(modifier = Modifier,
                            horizontalAlignment =Alignment.CenterHorizontally)
                        {
                            items(fabList){

                                Text(
                                    text = "$it",
                                    modifier = Modifier
                                        .padding(12.dp))

                                Divider(
                                    thickness = 1.dp,
                                    color = Color.Gray
                                )

                            }
                        }
                    }


                }
            }
        }
    }
}

fun getFibonacci(number: Int): List<ULong>{

    val fibList = mutableListOf<ULong>(0u, 1u)

    if (number == 0)
        return  listOf()

    for (i in 2..number)
    {
        fibList.add(fibList[i-1] + fibList[i-2])
    }

    return  fibList.take(number)

}
