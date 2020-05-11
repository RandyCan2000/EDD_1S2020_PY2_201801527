
    import Metodos.Metodos;
    import Metodos.Variables;
    import Modelos.Usuarios;
    import Metodos.MD5;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

    /*
     * Created by JFormDesigner on Fri May 01 17:40:46 CDT 2020
     */

    /**
     * @author Usuario
     */

    public class Perfil extends JFrame
    {
        public Perfil()
        {
            initComponents();
            PerfilActual();
            setLocationRelativeTo(null);
        }

        private void PerfilActual()
        {
            Usuarios UsuarioActual = Variables.TablaHashUsuarios.BuscarUsuarios(Variables.NumeroCarnetUsuarioLog);

            String Carnet = "" + UsuarioActual.getCarnet();

            Carnet_Field.setText(Carnet);
            Nombre_Field.setText(UsuarioActual.getNombre());
            Apellido_Field.setText(UsuarioActual.getApellido());
            Carrera_Field.setText(UsuarioActual.getCarrera());
        }

        private void Carnet_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        private void Nombre_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Apellido_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Carrera_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void Bt_ModificarActionPerformed(ActionEvent e)
        {
            int Carnet = Integer.parseInt(Carnet_Field.getText());

            if(Contraseña_Field.getText().equals(""))
            {
                Usuarios UsuarioModificar = Variables.TablaHashUsuarios.BuscarUsuarios(Variables.NumeroCarnetUsuarioLog);
                Metodos.ModificarUsuario(Carnet, Nombre_Field.getText(), Apellido_Field.getText(), Carrera_Field.getText(), UsuarioModificar.getPassword());
            }
            else
            {
                String Pass = MD5.EncriptarPassword(Contraseña_Field.getText());
                Metodos.ModificarUsuario(Carnet, Nombre_Field.getText(), Apellido_Field.getText(), Carrera_Field.getText(), Pass);
            }
        }

        private void Bt_EliminarActionPerformed(ActionEvent e)
        {
            Variables.TablaHashUsuarios.BorrarUsuarios(Variables.NumeroCarnetUsuarioLog);

            JOptionPane.showMessageDialog(null, "Perfil Eliminado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
            Variables.Principal.dispose();
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    new Login().setVisible(true);
                }
            });

        }

        private void Bt_RegresarActionPerformed(ActionEvent e)
        {
            this.dispose();
        }

        private void Bt_RegistrarActionPerformed(ActionEvent e) {
            // TODO add your code here
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            Bt_Modificar = new JButton();
            Bt_Regresar = new JButton();
            label4 = new JLabel();
            Carrera_Field = new JTextField();
            Apellido_Field = new JTextField();
            label3 = new JLabel();
            label2 = new JLabel();
            Nombre_Field = new JTextField();
            label1 = new JLabel();
            Carnet_Field = new JTextField();
            label6 = new JLabel();
            label7 = new JLabel();
            Bt_Eliminar = new JButton();
            label5 = new JLabel();
            Contraseña_Field = new JPasswordField();

            //======== this ========
            setTitle("Perfil");
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- Bt_Modificar ----
            Bt_Modificar.setText("Modificar");
            Bt_Modificar.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Bt_Modificar.addActionListener(e -> {
			Bt_RegistrarActionPerformed(e);
			Bt_ModificarActionPerformed(e);
		});
            contentPane.add(Bt_Modificar);
            Bt_Modificar.setBounds(255, 100, 125, 40);

            //---- Bt_Regresar ----
            Bt_Regresar.setText("Regresar");
            Bt_Regresar.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Bt_Regresar.addActionListener(e -> {
			Bt_RegresarActionPerformed(e);
			Bt_RegresarActionPerformed(e);
		});
            contentPane.add(Bt_Regresar);
            Bt_Regresar.setBounds(260, 320, 120, 40);

            //---- label4 ----
            label4.setText("Carrera:");
            label4.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label4);
            label4.setBounds(20, 250, 72, 22);

            //---- Carrera_Field ----
            Carrera_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Carrera_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Carrera_FieldKeyTyped(e);
                }
            });
            contentPane.add(Carrera_Field);
            Carrera_Field.setBounds(20, 275, 190, 35);

            //---- Apellido_Field ----
            Apellido_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Apellido_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Apellido_FieldKeyTyped(e);
                }
            });
            contentPane.add(Apellido_Field);
            Apellido_Field.setBounds(20, 210, 190, 35);

            //---- label3 ----
            label3.setText("Apellido:");
            label3.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label3);
            label3.setBounds(20, 185, 79, 22);

            //---- label2 ----
            label2.setText("Nombre:");
            label2.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label2);
            label2.setBounds(20, 120, 77, 22);

            //---- Nombre_Field ----
            Nombre_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Nombre_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Nombre_FieldKeyTyped(e);
                }
            });
            contentPane.add(Nombre_Field);
            Nombre_Field.setBounds(20, 145, 190, 35);

            //---- label1 ----
            label1.setText("Carnet:");
            label1.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label1);
            label1.setBounds(20, 55, 65, 22);

            //---- Carnet_Field ----
            Carnet_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Carnet_Field.setEditable(false);
            Carnet_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Carnet_FieldKeyTyped(e);
                }
            });
            contentPane.add(Carnet_Field);
            Carnet_Field.setBounds(20, 80, 190, 35);

            //---- label6 ----
            label6.setText("PERFIL");
            label6.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label6);
            label6.setBounds(160, 15, 80, 24);
            contentPane.add(label7);
            label7.setBounds(565, 450, 50, 35);

            //---- Bt_Eliminar ----
            Bt_Eliminar.setText("Eliminar");
            Bt_Eliminar.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Bt_Eliminar.addActionListener(e -> {
			Bt_RegistrarActionPerformed(e);
			Bt_EliminarActionPerformed(e);
		});
            contentPane.add(Bt_Eliminar);
            Bt_Eliminar.setBounds(255, 145, 125, 40);

            //---- label5 ----
            label5.setText("Contrase\u00f1a:");
            label5.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label5);
            label5.setBounds(20, 315, 107, 22);

            //---- Contraseña_Field ----
            Contraseña_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(Contraseña_Field);
            Contraseña_Field.setBounds(20, 340, 190, 35);

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
            setSize(390, 415);
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JButton Bt_Modificar;
        private JButton Bt_Regresar;
        private JLabel label4;
        private JTextField Carrera_Field;
        private JTextField Apellido_Field;
        private JLabel label3;
        private JLabel label2;
        private JTextField Nombre_Field;
        private JLabel label1;
        private JTextField Carnet_Field;
        private JLabel label6;
        private JLabel label7;
        private JButton Bt_Eliminar;
        private JLabel label5;
        private JPasswordField Contraseña_Field;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
