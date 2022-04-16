package cr.ac.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression

var textView : TextView?= null
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView= findViewById(R.id.display)
        val expression = Expression("2+2")
        println("********"+expression.calculate())
    }
    fun muestraValor(vista: View){
        val btn = vista as Button
        val textoBtn = btn.text.toString()
        if(textView?.text.toString() == "0" || textView?.text.toString() == "0.0"){
            textView?.text = ""
        }else{
            textView?.text = textView?.text.toString()
        }


        var calculo = textView?.text.toString() + textoBtn
        textView?.text =  calculo

    }

    fun calculaTotal(texto: View){
        var resultado = Expression(textView?.text.toString())
        textView?.text = resultado.calculate().toString()
    }

    fun calculaPorcentaje(texto: View){
        var resultado = Expression(textView?.text.toString() + " / 100")
        textView?.text = resultado.calculate().toString()
    }
    fun reiniciaDisplay(texto: View){
        textView?.text = "0"
    }

}