package com.colegio;

import com.colegio.modelo.Colegio;
import com.colegio.vista.VentanaPrincipal;

/**
 * Clase principal: crea el Colegio (almacén de datos) y abre la ventana
 * principal de la aplicación.
 */
public class Main {

    public static void main(String[] args) {
        // Look and feel Nimbus (el mismo que propone NetBeans en sus JFrame)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Colegio colegio = new Colegio();
        colegio.setNombre("Colegio San José");

        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal(colegio).setVisible(true));
    }
}
