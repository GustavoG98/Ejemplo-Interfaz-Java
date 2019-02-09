package controlador.estilo;

import javax.swing.JButton;
import modelo.estilo.BtnCambioFondo;
import modelo.estilo.BtnCambioLetra;
import modelo.estilo.BtnClick;
import modelo.estilo.BtnIcono;

/**
 *
 * @author Johnny
 */
public class BtnsCTR {

    //Animacion del fondo de un boton  cambia de color
    //Al pasar el mouse por arriba  
    public static void hoverBtnFondo(JButton btn1) {
        btn1.addMouseListener(new BtnCambioFondo(btn1));
    }

    public static void hoverBtnFondo(JButton btn1, JButton btn2) {
        btn1.addMouseListener(new BtnCambioFondo(btn1));
        btn2.addMouseListener(new BtnCambioFondo(btn2));
    }

    public static void hoverBtnFondo(JButton btn1, JButton btn2, JButton btn3) {
        btn1.addMouseListener(new BtnCambioFondo(btn1));
        btn2.addMouseListener(new BtnCambioFondo(btn2));
        btn3.addMouseListener(new BtnCambioFondo(btn3));
    }

    public static void hoverBtnFondo(JButton btn1, JButton btn2, JButton btn3, JButton btn4) {
        btn1.addMouseListener(new BtnCambioFondo(btn1));
        btn2.addMouseListener(new BtnCambioFondo(btn2));
        btn3.addMouseListener(new BtnCambioFondo(btn3));
        btn4.addMouseListener(new BtnCambioFondo(btn4));
    }

    //Animacion del color y tamaño de letra de un boton al pasar el mouse
    public static void hoverBtnLetra(JButton btn1) {
        btn1.addMouseListener(new BtnCambioLetra(btn1));
    }

    public static void hoverBtnLetra(JButton btn1, JButton btn2) {
        btn1.addMouseListener(new BtnCambioLetra(btn1));
        btn2.addMouseListener(new BtnCambioLetra(btn2));
    }

    public static void hoverBtnLetra(JButton btn1, JButton btn2, JButton btn3) {
        btn1.addMouseListener(new BtnCambioLetra(btn1));
        btn2.addMouseListener(new BtnCambioLetra(btn2));
        btn3.addMouseListener(new BtnCambioLetra(btn3));
    }

    public static void hoverBtnLetra(JButton btn1, JButton btn2, JButton btn3, JButton btn4) {
        btn1.addMouseListener(new BtnCambioLetra(btn1));
        btn2.addMouseListener(new BtnCambioLetra(btn2));
        btn3.addMouseListener(new BtnCambioLetra(btn3));
        btn4.addMouseListener(new BtnCambioLetra(btn4));
    }

    public static void hoverBtnLetra(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5) {
        btn1.addMouseListener(new BtnCambioLetra(btn1));
        btn2.addMouseListener(new BtnCambioLetra(btn2));
        btn3.addMouseListener(new BtnCambioLetra(btn3));
        btn4.addMouseListener(new BtnCambioLetra(btn4));
        btn5.addMouseListener(new BtnCambioLetra(btn5));
    }

    //Animacion al dar click a un boton de navegacion, el primer boton enviado 
    //Sera el que esta seleccionado
    public static void clickBtnNv(JButton btnSeleccionado) {
        BtnClick.btnSeleccionado(btnSeleccionado);
    }

    public static void clickBtnNv(JButton btnSeleccionado, JButton btn1) {
        BtnClick.btnSeleccionado(btnSeleccionado);

        BtnClick.btnDeseleccionado(btn1);
    }

    public static void clickBtnNv(JButton btnSeleccionado, JButton btn1, JButton btn2) {
        BtnClick.btnSeleccionado(btnSeleccionado);

        BtnClick.btnDeseleccionado(btn1);
        BtnClick.btnDeseleccionado(btn2);
    }

    public static void clickBtnNv(JButton btnSeleccionado, JButton btn1, JButton btn2, JButton btn3) {
        BtnClick.btnSeleccionado(btnSeleccionado);

        BtnClick.btnDeseleccionado(btn1);
        BtnClick.btnDeseleccionado(btn2);
        BtnClick.btnDeseleccionado(btn3);
    }

    public static void clickBtnNv(JButton btnSeleccionado, JButton btn1, JButton btn2, JButton btn3, JButton btn4) {
        BtnClick.btnSeleccionado(btnSeleccionado);

        BtnClick.btnDeseleccionado(btn1);
        BtnClick.btnDeseleccionado(btn2);
        BtnClick.btnDeseleccionado(btn3);
        BtnClick.btnDeseleccionado(btn4);
    }

    public static void clickBtnNv(JButton btnSeleccionado, JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5) {
        BtnClick.btnSeleccionado(btnSeleccionado);

        BtnClick.btnDeseleccionado(btn1);
        BtnClick.btnDeseleccionado(btn2);
        BtnClick.btnDeseleccionado(btn3);
        BtnClick.btnDeseleccionado(btn4);
        BtnClick.btnDeseleccionado(btn5);
    }

    //Solo para iconos  
    public static void hoverBtnIcono(JButton btn1) {
        btn1.addMouseListener(new BtnIcono(btn1));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2, JButton btn3) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
        btn3.addMouseListener(new BtnIcono(btn3));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2, JButton btn3,
            JButton btn4) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
        btn3.addMouseListener(new BtnIcono(btn3));
        btn4.addMouseListener(new BtnIcono(btn4));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2, JButton btn3,
            JButton btn4, JButton btn5) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
        btn3.addMouseListener(new BtnIcono(btn3));
        btn4.addMouseListener(new BtnIcono(btn4));
        btn5.addMouseListener(new BtnIcono(btn5));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2, JButton btn3,
            JButton btn4, JButton btn5, JButton btn6) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
        btn3.addMouseListener(new BtnIcono(btn3));
        btn4.addMouseListener(new BtnIcono(btn4));
        btn5.addMouseListener(new BtnIcono(btn5));
        btn6.addMouseListener(new BtnIcono(btn6));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2, JButton btn3,
            JButton btn4, JButton btn5, JButton btn6, JButton btn7) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
        btn3.addMouseListener(new BtnIcono(btn3));
        btn4.addMouseListener(new BtnIcono(btn4));
        btn5.addMouseListener(new BtnIcono(btn5));
        btn6.addMouseListener(new BtnIcono(btn6));
        btn7.addMouseListener(new BtnIcono(btn7));
    }

    public static void hoverBtnIcono(JButton btn1, JButton btn2, JButton btn3,
            JButton btn4, JButton btn5, JButton btn6, JButton btn7, JButton btn8) {
        btn1.addMouseListener(new BtnIcono(btn1));
        btn2.addMouseListener(new BtnIcono(btn2));
        btn3.addMouseListener(new BtnIcono(btn3));
        btn4.addMouseListener(new BtnIcono(btn4));
        btn5.addMouseListener(new BtnIcono(btn5));
        btn6.addMouseListener(new BtnIcono(btn6));
        btn7.addMouseListener(new BtnIcono(btn7));
        btn8.addMouseListener(new BtnIcono(btn8));
    }

}
