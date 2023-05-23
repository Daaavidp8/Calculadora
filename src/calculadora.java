import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class calculadora extends JPanel{
    private JPanel panel;
    private JTextField Panelnumeros;
    private JButton a7Button;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a0Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton aLessButton;
    private JButton aPlusButton;
    private JButton aEqualButton;
    private fondo fondo1;
    private crear ventana;
    private String calculo = "";

    private int numanterior;
    private int numactual;
    private String botonAnterior;
    private int valor = 0;

    private String numero = "";

    private boolean primernumero = false;

    public calculadora(){

        crear ventana = new crear();
        crear.CrearVentana(ventana,panel,"Calculadora",300,400,true,JFrame.EXIT_ON_CLOSE);
        ActionListener Numeros = actionEvent -> {
            AbstractButton botonActual = (AbstractButton) actionEvent.getSource();


            if (!botonActual.getText().equals("+") && !botonActual.getText().equals("=") && !botonActual.getText().equals("-")){
                numero += botonActual.getText();
                Panelnumeros.setText(numero);
            }

            if (botonActual.getText().equals("+")){
                numanterior = Integer.parseInt(numero);
                valor += numanterior;
                Panelnumeros.setText("");
                numero = "";
                botonAnterior = botonActual.getText();
            }else if (botonActual.getText().equals("+")){
                numanterior = Integer.parseInt(numero);
                if (!primernumero){
                    valor += numanterior;
                    primernumero = true;
                }else{
                    valor -= numanterior;
                }
                Panelnumeros.setText("");
                numero = "";
                botonAnterior = botonActual.getText();
            }else if(botonActual.getText().equals("=") && !Objects.equals(botonAnterior, "=")) {
                if (Objects.equals(botonAnterior, "+")){
                   valor += Integer.parseInt(Panelnumeros.getText());
                } else if (Objects.equals(botonAnterior, "-")) {
                    valor -= Integer.parseInt(Panelnumeros.getText());
                }
                Panelnumeros.setText(String.valueOf(valor));
                botonAnterior = botonActual.getText();

            }


        };
        a0Button.addActionListener(Numeros);
        a1Button.addActionListener(Numeros);
        a2Button.addActionListener(Numeros);
        a3Button.addActionListener(Numeros);
        a4Button.addActionListener(Numeros);
        a5Button.addActionListener(Numeros);
        a6Button.addActionListener(Numeros);
        a7Button.addActionListener(Numeros);
        a8Button.addActionListener(Numeros);
        a9Button.addActionListener(Numeros);
        aLessButton.addActionListener(Numeros);
        aPlusButton.addActionListener(Numeros);
        aEqualButton.addActionListener(Numeros);
    }

    private void createUIComponents(){
        fondo1 = new fondo();
    }


}
