package ran.am.androidmanifestercodesjetpackcomposeui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ran.am.androidmanifestercodesjetpackcomposeui.ui.theme.AndroidManifesterCodesJetpackComposeUITheme

// This coding covers
// Simple Login Screen
// Getting data from Edittext( Textfieid ) and setting it on the textview (Text)
// Simple Toast message from Edittext ( Textfieid )
// how to declare value using remember by
// button background color
// button rounded corner

class SimpleLoginScreenUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidManifesterCodesJetpackComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loginscreen(applicationContext)
                    context=applicationContext
                }
            }
        }
    }
}
lateinit var context: Context

@Composable
fun loginscreen(applicationContext: Context) {
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    val inputpw = remember { mutableStateOf(TextFieldValue()) }
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.Yellow
            )
            .padding(all = 20.dp)
    ) {

        Text(
            text = "Username", color = Color(0xFF673AB7),
            modifier = Modifier.fillMaxWidth(), fontSize = 32.sp
        )

        TextField(
            value = inputvalue.value,
            onValueChange = { inputvalue.value = it },
            modifier = Modifier.fillMaxWidth()
        )


        Text(text = "Password", color = Color(0xFF673AB7), fontSize = 32.sp)

        TextField(
            value = inputpw.value,
            onValueChange = { inputpw.value = it },
            modifier = Modifier.fillMaxWidth()
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 20.dp)) {

            Button(onClick = {
                Toast.makeText(applicationContext,  "" + inputvalue.value.text + "\n" + inputpw.value.text,Toast.LENGTH_SHORT).show()


            }, Modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(Color(0xFF8BC34A)),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "LOG IN", color = Color.White)
            }
        }
        Text(text = inputvalue.value.text + "\n" + inputpw.value.text, color =  Color(0xFF673AB7))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AndroidManifesterCodesJetpackComposeUITheme {
        loginscreen(context)
    }
}