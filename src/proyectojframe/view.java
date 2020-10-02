/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojframe;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alex
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    public view() {
        initComponents();
        this.getContentPane().setBackground(new Color(0,103,158));
        jPanel1.setBackground(new Color(0,103,158));
        jPanel2.setBackground(new Color(0,103,158));
        
        jPanel1.setForeground(Color.white);
        jPanel2.setForeground(Color.WHITE);
        jLabelTitulo.setForeground(Color.white);
    }
    
    public void eliminar(){
        // Se obtiene el modelo de la tabla jTable
        DefaultTableModel tb = (DefaultTableModel) jTable.getModel();
        
        // Se obtiene el numero de filas de la tabla
        int a = jTable.getRowCount()-1;
        
        // Se eliminan cada una de las filas
        for (int i = a; i >= 0; i--) {          
            tb.removeRow(tb.getRowCount()-1);
        }
        
        // Se agrega el modelo sin filas
        jTable.setModel(tb);
    }
    
    public void listar(String texto) {
        // Esta variable sirve para identificar la linea donde se encuentran los tokens
        int i = 1;
        
        // Obtiene el texto del TextArea
        String[] lineas = texto.split("\n");
        
        // Crea la variable clas para usa los metodos de clasificar
        Clasificar clas = new Clasificar();
        
        // Se crea una variable para la clase palabra
        Palabra pa;
        
        // Se crea la tabla que mostrara los datos
        DefaultTableModel model = new DefaultTableModel();
        
        // Crea la columna Token de la tabla, mostrara la palabra, signo o digito analizado
        model.addColumn("Token");
        
        /* Crea la columna Palabra Reservada de la tabla, 
        mostrara un si el token es una palabra reservada que se encuentra en palabras.txt
        lo hara con un true o false  */
        model.addColumn("Palabra Reservada");
        
        /* Crea la columna ID  de la tabla, esta mostrara si el token es una 
        variable */
        model.addColumn("ID");
        
        /* Crea la columna Operador Racional de la tabla, esta mostrara
         si el token es un operador racional que se encuentra en operadoresRacionales.txt
        lo hara con un true o false */
        model.addColumn("Operador Racional");
        
        /* Crea la columna Digito de la tabla, esta mostrara si el token es digito o no con un true o false */
        model.addColumn("Digito");
        
        /* Crea la columna Operador de la tabla, esta mostrara si el token 
        es un operador que se encuentra en operadores.txt */
        model.addColumn("Operador");
        
        /* Crea la columna No Reconocido de la tabla, mostrara si el token
        no se clasifica como palabra reservada, id, operador racional, digito o operador
        se le asignara como no reconocido*/
        model.addColumn("No Reconocido");
        
        // Crea la columna Linea de la tabla, esta mostrara en que linea se encuentra el token
        model.addColumn("Linea");
        
        // Este for separara el texto ingresado en lineas para analizarlo
        for(String t1 : lineas) {
            
            //El array analizar con tiene cada una de las pabras y digitos
            String[] analizar = clas.Separar(t1);
            
            // El array simbolos con tiene solo los simbolos que se encuentren en la linea
            String[] simbolos = clas.SepararSimbolos(t1);
            
            //Este for recore el array de analizar para poder clasificarlos
            for(String t2 : analizar) {
                
                //Este if verifica que no se clasifiquen los espacion en blanco
                if(t2.matches("[^\\\"]+")) {
                    
                    // Se crea clase palabra
                    pa = new Palabra();
                    
                    // Se le asigna un token a palabra
                    pa.setToken(t2);
                    
                    // Se analiza para indentificar si es un operador
                    pa.operador();
                    
                    // Se analiza para identificar si en un operador racional
                    pa.operadorRelacional();
                    
                    // Se analiza para identificar si es una palabra reservada
                    pa.reservada();
                    
                    // Se analiza para identificar si es un digito
                    pa.digito();
                    
                    // Se analiza para identificar si es un ID
                    pa.variable(t1);
                    
                    // Se analiza para identificar si es desconocido
                    pa.desconocido();
                    
                    // Define en que linea se encuentra el token
                    pa.setLinea(i);
                    
                    // Se agrega una fila con toda la informacion que se encuentra en la variable pa de la clase palabra
                    model.addRow(new Object[]{pa.getToken(), pa.isReservada(), pa.isId(), 
                        pa.isOperadorRacional(), pa.isDigito(), pa.isOperador(), pa.isUnknow(), pa.getLinea()});
                }
            }
            
            // Este for recorre el array simbolos para analizar los simbolos que se encuentren en la variable t1
            for(String t3 : simbolos) {
                
                // Este if evita que se analizen espacios vacios
                if(!t3.isEmpty()) {
                    
                    // Se crea la clase palabra
                    pa = new Palabra();
                    
                    // Se le asigna un token a palabra
                    pa.setToken(t3);
                    
                    // Se analiza para identificar si es una palabra reservada
                    pa.reservada();
                    
                    // Se analiza para indentificar si es un operador
                    pa.operador();
                    
                    // Se analiza para identificar si en un operador racional
                    pa.operadorRelacional();
                    
                    // Se analiza para identificar si es desconocido
                    pa.desconocido();
                    
                    // Define en que linea se encuentra el token
                    pa.setLinea(i);
                    
                    // Se agrega una fila con toda la informacion que se encuentra en la variable pa de la clase palabra
                    model.addRow(new Object[]{pa.getToken(), pa.isReservada(), pa.isId(), 
                        pa.isOperadorRacional(), pa.isDigito(), pa.isOperador(), pa.isUnknow(), pa.getLinea()});
                }
            }
            
            // Se incrementa la linea para saber que hemos cambiado a otra
            i++;
        }
        
        // Se ingresa la tabla creada al objeto tabla creado en el jFrame
        jTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaArchivo = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Sintactico");
        setBackground(new java.awt.Color(235, 182, 107));

        jTable.setFont(new java.awt.Font("PT Sans", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "P. Reservada", "ID", "Operador Racional", "Dígito", "Operador", "No reconocido", "Linea"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(51, 51, 51));
        jTable.setRowHeight(20);
        jTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable.setShowGrid(true);
        jTable.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTable);

        jLabelTitulo.setFont(new java.awt.Font("PT Sans", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Analizador Sintactico");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Ingresar texto a analizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("PT Sans", 0, 14)); // NOI18N
        txtArea.setForeground(new java.awt.Color(51, 51, 51));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnEnviar.setBackground(new java.awt.Color(255, 255, 255));
        btnEnviar.setFont(new java.awt.Font("PT Sans", 1, 16)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(51, 51, 51));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Ingresar archivo a analizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PT Sans", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txtAreaArchivo.setEditable(false);
        txtAreaArchivo.setColumns(20);
        txtAreaArchivo.setFont(new java.awt.Font("PT Sans", 0, 14)); // NOI18N
        txtAreaArchivo.setForeground(new java.awt.Color(51, 51, 51));
        txtAreaArchivo.setRows(5);
        jScrollPane3.setViewportView(txtAreaArchivo);

        btnArchivo.setBackground(new java.awt.Color(255, 255, 255));
        btnArchivo.setFont(new java.awt.Font("PT Sans", 1, 16)); // NOI18N
        btnArchivo.setForeground(new java.awt.Color(51, 51, 51));
        btnArchivo.setText("Abrir Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // Se vacia el text area
        txtAreaArchivo.setText("");
        
        // Se elimina los datos de la tabla
        eliminar();
        
        // Se ingresan los nuevos datos para rellenar la tabla nuevamente
        listar((txtArea.getText()));
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // Se vacia el text area
        txtArea.setText("");
        
        // Se elimina los datos de la tabla
        eliminar();
        
        // Se crear la variable chooser para guardar el archivo que se ingrese
        JFileChooser chooser = new JFileChooser();
        
        // Se abre una ventana para escoger el archivo
        chooser.showOpenDialog(null);
        
        // Se guarda el archivo en la varible file
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            // Lee el contenido del archivo
            String Extraer = new String(Files.readAllBytes(archivo.toPath()));
            
            // Se ingresa el contenido del archivo a un text area;
            txtAreaArchivo.setText(Extraer);
            
        } catch (IOException e2) {
            // Se captura el error si llega a surgir alguno no rompa el programa
        }
        
        // El texto que se mando al text area se lee y se ingresan los datos a la tabla
        listar(txtAreaArchivo.getText());
        
    }//GEN-LAST:event_btnArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextArea txtAreaArchivo;
    // End of variables declaration//GEN-END:variables
}
