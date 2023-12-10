package Gestor;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Libreria extends javax.swing.JFrame {

    public static final String url = "jdbc:mysql://localhost:3306/libreria";
    public static final String user = "root";
    public static final String pass = "admin";
    
    DefaultTableModel modelo;
     
    
    public Libreria() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Id");
        modelo.addColumn("Titulo");
        modelo.addColumn("Autor");
        modelo.addColumn("Genero");
        
        mostrarDatos();
    }
    
    
    public void mostrarDatos(){
        
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT id, titulo, autor, genero FROM libro";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            modelo.setRowCount(0);
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                
                modelo.addRow(new Object[]{id, titulo, autor, genero});
            }
            
            jTDatos.setModel(modelo);
            rs.close();
            ps.close();
            conexion.close();
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    
    }
    public Connection getConnection(){
        
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conexion;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        vistaIngreso = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLId = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jLAutor = new javax.swing.JLabel();
        jLGenero = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jTTitulo = new javax.swing.JTextField();
        jTAutor = new javax.swing.JTextField();
        jTGenero = new javax.swing.JTextField();
        jBtnAgregar = new javax.swing.JButton();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vistaIngreso.setBackground((new Color(255,255,255,1)));

        titulo.setBackground(new java.awt.Color(155, 135, 255));
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(155, 135, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Libreria<L>Coltis");
        titulo.setToolTipText("");

        jLId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLId.setText("Id: ");

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Titulo:");

        jLAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLAutor.setText("Autor:");

        jLGenero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLGenero.setText("Género: ");

        jTId.setEnabled(false);

        jTTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTituloActionPerformed(evt);
            }
        });

        jBtnAgregar.setBackground(new java.awt.Color(155, 135, 255));
        jBtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAgregar.setText("Agregar");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaIngresoLayout = new javax.swing.GroupLayout(vistaIngreso);
        vistaIngreso.setLayout(vistaIngresoLayout);
        vistaIngresoLayout.setHorizontalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 67, Short.MAX_VALUE))
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnAgregar)
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTitulo)
                            .addComponent(jLId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTId, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jTTitulo))
                        .addGap(31, 31, 31)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLGenero)
                            .addComponent(jLAutor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jTGenero))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        vistaIngresoLayout.setVerticalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(titulo)
                .addGap(30, 30, 30)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLId)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAutor)
                    .addComponent(jTAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitulo)
                    .addComponent(jTTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLGenero)
                    .addComponent(jTGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnAgregar)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        Contenedor.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 570, 440));

        vistaDatos.setBackground(new java.awt.Color(155, 135, 255));

        jTDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jTDatos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Datos");

        javax.swing.GroupLayout vistaDatosLayout = new javax.swing.GroupLayout(vistaDatos);
        vistaDatos.setLayout(vistaDatosLayout);
        vistaDatosLayout.setHorizontalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaDatosLayout.createSequentialGroup()
                .addGroup(vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaDatosLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1))
                    .addGroup(vistaDatosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        vistaDatosLayout.setVerticalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Contenedor.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 440));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos.Imagenes/fondo.jpg"))); // NOI18N
        Contenedor.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, 343));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTituloActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        Connection conexion = getConnection();
        PreparedStatement ps = null;
        
        String sql = "insert into libro (titulo, autor, genero) values (?,?,?);";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, jTTitulo.getText());
            ps.setString(2, jTAutor.getText());
            ps.setString(3, jTGenero.getText());
            
            ps.executeUpdate();
            conexion.close();
            
            JOptionPane.showMessageDialog(null, "Libro Guardado");
            mostrarDatos();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JLabel jLAutor;
    private javax.swing.JLabel jLGenero;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTAutor;
    private javax.swing.JTable jTDatos;
    private javax.swing.JTextField jTGenero;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
