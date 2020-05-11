
import java.awt.event.*;
   import Metodos.Variables;
   import Modelos.Libros;
import javafx.scene.control.TableRow;

import java.awt.*;
   import java.util.ArrayList;
   import javax.swing.*;
   import javax.swing.table.*;

   /*
    *  Created by JFormDesigner on Mon May 11 11:20:56 CDT 2020
    */


   /**
    * @author Usuario
    */

    public class LibrosOperaciones extends JFrame
    {

        ArrayList<Libros> ListaDeLibros =new ArrayList<Libros>();
        DefaultTableModel Modelo;
        String ISBN = "";
        String Nombre = "";

        public LibrosOperaciones()
        {
            initComponents();
            ListaDeLibros = Variables.ArbolAVLCategorias.ListarTodosLosLibrosArbolAVL();
            ObtenerLibros();
            setLocationRelativeTo(null);
        }

        public void ObtenerLibros()
        {
            Modelo = new DefaultTableModel();

            Modelo.addColumn("ISBN");
            Modelo.addColumn("Título");
            Modelo.addColumn("Autor");
            Modelo.addColumn("Editorial");
            Modelo.addColumn("Año");
            Modelo.addColumn("Edición");
            Modelo.addColumn("Categoría");
            Modelo.addColumn("Idioma");
            Modelo.addColumn("Carnet_Creador");

            for(Libros Libro: ListaDeLibros)
            {
                if(Libro != null)
                {
                    Object[] Valor = new Object[]
                            {
                                    Libro.getISBN(),
                                    Libro.getTitulo(),
                                    Libro.getAutor(),
                                    Libro.getEditorial(),
                                    Libro.getAnio(),
                                    Libro.getEdicion(),
                                    Libro.getCategoria(),
                                    Libro.getIdioma(),
                                    Libro.getCarnet_Usuario_Creador()
                            };
                    Modelo.addRow(Valor);
                }
            }

            Tb_Libros.setModel(Modelo);

            Tb_Libros.getColumnModel().getColumn(0).setPreferredWidth(10);
            Tb_Libros.getColumnModel().getColumn(1).setPreferredWidth(400);
            Tb_Libros.getColumnModel().getColumn(2).setPreferredWidth(100);
            Tb_Libros.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tb_Libros.getColumnModel().getColumn(4).setPreferredWidth(5);
            Tb_Libros.getColumnModel().getColumn(5).setPreferredWidth(5);
            Tb_Libros.getColumnModel().getColumn(6).setPreferredWidth(40);
            Tb_Libros.getColumnModel().getColumn(7).setPreferredWidth(40);
            Tb_Libros.getColumnModel().getColumn(8).setPreferredWidth(40);
            Tb_Libros.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        private void Bt_RegresarActionPerformed(ActionEvent e)
        {
            this.dispose();
        }

        public void FiltrarTabla(String Libro, JTable TablaBuscar)
        {
            TableRowSorter<DefaultTableModel> Filtro = new TableRowSorter<>(Modelo);

            TablaBuscar.setRowSorter(Filtro);
            Filtro.setRowFilter(RowFilter.regexFilter(Libro, 1));
        }

        private void Buscar_FieldKeyReleased(KeyEvent e)
        {
            FiltrarTabla(Buscar_Field.getText(), Tb_Libros);
        }

        private void Tb_LibrosMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = Tb_Libros.getSelectedRow();

            String Valor = Tb_Libros.getValueAt(Fila, Columna).toString();
            ISBN = Valor;
            Nombre = Tb_Libros.getValueAt(Fila, 1).toString();

            Eliminar_Field.setText(Valor);
        }

        private void Bt_EliminarActionPerformed(ActionEvent e)
        {
            try
            {
                int ISBN = Integer.parseInt(Eliminar_Field.getText());
                int Button = JOptionPane.YES_NO_OPTION;
                int Result = JOptionPane.showConfirmDialog(this, "Seguro Que Desea Eliminar El Libro: \nISBN: " + ISBN + "\nTitulo: " + Nombre, "Pregunta!", Button);

                if(Result == 0)
                {
                    Libros LibroBorrar = Variables.ArbolAVLCategorias.InicizalizarEliminacionArboAVL(ISBN, Variables.NumeroCarnetUsuarioLog);

                    if(LibroBorrar != null)
                    {
                        JOptionPane.showMessageDialog(null, "Libro Eliminado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Se Puede Eliminar El Libro Indicado \nDebido A Que Usted No Agrego Ese Libro", "Advertencia!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else
                {
                    Eliminar_Field.setText("");
                    Buscar_Field.setText("");
                }

            }
            catch(Exception Ex)
            {
                JOptionPane.showMessageDialog(null, "No Se Ha Seleccionado Un Libro", "Advertencia!", JOptionPane.WARNING_MESSAGE);
            }

            Buscar_Field.setText("");
            Eliminar_Field.setText("");
            ListaDeLibros = Variables.ArbolAVLCategorias.ListarTodosLosLibrosArbolAVL();
            ObtenerLibros();
            Eliminar_Field.setText("SELECCION EL LIBRO A ELIMINAR");
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            Tb_Libros = new JTable();
            label2 = new JLabel();
            Bt_Regresar = new JButton();
            Buscar_Field = new JTextField();
            label3 = new JLabel();
            Eliminar_Field = new JTextField();
            Bt_Eliminar = new JButton();

            //======== this ========
            setResizable(false);
            setTitle("ELIMINAR...");
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label1 ----
            label1.setText("FORMULARIO DE ELIMINACION");
            label1.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            contentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(545, 20), label1.getPreferredSize()));

            //======== scrollPane1 ========
            {

                //---- Tb_Libros ----
                Tb_Libros.setModel(new DefaultTableModel(2, 0));
                Tb_Libros.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
                Tb_Libros.setBackground(Color.white);
                Tb_Libros.setGridColor(new Color(255, 51, 51));
                Tb_Libros.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Tb_LibrosMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(Tb_Libros);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(10, 95, 1230, 230);
            contentPane.add(label2);
            label2.setBounds(1280, 665, 35, 45);

            //---- Bt_Regresar ----
            Bt_Regresar.setText("Regresar");
            Bt_Regresar.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            Bt_Regresar.addActionListener(e -> Bt_RegresarActionPerformed(e));
            contentPane.add(Bt_Regresar);
            Bt_Regresar.setBounds(new Rectangle(new Point(1130, 60), Bt_Regresar.getPreferredSize()));

            //---- Buscar_Field ----
            Buscar_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            Buscar_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    Buscar_FieldKeyReleased(e);
                }
            });
            contentPane.add(Buscar_Field);
            Buscar_Field.setBounds(20, 55, 300, Buscar_Field.getPreferredSize().height);

            //---- label3 ----
            label3.setText("Buscar Libro:");
            label3.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            contentPane.add(label3);
            label3.setBounds(20, 25, 115, 30);

            //---- Eliminar_Field ----
            Eliminar_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            Eliminar_Field.setText("SELECCION EL LIBRO A ELIMINAR");
            contentPane.add(Eliminar_Field);
            Eliminar_Field.setBounds(335, 50, 320, 35);

            //---- Bt_Eliminar ----
            Bt_Eliminar.setText("Eliminar");
            Bt_Eliminar.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            Bt_Eliminar.addActionListener(e -> {
			Bt_EliminarActionPerformed(e);
			Bt_EliminarActionPerformed(e);
			Bt_EliminarActionPerformed(e);
		});
            contentPane.add(Bt_Eliminar);
            Bt_Eliminar.setBounds(new Rectangle(new Point(665, 50), Bt_Eliminar.getPreferredSize()));

            contentPane.setPreferredSize(new Dimension(1250, 375));
            setSize(1250, 375);
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable Tb_Libros;
        private JLabel label2;
        private JButton Bt_Regresar;
        private JTextField Buscar_Field;
        private JLabel label3;
        private JTextField Eliminar_Field;
        private JButton Bt_Eliminar;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
