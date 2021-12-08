package duran_guerrero.rutilio.datos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    var mensajeRecibido = ""
    var segundoMensajeRecibido = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val nomComp = findViewById<TextView>(R.id.nomComp)
        val regInicio = findViewById<Button>(R.id.regInicio)

        intent.extras?.let {bundle ->
            mensajeRecibido = bundle.getString("nombre", "")
            segundoMensajeRecibido = bundle.getString("apellido","")
            nomComp.text = mensajeRecibido + " " + segundoMensajeRecibido
        }

        regInicio.setOnClickListener {
            val intent2 = Intent()
            intent2.putExtra("respuesta", nomComp.text.toString())
            setResult(Activity.RESULT_OK, intent2)
            finish()
        }
    }
}