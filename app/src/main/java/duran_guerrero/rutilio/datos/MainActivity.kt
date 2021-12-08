package duran_guerrero.rutilio.datos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val TAG = "ciclo_vida"
    lateinit var KHE:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        KHE = findViewById<TextView>(R.id.KHE)
        val btnClick = findViewById<Button>(R.id.WTF)



        btnClick.setOnClickListener{
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("nombre", KHE.text.toString())
            startActivityForResult(i,666)
            KHE.text = ""
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 666){
            if (resultCode == Activity.RESULT_OK){
                val stringEsperado = data?.getStringExtra("respuesta")
                KHE.text = stringEsperado
            }
        }
    }

}