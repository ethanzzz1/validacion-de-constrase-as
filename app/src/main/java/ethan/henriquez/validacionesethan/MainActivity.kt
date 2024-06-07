package ethan.henriquez.validacionesethan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //mandar a llamar todos los elementos de la vista

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtClave = findViewById<EditText>(R.id.txtClave)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //programar el boton

        btnAgregar.setOnClickListener {
            //validamos que los campos estan vacios
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty() || txtClave.text.isEmpty() || txtEdad.text.isEmpty() || txtDUI.text.isEmpty()){
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
            }else{
                //comprobar que solo ingrese numeros
                if(!txtEdad.text.matches("[0-9]+".toRegex())){
                    Toast.makeText(this, "Ingrese solo números", Toast.LENGTH_SHORT).show()

                }else{
                    //validar correo electronico
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+".toRegex())){
                        Toast.makeText(this,"Ingresa un correo valido",Toast.LENGTH_SHORT).show()

                    }else{
                        //validar contraseña
                        if(txtClave.text.length<6 || txtClave.text.matches("[0-9]+".toRegex())){
                            Toast.makeText(this, "La clave debe contener mas de 6 dijitos", Toast.LENGTH_SHORT).show()
                        }else{
                            //validar DUI
                            if (txtDUI.text.length>10 && txtClave.text.matches("[0-9.-]+".toRegex())){
                                Toast.makeText(this, "Ingrese un dui correcto", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }


            }


        }

        //corrutina




    }


}