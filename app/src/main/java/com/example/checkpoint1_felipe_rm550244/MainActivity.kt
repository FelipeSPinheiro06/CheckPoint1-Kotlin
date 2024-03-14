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

        var radioMasculino = findViewById<RadioButton>(R.id.radioMasculino)
        var radioFeminino = findViewById<RadioButton>(R.id.radioFeminino)
        var button = findViewById<Button>(R.id.buttonPesoIdeal)

        trocarBotoes(radioMasculino, radioFeminino)
        
        button.setOnClickListener {view ->
            //Variáveis para condições
            var nenhumBotaoAcionado = !radioMasculino.isChecked and !radioFeminino.isChecked
            var masculinoAcionado = radioMasculino.isChecked
            var femininoAcionado = radioFeminino.isChecked

            //Variáveis para manipulação
            var altura = findViewById<EditText>(R.id.txtAltura).text.toString().toFloat()
            var message = ""


            if(nenhumBotaoAcionado) {
                Toast.makeText(this, "Clique em Masculino ou Feminino!", Toast.LENGTH_SHORT).show()
            }

            if(masculinoAcionado) {
                message = calcularIMC(false, altura)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }

            if(femininoAcionado) {
                message = calcularIMC(true, altura)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }


    }
}
fun calcularIMC(sexo: Boolean, altura: Float): String {

    // sexo = false (Masculino)
    // sexo = true  (Feminino)

    if(!sexo) { //Masculino

        var calculo = (72.7 * altura) - 58
        return "O seu peso ideal é $calculo"

    }
        //Feminino
        var calculo = (62.1 * altura) - 44.7
        return "O seu peso ideal é $calculo"

}

fun trocarBotoes(radioMasculino: RadioButton, radioFeminino: RadioButton) {
    radioMasculino.setOnClickListener {
        radioFeminino.isChecked = false
    }

    radioFeminino.setOnClickListener {
        radioMasculino.isChecked = false
    }
}