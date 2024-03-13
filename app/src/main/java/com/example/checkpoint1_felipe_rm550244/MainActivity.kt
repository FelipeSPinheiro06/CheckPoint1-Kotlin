package com.example.checkpoint1_felipe_rm550244

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkpoint1_felipe_rm550244.ui.theme.CheckPoint1_Felipe_RM550244Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.buttonPesoIdeal)
        button.setOnClickListener {view ->
            var altura = findViewById<EditText>(R.id.txtAltura).text.toString().toFloat()
            var radioMasculino = findViewById<RadioButton>(R.id.radioMasculino)
            var radioFeminino = findViewById<RadioButton>(R.id.radioFeminino)
            var message = ""

            if(radioMasculino.isChecked) {
                var calculo = (72.7 * altura) - 58
                message = "O seu peso ideal é $calculo"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }

            if(radioFeminino.isChecked) {
                var calculo = (62.1 * altura) - 44.7
                message = "O seu peso ideal é $calculo"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }

            if(!radioMasculino.isChecked and !radioFeminino.isChecked) {
                Toast.makeText(this, "Clique em Masculino ou Feminino!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}