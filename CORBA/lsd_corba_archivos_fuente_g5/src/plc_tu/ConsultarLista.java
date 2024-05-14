package plc_tu;

import plc_mms.dto.DatosPlcTu_DTO;
import plc_mms.sop_rmi.GestionPlcTuInt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ConsultarLista extends JFrame {
    private JPanel jPaneConsultaLista;
    private JTable tblDispositivos;
    DefaultTableModel modelo;
    private ArrayList<DatosPlcTu_DTO> listTU;

    public ConsultarLista(GestionPlcTuInt objPLC) {
        // Configuración de la ventana
        setContentPane(jPaneConsultaLista);
        setTitle("Consulta de Dispositivos PLC/TU");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400); // Tamaño ajustado para una mejor visualización de la tabla
        setLocationRelativeTo(null);

        // Inicialización del modelo de tabla y configuración de las columnas
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID PLC/TU");
        modelo.addColumn("Propietario");
        modelo.addColumn("Dirección");

        // Asignar el modelo de tabla a la JTable
        tblDispositivos.setModel(modelo);

        try {
            // Obtener la lista de dispositivos PLC/TU
            listTU = objPLC.recuperarLista();

            // Verificar si la lista está vacía
            if (listTU.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron dispositivos PLC/TU conectados.",
                        "Error remoto", JOptionPane.ERROR_MESSAGE);
            } else {
                // Agregar filas al modelo de tabla
                for (DatosPlcTu_DTO dato : listTU) {
                    modelo.addRow(new Object[]{dato.getId_plctu(), dato.getPropietario(), dato.getDireccion()});
                }
            }
        } catch (RemoteException ex) {
            // Manejo de excepciones RemoteException
            JOptionPane.showMessageDialog(null, "Error remoto al recuperar la lista de dispositivos.",
                    "Error remoto", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            // Manejo de otras excepciones
            JOptionPane.showMessageDialog(null, "Se produjo un error al recuperar la lista de dispositivos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        // Establecer la ventana como visible
        setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        jPaneConsultaLista = new JPanel();
        jPaneConsultaLista.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Dispositivos Registrados");
        jPaneConsultaLista.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tblDispositivos = new JTable();
        jPaneConsultaLista.add(tblDispositivos, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPaneConsultaLista;
    }
}
