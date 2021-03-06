/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgserver;

import FGrammar.ErrorC;
import FGrammar.Lexico;
import FGrammar.Sintactico;
import Servidor.ServidorN;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Javier A. Cabrera
 */
public class GUI extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    @Override
    public void run() {
        ServidorN servidor = new ServidorN();
        try {
            servidor.iniciarServidor();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelEditor = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandLine = new javax.swing.JTextArea();
        panelConsola = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputLine = new javax.swing.JTextArea();
        botonLimpiar = new javax.swing.JButton();
        botonCargar = new javax.swing.JButton();
        botonAnalizar = new javax.swing.JButton();
        botonErrores = new javax.swing.JButton();
        terminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GUI Servidor");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(18, 47, 61));

        panelEditor.setBackground(new java.awt.Color(246, 222, 108));

        commandLine.setBackground(new java.awt.Color(18, 47, 61));
        commandLine.setColumns(20);
        commandLine.setForeground(new java.awt.Color(255, 255, 255));
        commandLine.setRows(5);
        commandLine.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(commandLine);

        jTabbedPane1.addTab("Linea de Comandos", jScrollPane1);

        javax.swing.GroupLayout panelEditorLayout = new javax.swing.GroupLayout(panelEditor);
        panelEditor.setLayout(panelEditorLayout);
        panelEditorLayout.setHorizontalGroup(
            panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEditorLayout.setVerticalGroup(
            panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelConsola.setBackground(new java.awt.Color(246, 222, 108));

        outputLine.setBackground(new java.awt.Color(52, 115, 143));
        outputLine.setColumns(20);
        outputLine.setForeground(new java.awt.Color(255, 255, 255));
        outputLine.setRows(5);
        outputLine.setCaretColor(new java.awt.Color(255, 255, 255));
        outputLine.setEnabled(false);
        jScrollPane2.setViewportView(outputLine);

        jTabbedPane2.addTab("Consola de Salida", jScrollPane2);

        javax.swing.GroupLayout panelConsolaLayout = new javax.swing.GroupLayout(panelConsola);
        panelConsola.setLayout(panelConsolaLayout);
        panelConsolaLayout.setHorizontalGroup(
            panelConsolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelConsolaLayout.setVerticalGroup(
            panelConsolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document-empty-icon.png"))); // NOI18N
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Files-Upload-File-icon.png"))); // NOI18N
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        botonAnalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mimetype-make-icon.png"))); // NOI18N
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        botonErrores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Delete-icon.png"))); // NOI18N
        botonErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonErroresActionPerformed(evt);
            }
        });

        terminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Misc-Download-Database-icon.png"))); // NOI18N
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelConsola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonLimpiar)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonCargar)
                                    .addComponent(terminar))
                                .addGap(18, 18, 18)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAnalizar)
                                    .addComponent(botonErrores))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(panelConsola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        this.commandLine.setText("");
        this.outputLine.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //System.out.println("Ya me cerre");
    }//GEN-LAST:event_formWindowClosed

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
        // TODO add your handling code here:
        try {
            DatosPersistentes.productos.escribirArchivo();
            DatosPersistentes.usuarios.escribirArchivo();
            DatosPersistentes.tiendas.escribirArchivo();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        exit(0);
    }//GEN-LAST:event_terminarActionPerformed

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        // TODO add your handling code here:
        JFileChooser buscador = new JFileChooser();
        buscador.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos SL (*.sl)", "sl");
        buscador.setFileFilter(filtro);
        int seleccion = buscador.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION )
        {       
            try 
            {
                BufferedReader lectorBuffer;
                File archivo = buscador.getSelectedFile();
                String nombre = archivo.getName();
                lectorBuffer = new BufferedReader(new FileReader(archivo.getAbsolutePath()));  
                
                String parcial, completo= "";
                parcial = lectorBuffer.readLine();
                while (parcial != null) 
                {
                    completo += parcial +"\n";
                    parcial = lectorBuffer.readLine();
                }
                this.commandLine.setText(completo);
                lectorBuffer.close();   
            } 
            catch (IOException ex) 
            {Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
        // TODO add your handling code here:
        String cadena = this.commandLine.getText();
        Reader lector = new StringReader(cadena);
        Lexico scanner = new Lexico(lector);
        Sintactico parser = new Sintactico(scanner);
        try 
        {
            parser.parse();
        }
        catch(Exception e) 
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_botonAnalizarActionPerformed

    private void botonErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonErroresActionPerformed
        // TODO add your handling code here:
        //generar pdf con errores desde aqui
        for (ErrorC er : DatosPersistentes.lexicos) 
            System.out.println("tipo: " + er.tipo + " - lexema: " + er.lexema + " - fila: " + er.fila
                    + " - columna: " + er.columna + " - descripcion: " + er.descripcion);
        for (ErrorC er: DatosPersistentes.sintacticos)
            System.out.println("tipo: " + er.tipo + " - lexema: " + er.lexema + " - fila: " + er.fila
                    + " - columna: " + er.columna + " - descripcion: " + er.descripcion);
        for (ErrorC er: DatosPersistentes.semanticos)
            System.out.println("tipo: " + String.valueOf(er.tipo) + " - lexema: " + String.valueOf(er.lexema) + " - fila: "
                    + String.valueOf(er.fila)
                    + " - columna: " + String.valueOf(er.columna) + " - descripcion: " + String.valueOf(er.descripcion));
    }//GEN-LAST:event_botonErroresActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonErrores;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JTextArea commandLine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTextArea outputLine;
    private javax.swing.JPanel panelConsola;
    private javax.swing.JPanel panelEditor;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton terminar;
    // End of variables declaration//GEN-END:variables
}
