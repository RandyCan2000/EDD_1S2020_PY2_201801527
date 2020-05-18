
    import java.awt.event.*;

    import Metodos.Variables;
    import Modelos.Libros;

    import java.awt.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

    /*
     *  Created by JFormDesigner on Sun May 10 11:11:00 CDT 2020
     */

    /**
     * @author Usuario
     */

    public class CatalogoLibros extends JFrame
    {
        ArrayList<Libros> ArrayLibros = new ArrayList<Libros>();
        DefaultTableModel Modelo;

        public CatalogoLibros()
        {
            initComponents();
            ArrayLibros = Variables.ArbolAVLCategorias.ListarTodosLosLibrosArbolAVL();
            ObtenerLibros();
            ObtenerCategorias();
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
            Modelo.addColumn("Usuario_Creador");

            for(Libros Libro: ArrayLibros)
            {
                if (Libro != null)
                {
                    Object[] Fila = new Object[]
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
                    Modelo.addRow(Fila);
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

        private void ObtenerCategorias()
        {
            ArrayList<String> Catalogo = Variables.ArbolAVLCategorias.IniciarCatalogoArbolAVL();

            Cb_Categorias.addItem("Todos Los Libros");

            for(String Categoria: Catalogo)
            {
                if(Categoria != null)
                {
                    Cb_Categorias.addItem(Categoria);
                }
            }
        }

        public void FiltrarTabla(String Libro, JTable TablaBuscar)
        {
            TableRowSorter<DefaultTableModel> Filtro = new TableRowSorter<>(Modelo);

            TablaBuscar.setRowSorter(Filtro);
            Filtro.setRowFilter(RowFilter.regexFilter(Libro, 1));
        }

        private void Cb_CategoriasItemStateChanged(ItemEvent e)
        {
            try
            {
                String Cadena = Cb_Categorias.getSelectedItem().toString();

                if(Cadena.equals("Todos Los Libros"))
                {
                    ArrayLibros = Variables.ArbolAVLCategorias.ListarTodosLosLibrosArbolAVL();
                }
                else
                {
                    ArrayLibros = Variables.ArbolAVLCategorias.SeleccionarCategoriaLibrosAVL(Cadena);
                }
                ObtenerLibros();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        private void Bt_RegresarActionPerformed(ActionEvent e)
        {
            this.dispose();;
        }

        private void Buscar_FieldKeyReleased(KeyEvent e)
        {
            FiltrarTabla(Buscar_Field.getText(), Tb_Libros);
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            label2 = new JLabel();
            Cb_Categorias = new JComboBox();
            label4 = new JLabel();
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            Tb_Libros = new JTable();
            Bt_Regresar = new JButton();
            Buscar_Field = new JTextField();
            label5 = new JLabel();

            //======== this ========
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);
            setTitle("LIBROS POR CATALOGO");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label2);
            label2.setBounds(1115, 645, 50, 65);

            //---- Cb_Categorias ----
            Cb_Categorias.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
            Cb_Categorias.addItemListener(e -> Cb_CategoriasItemStateChanged(e));
            contentPane.add(Cb_Categorias);
            Cb_Categorias.setBounds(545, 60, 180, 30);

            //---- label4 ----
            label4.setText("Categor\u00edas:");
            label4.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
            label4.setBackground(Color.white);
            contentPane.add(label4);
            label4.setBounds(455, 65, 89, 19);

            //---- label1 ----
            label1.setText("LIBROS POR CATALOGO");
            label1.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
            label1.setBackground(Color.white);
            contentPane.add(label1);
            label1.setBounds(440, 20, 275, 26);

            //======== scrollPane1 ========
            {

                //---- Tb_Libros ----
                Tb_Libros.setModel(new DefaultTableModel(1, 0));
                Tb_Libros.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
                Tb_Libros.setGridColor(new Color(255, 51, 51));
                Tb_Libros.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
                scrollPane1.setViewportView(Tb_Libros);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(10, 105, 1260, 225);

            //---- Bt_Regresar ----
            Bt_Regresar.setText("Regresar");
            Bt_Regresar.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
            Bt_Regresar.setBackground(Color.white);
            Bt_Regresar.addActionListener(e -> Bt_RegresarActionPerformed(e));
            contentPane.add(Bt_Regresar);
            Bt_Regresar.setBounds(1135, 60, 135, Bt_Regresar.getPreferredSize().height);

            //---- Buscar_Field ----
            Buscar_Field.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
            Buscar_Field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    Buscar_FieldKeyReleased(e);
                }
            });
            contentPane.add(Buscar_Field);
            Buscar_Field.setBounds(145, 60, 300, 30);

            //---- label5 ----
            label5.setText("Buscar Libro:");
            label5.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
            label5.setBackground(Color.white);
            contentPane.add(label5);
            label5.setBounds(35, 60, 115, 30);

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
            setSize(1290, 380);
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JLabel label2;
        private JComboBox Cb_Categorias;
        private JLabel label4;
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable Tb_Libros;
        private JButton Bt_Regresar;
        private JTextField Buscar_Field;
        private JLabel label5;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
