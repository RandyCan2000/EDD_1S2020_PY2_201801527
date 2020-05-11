

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import Metodos.Variables;

    /*
     * Created by JFormDesigner on Fri May 15 07:47:01 CDT 2020
     */

    /**
      * @author Usuario
      */

    public class Configuraciones extends JFrame
    {

        public Configuraciones()
        {
            initComponents();
            Ip_Field.setText(Variables.InternalIp);
            int Puerto = Variables.NodoListaDobleBloques.getSocketUDP().getLocalPort();
            String PuertoString = String.valueOf(Puerto);
            Puerto_Field.setText(PuertoString);
            setLocationRelativeTo(null);
        }

        private void Bt_ConectarActionPerformed(ActionEvent e)
        {
            int Puerto = Integer.parseInt(PuertoServer_Field.getText());
            String Ip = IpServer_Field.getText();

            Variables.NodoListaDobleBloques.ConectarNodoRedListaDoble(Puerto, Ip);
        }

        private void Bt_RegresarActionPerformed(ActionEvent e)
        {
            this.dispose();
        }

        private void Bt_SincronizarActionPerformed(ActionEvent e)
        {
            Metodos.GenerarBloquesJSON.GenerarBloques();
        }

        private void thisWindowClosing(WindowEvent e)
        {
            this.dispose();
        }

        private void initComponents()
        {
             // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
             // Generated using JFormDesigner Evaluation license - unknown
             label1 = new JLabel();
             label3 = new JLabel();
             label4 = new JLabel();
             Ip_Field = new JTextField();
             Puerto_Field = new JTextField();
             Bt_Conectar = new JButton();
             label5 = new JLabel();
             Bt_Regresar = new JButton();
             Bt_Sincronizar = new JButton();
             label2 = new JLabel();
             label6 = new JLabel();
             label7 = new JLabel();
             label8 = new JLabel();
             IpServer_Field = new JTextField();
             PuertoServer_Field = new JTextField();

             //======== this ========
             setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
             setResizable(false);
             setTitle("Configuracion");
             addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosing(WindowEvent e) {
                     thisWindowClosing(e);
                 }
             });
             Container contentPane = getContentPane();
             contentPane.setLayout(null);

             //---- label1 ----
             label1.setText("CONFIGURACIONES");
             label1.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label1);
             label1.setBounds(new Rectangle(new Point(35, 25), label1.getPreferredSize()));

             //---- label3 ----
             label3.setText("Ip:");
             label3.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label3);
             label3.setBounds(new Rectangle(new Point(50, 100), label3.getPreferredSize()));

             //---- label4 ----
             label4.setText("Puerto:");
             label4.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label4);
             label4.setBounds(20, 140, 55, 19);

             //---- Ip_Field ----
             Ip_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             Ip_Field.setEditable(false);
             contentPane.add(Ip_Field);
             Ip_Field.setBounds(75, 95, 190, 35);

             //---- Puerto_Field ----
             Puerto_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             Puerto_Field.setEditable(false);
             contentPane.add(Puerto_Field);
             Puerto_Field.setBounds(75, 135, 190, 35);

             //---- Bt_Conectar ----
             Bt_Conectar.setText("Conectar");
             Bt_Conectar.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             Bt_Conectar.addActionListener(e -> Bt_ConectarActionPerformed(e));
             contentPane.add(Bt_Conectar);
             Bt_Conectar.setBounds(new Rectangle(new Point(30, 325), Bt_Conectar.getPreferredSize()));
             contentPane.add(label5);
             label5.setBounds(475, 485, 50, 55);

             //---- Bt_Regresar ----
             Bt_Regresar.setText("Regresar");
             Bt_Regresar.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             Bt_Regresar.addActionListener(e -> Bt_RegresarActionPerformed(e));
             contentPane.add(Bt_Regresar);
             Bt_Regresar.setBounds(new Rectangle(new Point(100, 370), Bt_Regresar.getPreferredSize()));

             //---- Bt_Sincronizar ----
             Bt_Sincronizar.setText("Sincronizar");
             Bt_Sincronizar.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             Bt_Sincronizar.addActionListener(e -> Bt_SincronizarActionPerformed(e));
             contentPane.add(Bt_Sincronizar);
             Bt_Sincronizar.setBounds(new Rectangle(new Point(140, 325), Bt_Sincronizar.getPreferredSize()));

             //---- label2 ----
             label2.setText("SESION:");
             label2.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label2);
             label2.setBounds(new Rectangle(new Point(10, 65), label2.getPreferredSize()));

             //---- label6 ----
             label6.setText("Puerto:");
             label6.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label6);
             label6.setBounds(20, 275, 60, 19);

             //---- label7 ----
             label7.setText("Ip:");
             label7.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label7);
             label7.setBounds(50, 230, 23, 22);

             //---- label8 ----
             label8.setText("CONECTARSE A...");
             label8.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(label8);
             label8.setBounds(10, 190, 240, 19);

             //---- IpServer_Field ----
             IpServer_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(IpServer_Field);
             IpServer_Field.setBounds(75, 225, 190, 35);

             //---- PuertoServer_Field ----
             PuertoServer_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
             contentPane.add(PuertoServer_Field);
             PuertoServer_Field.setBounds(75, 265, 190, 35);

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
             setSize(280, 440);
             setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JLabel label1;
        private JLabel label3;
        private JLabel label4;
        private JTextField Ip_Field;
        private JTextField Puerto_Field;
        private JButton Bt_Conectar;
        private JLabel label5;
        private JButton Bt_Regresar;
        private JButton Bt_Sincronizar;
        private JLabel label2;
        private JLabel label6;
        private JLabel label7;
        private JLabel label8;
        private JTextField IpServer_Field;
        private JTextField PuertoServer_Field;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
