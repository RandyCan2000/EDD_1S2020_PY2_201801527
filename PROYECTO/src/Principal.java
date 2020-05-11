
     import java.awt.*;
     import java.awt.event.*;
     import java.net.InetAddress;
     import java.net.UnknownHostException;
     import java.util.ArrayList;
     import javax.swing.*;
     import Estructuras.NodoArbolAVL;
     import Estructuras.NodoListaDoble;
     import Estructuras.NodoListaSimple;
     import Metodos.Variables;
     import Metodos.LecturaJson;

     /*
      * Created by JFormDesigner on Mon Apr 27 16:33:26 CDT 2020
      */


     /**
      * @author Usuario
      */

     public class Principal extends JFrame
     {
         public Principal()
         {
             initComponents();
             Variables.Principal = this;
         }

         public static void main(String[] args) throws UnknownHostException
         {
             Variables.OsName = System.getProperty("os.name").replaceAll("\\s","");
             Metodos.Metodos.ObtenerInternalIp();
             Metodos.Metodos.CalcularNumeroIndex();
             Variables.NodoListaDobleBloques = new NodoListaDoble();
             Variables.NodoListaDobleBloques.start();
             NodoListaSimple NuevoBloque = new NodoListaSimple();
             NuevoBloque.setPuerto(Variables.NodoListaDobleBloques.getSocketUDP().getLocalPort());
             InetAddress Ip = InetAddress.getByName(Variables.InternalIp);
             NuevoBloque.setIp(Ip);
             Variables.ListaSimpleRed.InsertarNodoRedListaSimple(NuevoBloque);
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new Login().setVisible(true);
                 }
             });
         }

         private void Bt_AgregarUsuariosActionPerformed(ActionEvent e)
         {
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new RegistroUsuario().setVisible(true);
                 }
             });
         }

         private void Bt_AgregarLibrosActionPerformed(ActionEvent e)
         {
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new RegistroLibros().setVisible(true);
                 }
             });
         }

         private void Bt_LogoutActionPerformed(ActionEvent e)
         {
             this.setVisible(false);
             Variables.EstoyEnLogin = true;
             Variables.NumeroCarnetUsuarioLog = 0;
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new Login().setVisible(true);
                 }
             });
         }

         private void Bt_SalirActionPerformed(ActionEvent e)
         {
             this.dispose();
             Variables.NodoListaDobleBloques.SalirNodoRedListaDoble();
             Variables.NodoListaDobleBloques.stop();
             System.exit(0);
         }

         private void Bt_PerfilActionPerformed(ActionEvent e)
         {
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new Perfil().setVisible(true);
                 }
             });
         }

         private void Bt_CategoriasActionPerformed(ActionEvent e)
         {
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new RegistroCategorias().setVisible(true);
                 }
             });
         }

         private void Bt_CatalogoActionPerformed(ActionEvent e)
         {
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new CatalogoLibros().setVisible(true);
                 }
             });
         }

         private void Bt_EliminacionActionPerformed(ActionEvent e)
         {
             java.awt.EventQueue.invokeLater(new Runnable() {
                 @Override
                 public void run()
                 {
                     new LibrosOperaciones().setVisible(true);
                 }
             });
         }

         private void Bt_JSONUsuariosActionPerformed(ActionEvent e)
         {
             LecturaJson.JSONUsuarios(this);
         }

         private void Bt_JSONLibrosActionPerformed(ActionEvent e)
         {
             LecturaJson.JSONLibros(this);
         }

         private void Bt_UsuariosReporteActionPerformed(ActionEvent e)
         {
             Variables.NombreReporte = "ReporteUsuariosTablaHash.png";
             Variables.TablaHashUsuarios.ReporteTablaHashUsuarios();

             if(Variables.GenereReporte)
             {
                 JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                 java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run()
                     {
                         new Reportes().setVisible(true);
                     }
                 });
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
             }
         }

         private void Bt_CategoriasReporteActionPerformed(ActionEvent e)
         {
             Variables.NombreReporte = "ReporteCategoriasArbolAVL.png";
             Variables.ArbolAVLCategorias.GraficarArbolAVL();

             if(Variables.GenereReporte)
             {
                 JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                 java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run()
                     {
                         new Reportes().setVisible(true);
                     }
                 });
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
             }
         }

         private void Bt_LibrosReporteActionPerformed(ActionEvent e)
         {
             ArrayList<String> Categorias = Variables.ArbolAVLCategorias.IniciarCatalogoArbolAVL();

             JComboBox<String> Cat = new JComboBox<String>();
             Cat.setEditable(true);
             Cat.setFont(new Font("Arial", Font.BOLD, 16));
             Cat.setForeground(new Color(0, 153, 255));

             for(String Categoria: Categorias)
             {
                 if(Categoria != null)
                 {
                     Cat.addItem(Categoria);
                 }
             }

             int Mensaje = JOptionPane.showConfirmDialog(null, Cat, "Seleccione Una Categoría", JOptionPane.OK_CANCEL_OPTION);

             if(Mensaje == JOptionPane.OK_OPTION)
             {
                 if(!Cat.getSelectedItem().toString().equals(""))
                 {
                     String Categoria = "";

                     Categoria = Cat.getSelectedItem().toString();

                     NodoArbolAVL ArbolB = Variables.ArbolAVLCategorias.InicializarBuscarCategoriaArbolAVL(Categoria);

                     if(ArbolB != null)
                     {
                         Variables.NombreReporte = "ReporteLibrosArbolB.png";
                         Variables.ArbolAVLCategorias.GraficarLibrosArbolAVL(ArbolB);

                         if(Variables.GenereReporte)
                         {
                             JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                             java.awt.EventQueue.invokeLater(new Runnable() {
                                 @Override
                                 public void run()
                                 {
                                     new Reportes().setVisible(true);
                                 }
                             });
                         }
                         else
                         {
                             JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
                         }
                     }
                 }
             }
             else
             {
                 System.out.println("Nada");
             }
         }

         private void Bt_RecorridosReporteActionPerformed(ActionEvent e)
         {
             Variables.NombreReporte = "ReporteRecorridosArbolAVL.png";
             Variables.ArbolAVLCategorias.GraficarRecorridosArbolAVL();

             if(Variables.GenereReporte)
             {
                 JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                 java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run()
                     {
                         new Reportes().setVisible(true);
                     }
                 });
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
             }
         }

         private void Bt_NodosReporteActionPerformed(ActionEvent e)
         {
             Variables.NombreReporte = "ReporteNodoDeRedListaSimple.png";
             Variables.ListaSimpleRed.GraficarRedListaSimple();

             if(Variables.GenereReporte)
             {
                 JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                 java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run()
                     {
                         new Reportes().setVisible(true);
                     }
                 });
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
             }
         }

         private void Bt_BlockchainReporteActionPerformed(ActionEvent e)
         {
             Variables.NombreReporte = "ReporteBloquesListaDoble.png";
             Variables.ListaDobleBloques.GraficarBloquesListaDoble();

             if(Variables.GenereReporte)
             {
                 JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                 java.awt.EventQueue.invokeLater(new Runnable() {
                     @Override
                     public void run()
                     {
                         new Reportes().setVisible(true);
                     }
                 });
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
             }
         }

         private void Bt_SincronizarActionPerformed(ActionEvent e)
         {
              Metodos.GenerarBloquesJSON.GenerarBloques();
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
             menuBar1 = new JMenuBar();
             menu1 = new JMenu();
             Bt_AgregarUsuarios = new JMenuItem();
             Bt_AgregarLibros = new JMenuItem();
             Bt_Logout = new JMenuItem();
             Bt_Salir = new JMenuItem();
             menu2 = new JMenu();
             Bt_Configuracion = new JMenuItem();
             Bt_Sincronizar = new JMenuItem();
             Bt_JSONUsuarios = new JMenuItem();
             Bt_JSONLibros = new JMenuItem();
             menu3 = new JMenu();
             Bt_UsuariosReporte = new JMenuItem();
             Bt_CategoriasReporte = new JMenuItem();
             Bt_RecorridosReporte = new JMenuItem();
             Bt_LibrosReporte = new JMenuItem();
             Bt_NodosReporte = new JMenuItem();
             Bt_BlockchainReporte = new JMenuItem();
             label1 = new JLabel();
             Bt_Perfil = new JButton();
             Bt_Catalogo = new JButton();
             Bt_Categorias = new JButton();
             Bt_Eliminacion = new JButton();

             //======== this ========
             setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
             setForeground(Color.black);
             setResizable(false);
             setTitle("MENU");
             addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosing(WindowEvent e) {
                     thisWindowClosing(e);
                 }
             });
             Container contentPane = getContentPane();
             contentPane.setLayout(null);

             //======== menuBar1 ========
             {

                 //======== menu1 ========
                 {
                     menu1.setText("OPCIONES");
                     menu1.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     menu1.setIcon(null);

                     //---- Bt_AgregarUsuarios ----
                     Bt_AgregarUsuarios.setText("AGREGAR USUARIOS");
                     Bt_AgregarUsuarios.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_AgregarUsuarios.setIcon(null);
                     Bt_AgregarUsuarios.addActionListener(e -> Bt_AgregarUsuariosActionPerformed(e));
                     menu1.add(Bt_AgregarUsuarios);

                     //---- Bt_AgregarLibros ----
                     Bt_AgregarLibros.setText("AGREGAR LIBROS");
                     Bt_AgregarLibros.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_AgregarLibros.setIcon(null);
                     Bt_AgregarLibros.addActionListener(e -> Bt_AgregarLibrosActionPerformed(e));
                     menu1.add(Bt_AgregarLibros);

                     //---- Bt_Logout ----
                     Bt_Logout.setText("CERRAR SESION");
                     Bt_Logout.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_Logout.setIcon(null);
                     Bt_Logout.addActionListener(e -> Bt_LogoutActionPerformed(e));
                     menu1.add(Bt_Logout);

                     //---- Bt_Salir ----
                     Bt_Salir.setText("SALIR");
                     Bt_Salir.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_Salir.setIcon(null);
                     Bt_Salir.addActionListener(e -> {
			Bt_SalirActionPerformed(e);
			Bt_SalirActionPerformed(e);
		});
                     menu1.add(Bt_Salir);
                 }
                 menuBar1.add(menu1);

                 //======== menu2 ========
                 {
                     menu2.setText("HERRAMIENTAS");
                     menu2.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     menu2.setIcon(null);

                     //---- Bt_Configuracion ----
                     Bt_Configuracion.setText("CONFIGURACION");
                     Bt_Configuracion.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_Configuracion.setIcon(null);
                     Bt_Configuracion.addActionListener(e -> Bt_ConfiguracionActionPerformed(e));
                     menu2.add(Bt_Configuracion);

                     //---- Bt_Sincronizar ----
                     Bt_Sincronizar.setText("SINCRONIZAR");
                     Bt_Sincronizar.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_Sincronizar.setIcon(null);
                     Bt_Sincronizar.addActionListener(e -> Bt_SincronizarActionPerformed(e));
                     menu2.add(Bt_Sincronizar);

                     //---- Bt_JSONUsuarios ----
                     Bt_JSONUsuarios.setText("USARIOS JSON");
                     Bt_JSONUsuarios.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_JSONUsuarios.setIcon(null);
                     Bt_JSONUsuarios.addActionListener(e -> Bt_JSONUsuariosActionPerformed(e));
                     menu2.add(Bt_JSONUsuarios);

                     //---- Bt_JSONLibros ----
                     Bt_JSONLibros.setText("LIBROS JSON");
                     Bt_JSONLibros.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_JSONLibros.setIcon(null);
                     Bt_JSONLibros.addActionListener(e -> Bt_JSONLibrosActionPerformed(e));
                     menu2.add(Bt_JSONLibros);
                 }
                 menuBar1.add(menu2);

                 //======== menu3 ========
                 {
                     menu3.setText("REPORTES");
                     menu3.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     menu3.setIcon(null);

                     //---- Bt_UsuariosReporte ----
                     Bt_UsuariosReporte.setText("TABLA HASH");
                     Bt_UsuariosReporte.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_UsuariosReporte.setIcon(null);
                     Bt_UsuariosReporte.addActionListener(e -> {
			Bt_UsuariosReporteActionPerformed(e);
			Bt_UsuariosReporteActionPerformed(e);
			Bt_UsuariosReporteActionPerformed(e);
		});
                     menu3.add(Bt_UsuariosReporte);

                     //---- Bt_CategoriasReporte ----
                     Bt_CategoriasReporte.setText("CATEGORIA");
                     Bt_CategoriasReporte.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_CategoriasReporte.setIcon(null);
                     Bt_CategoriasReporte.addActionListener(e -> {
			Bt_CategoriasReporteActionPerformed(e);
			Bt_CategoriasReporteActionPerformed(e);
		});
                     menu3.add(Bt_CategoriasReporte);

                     //---- Bt_RecorridosReporte ----
                     Bt_RecorridosReporte.setText("RECORRIDOS");
                     Bt_RecorridosReporte.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_RecorridosReporte.setIcon(null);
                     Bt_RecorridosReporte.addActionListener(e -> {
			Bt_RecorridosReporteActionPerformed(e);
			Bt_RecorridosReporteActionPerformed(e);
		});
                     menu3.add(Bt_RecorridosReporte);

                     //---- Bt_LibrosReporte ----
                     Bt_LibrosReporte.setText("ARBOL B");
                     Bt_LibrosReporte.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_LibrosReporte.setIcon(null);
                     Bt_LibrosReporte.addActionListener(e -> {
			Bt_LibrosReporteActionPerformed(e);
			Bt_LibrosReporteActionPerformed(e);
		});
                     menu3.add(Bt_LibrosReporte);

                     //---- Bt_NodosReporte ----
                     Bt_NodosReporte.setText("NODOS DE RED");
                     Bt_NodosReporte.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_NodosReporte.setIcon(null);
                     Bt_NodosReporte.addActionListener(e -> {
			Bt_NodosReporteActionPerformed(e);
			Bt_NodosReporteActionPerformed(e);
		});
                     menu3.add(Bt_NodosReporte);

                     //---- Bt_BlockchainReporte ----
                     Bt_BlockchainReporte.setText("BLOCKCHAIN");
                     Bt_BlockchainReporte.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                     Bt_BlockchainReporte.setIcon(null);
                     Bt_BlockchainReporte.addActionListener(e -> {
			Bt_BlockchainReporteActionPerformed(e);
			Bt_BlockchainReporteActionPerformed(e);
		});
                     menu3.add(Bt_BlockchainReporte);
                 }
                 menuBar1.add(menu3);
             }
             setJMenuBar(menuBar1);
             contentPane.add(label1);
             label1.setBounds(675, 405, 45, 55);

             //---- Bt_Perfil ----
             Bt_Perfil.setText("PERFIL");
             Bt_Perfil.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
             Bt_Perfil.addActionListener(e -> Bt_PerfilActionPerformed(e));
             contentPane.add(Bt_Perfil);
             Bt_Perfil.setBounds(65, 25, 210, Bt_Perfil.getPreferredSize().height);

             //---- Bt_Catalogo ----
             Bt_Catalogo.setText("CATALOGOS");
             Bt_Catalogo.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
             Bt_Catalogo.addActionListener(e -> Bt_CatalogoActionPerformed(e));
             contentPane.add(Bt_Catalogo);
             Bt_Catalogo.setBounds(65, 100, 210, Bt_Catalogo.getPreferredSize().height);

             //---- Bt_Categorias ----
             Bt_Categorias.setText("CATEGORIAS");
             Bt_Categorias.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
             Bt_Categorias.addActionListener(e -> Bt_CategoriasActionPerformed(e));
             contentPane.add(Bt_Categorias);
             Bt_Categorias.setBounds(65, 65, 210, Bt_Categorias.getPreferredSize().height);

             //---- Bt_Eliminacion ----
             Bt_Eliminacion.setText("ELIMINAR LIBROS");
             Bt_Eliminacion.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
             Bt_Eliminacion.addActionListener(e -> Bt_EliminacionActionPerformed(e));
             contentPane.add(Bt_Eliminacion);
             Bt_Eliminacion.setBounds(65, 135, 210, Bt_Eliminacion.getPreferredSize().height);

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
             setSize(335, 245);
             setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
         }

         // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
         // Generated using JFormDesigner Evaluation license - unknown
         private JMenuBar menuBar1;
         private JMenu menu1;
         private JMenuItem Bt_AgregarUsuarios;
         private JMenuItem Bt_AgregarLibros;
         private JMenuItem Bt_Logout;
         private JMenuItem Bt_Salir;
         private JMenu menu2;
         private JMenuItem Bt_Configuracion;
         private JMenuItem Bt_Sincronizar;
         private JMenuItem Bt_JSONUsuarios;
         private JMenuItem Bt_JSONLibros;
         private JMenu menu3;
         private JMenuItem Bt_UsuariosReporte;
         private JMenuItem Bt_CategoriasReporte;
         private JMenuItem Bt_RecorridosReporte;
         private JMenuItem Bt_LibrosReporte;
         private JMenuItem Bt_NodosReporte;
         private JMenuItem Bt_BlockchainReporte;
         private JLabel label1;
         private JButton Bt_Perfil;
         private JButton Bt_Catalogo;
         private JButton Bt_Categorias;
         private JButton Bt_Eliminacion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
     }
