
    import Metodos.Variables;
    import Metodos.Metodos;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

    /*
     * Created by JFormDesigner on Fri May 08 12:38:57 CDT 2020
     */

    /**
     * @author Usuario
     */

    public class RegistroLibros extends JFrame
    {
        public RegistroLibros()
        {
            initComponents();
            setLocationRelativeTo(null);
        }

        private void ISBN_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        private void Titulo_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Autor_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Editorial_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Año_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        private void Edicion_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        private void Categoria_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Idioma_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Bt_AgregarActionPerformed(ActionEvent e)
        {
            if(!(ISBN_Field.getText().equals("") || Titulo_Field.getText().equals("") || Autor_Field.getText().equals("") || Editorial_Field.getText().equals("") || Año_Field.getText().equals("") || Edicion_Field.getText().equals("") || Categoria_Field.getText().equals("") || Idioma_Field.getText().equals("")))
            {

                int ISBN = Integer.parseInt(ISBN_Field.getText());
                int Año = Integer.parseInt(Año_Field.getText());
                int Edicion = Integer.parseInt(Edicion_Field.getText());
                Metodos.AgregarLibros(ISBN, Titulo_Field.getText(), Autor_Field.getText(), Editorial_Field.getText(), Año, Edicion, Categoria_Field.getText(), Idioma_Field.getText(), Variables.NumeroCarnetUsuarioLog);

                if(Variables.ExisteLibro)
                {
                    ISBN_Field.setText("");
                    Titulo_Field.setText("");
                    Autor_Field.setText("");
                    Editorial_Field.setText("");
                    Año_Field.setText("");
                    Edicion_Field.setText("");
                    Categoria_Field.setText("");
                    Idioma_Field.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Libro Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                    ISBN_Field.setText("");
                    Titulo_Field.setText("");
                    Autor_Field.setText("");
                    Editorial_Field.setText("");
                    Año_Field.setText("");
                    Edicion_Field.setText("");
                    Categoria_Field.setText("");
                    Idioma_Field.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Se Debe De Rellenar Todos Los Campos", "Advertencia!", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void Bt_RegresarActionPerformed(ActionEvent e)
        {
            this.dispose();
        }

        private void textField4KeyTyped(KeyEvent e) {
            // TODO add your code here
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            label6 = new JLabel();
            ISBN_Field = new JTextField();
            Titulo_Field = new JTextField();
            Autor_Field = new JTextField();
            Editorial_Field = new JTextField();
            Año_Field = new JTextField();
            Edicion_Field = new JTextField();
            label1 = new JLabel();
            label2 = new JLabel();
            label3 = new JLabel();
            label4 = new JLabel();
            label5 = new JLabel();
            label7 = new JLabel();
            Categoria_Field = new JTextField();
            label8 = new JLabel();
            Idioma_Field = new JTextField();
            label9 = new JLabel();
            label10 = new JLabel();
            Bt_Agregar = new JButton();
            Bt_Regresar = new JButton();

            //======== this ========
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);
            setTitle("LIBROS FROM");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label6 ----
            label6.setText("AGREGAR LIBRO");
            label6.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label6);
            label6.setBounds(240, 15, 185, 24);

            //---- ISBN_Field ----
            ISBN_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            ISBN_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    ISBN_FieldKeyTyped(e);
                }
            });
            contentPane.add(ISBN_Field);
            ISBN_Field.setBounds(25, 75, 170, 35);

            //---- Titulo_Field ----
            Titulo_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Titulo_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Titulo_FieldKeyTyped(e);
                }
            });
            contentPane.add(Titulo_Field);
            Titulo_Field.setBounds(25, 145, 170, 35);

            //---- Autor_Field ----
            Autor_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Autor_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Autor_FieldKeyTyped(e);
                }
            });
            contentPane.add(Autor_Field);
            Autor_Field.setBounds(25, 215, 170, 35);

            //---- Editorial_Field ----
            Editorial_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Editorial_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Editorial_FieldKeyTyped(e);
                }
            });
            contentPane.add(Editorial_Field);
            Editorial_Field.setBounds(245, 75, 170, 35);

            //---- Año_Field ----
            Año_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Año_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Año_FieldKeyTyped(e);
                }
            });
            contentPane.add(Año_Field);
            Año_Field.setBounds(245, 145, 170, 35);

            //---- Edicion_Field ----
            Edicion_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Edicion_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Edicion_FieldKeyTyped(e);
                }
            });
            contentPane.add(Edicion_Field);
            Edicion_Field.setBounds(245, 215, 170, 35);

            //---- label1 ----
            label1.setText("ISBN");
            label1.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(25, 50), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("T\u00edtulo");
            label2.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label2);
            label2.setBounds(25, 120, 70, 22);

            //---- label3 ----
            label3.setText("Autor");
            label3.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label3);
            label3.setBounds(25, 190, 70, 22);

            //---- label4 ----
            label4.setText("Editorial");
            label4.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label4);
            label4.setBounds(245, 45, 100, 22);

            //---- label5 ----
            label5.setText("A\u00f1o");
            label5.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label5);
            label5.setBounds(245, 120, 85, 22);

            //---- label7 ----
            label7.setText("Edici\u00f3n");
            label7.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label7);
            label7.setBounds(245, 190, 85, 22);

            //---- Categoria_Field ----
            Categoria_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Categoria_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Categoria_FieldKeyTyped(e);
                }
            });
            contentPane.add(Categoria_Field);
            Categoria_Field.setBounds(460, 75, 170, 35);

            //---- label8 ----
            label8.setText("Categor\u00eda");
            label8.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label8);
            label8.setBounds(460, 45, 105, 22);

            //---- Idioma_Field ----
            Idioma_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Idioma_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    textField4KeyTyped(e);
                    Idioma_FieldKeyTyped(e);
                }
            });
            contentPane.add(Idioma_Field);
            Idioma_Field.setBounds(460, 145, 170, 35);

            //---- label9 ----
            label9.setText("Idioma");
            label9.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            contentPane.add(label9);
            label9.setBounds(460, 120, 105, 22);
            contentPane.add(label10);
            label10.setBounds(650, 530, 60, 50);

            //---- Bt_Agregar ----
            Bt_Agregar.setText("Agregar");
            Bt_Agregar.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Bt_Agregar.addActionListener(e -> Bt_AgregarActionPerformed(e));
            contentPane.add(Bt_Agregar);
            Bt_Agregar.setBounds(new Rectangle(new Point(525, 185), Bt_Agregar.getPreferredSize()));

            //---- Bt_Regresar ----
            Bt_Regresar.setText("Regresar");
            Bt_Regresar.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
            Bt_Regresar.addActionListener(e -> Bt_RegresarActionPerformed(e));
            contentPane.add(Bt_Regresar);
            Bt_Regresar.setBounds(new Rectangle(new Point(520, 225), Bt_Regresar.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < contentPane.getComponentCount(); i++) {
                    Rectangle bounds = contentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = contentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                contentPane.setMinimumSize(preferredSize);
                contentPane.setPreferredSize(preferredSize);
            }
            setSize(660, 305);
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JLabel label6;
        private JTextField ISBN_Field;
        private JTextField Titulo_Field;
        private JTextField Autor_Field;
        private JTextField Editorial_Field;
        private JTextField Año_Field;
        private JTextField Edicion_Field;
        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JLabel label4;
        private JLabel label5;
        private JLabel label7;
        private JTextField Categoria_Field;
        private JLabel label8;
        private JTextField Idioma_Field;
        private JLabel label9;
        private JLabel label10;
        private JButton Bt_Agregar;
        private JButton Bt_Regresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
