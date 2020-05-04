
    import Metodos.Metodos;
    import Metodos.Variables;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

    /*
     * Created by JFormDesigner on Wed Apr 29 09:07:58 CDT 2020
     */

    /**
     * @author Usuario
     */

    public class Login extends JFrame
    {
        public Login()
        {
            initComponents();
            Variables.EstoyEnLogin = true;

        }

        private void BT_IngresarActionPerformed(ActionEvent e)
        {
            if(Metodos.ValidarUsuario(User_Field.getText(), Pass_Field.getText()))
            {
                this.dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run()
                    {
                        new Principal().setVisible(true);
                    }
                });
            }
            else
            {
                User_Field.setText("");
                Pass_Field.setText("");
            }
        }

        private void BT_RegistrarActionPerformed(ActionEvent e)
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    new RegistroUsuario().setVisible(true);
                }
            });
        }

        private void User_FieldKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();
            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        private void Bt_ConfiguracionActionPerformed(ActionEvent e)
        {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    new Configuraciones().setVisible(true);
                }
            });
        }

        private void thisWindowClosing(WindowEvent e)
        {
            this.dispose();
            Variables.NodoListaDobleBloques.SalirNodoRedListaDoble();
            Variables.NodoListaDobleBloques.stop();
            System.exit(0);
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            User_Field = new JTextField();
            BT_Ingresar = new JButton();
            Pass_Field = new JPasswordField();
            BT_Registrar = new JButton();
            label1 = new JLabel();
            label2 = new JLabel();
            label3 = new JLabel();
            label4 = new JLabel();
            Bt_Configuracion = new JButton();

            //======== this ========
            setTitle("LOGIN");
            setFont(new Font("Arial", Font.BOLD, 14));
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    thisWindowClosing(e);
                }
            });
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- User_Field ----
            User_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            User_Field.setForeground(Color.black);
            User_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    User_FieldKeyTyped(e);
                }
            });
            contentPane.add(User_Field);
            User_Field.setBounds(115, 85, 195, 35);

            //---- BT_Ingresar ----
            BT_Ingresar.setText("Ingresar");
            BT_Ingresar.setForeground(Color.black);
            BT_Ingresar.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            BT_Ingresar.addActionListener(e -> BT_IngresarActionPerformed(e));
            contentPane.add(BT_Ingresar);
            BT_Ingresar.setBounds(new Rectangle(new Point(45, 185), BT_Ingresar.getPreferredSize()));

            //---- Pass_Field ----
            Pass_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Pass_Field.setForeground(Color.black);
            contentPane.add(Pass_Field);
            Pass_Field.setBounds(115, 135, 195, 35);

            //---- BT_Registrar ----
            BT_Registrar.setText("Registrarse");
            BT_Registrar.setForeground(Color.black);
            BT_Registrar.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            BT_Registrar.addActionListener(e -> BT_RegistrarActionPerformed(e));
            contentPane.add(BT_Registrar);
            BT_Registrar.setBounds(new Rectangle(new Point(155, 185), BT_Registrar.getPreferredSize()));
            contentPane.add(label1);
            label1.setBounds(570, 380, 20, 45);

            //---- label2 ----
            label2.setText("Carnet:");
            label2.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            label2.setForeground(Color.black);
            contentPane.add(label2);
            label2.setBounds(new Rectangle(new Point(5, 95), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("Contrase\u00f1a:");
            label3.setForeground(Color.black);
            label3.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            contentPane.add(label3);
            label3.setBounds(new Rectangle(new Point(5, 140), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("LOGIN");
            label4.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            label4.setForeground(Color.black);
            contentPane.add(label4);
            label4.setBounds(new Rectangle(new Point(130, 30), label4.getPreferredSize()));

            //---- Bt_Configuracion ----
            Bt_Configuracion.setText("Configuraci\u00f3n");
            Bt_Configuracion.setFont(new Font("Century Schoolbook", Font.PLAIN, 18));
            Bt_Configuracion.setForeground(Color.black);
            Bt_Configuracion.addActionListener(e -> Bt_ConfiguracionActionPerformed(e));
            contentPane.add(Bt_Configuracion);
            Bt_Configuracion.setBounds(new Rectangle(new Point(90, 230), Bt_Configuracion.getPreferredSize()));

            contentPane.setPreferredSize(new Dimension(335, 315));
            setSize(335, 315);
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JTextField User_Field;
        private JButton BT_Ingresar;
        private JPasswordField Pass_Field;
        private JButton BT_Registrar;
        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JLabel label4;
        private JButton Bt_Configuracion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
