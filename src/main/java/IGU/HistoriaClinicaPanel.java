package IGU;

import CONTROLADOR.CasoControlador;
import DAO.CasoDAO;
import MODEL.CasoModel;
import UTIL.StaticVariables;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HistoriaClinicaPanel extends javax.swing.JPanel {

    private final PaginaPrincipal paginaPrincipal;

    public HistoriaClinicaPanel(PaginaPrincipal paginaPrincipal) { //constructor que se encarga de inicializar el objeto de la pagina principal
        this.paginaPrincipal = paginaPrincipal;
        
        initComponents();
        actualizarDatos();
    }

    
    CasoDAO casoDAO = new CasoDAO();
    
    CasoControlador casoControlador = new CasoControlador(casoDAO, this);
    
    
    private void actualizarDatos(){
        lblNombre.setText(StaticVariables.Paciente);
    }

    //TABLA
    public void actualizarTablaCasos(List<CasoModel> casos){
        
        String[] columnas = {"ID","Diagnostico","Plan tratamiento","examen auxiliar","Proforma","Doctor", "Odontograma","Total tratamiento" ,"Fecha inicio", "Fecha fin"};
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        
        for(CasoModel caso : casos ){
            Object row[] = new Object[10];
            row[0] = caso.getId();
            row[1] = caso.getDiagnostico();
            row[2] = caso.getPlan_trat();
            row[3] = caso.getExam_aux();
            row[4] = caso.getProforma();
            row[5] = caso.getDoctor();
            row[6] = caso.getOdontograma();
            row[7] = caso.getTotal();
            row[8] = caso.getFecha_inicio();
            row[9] = caso.getFecha_fin();
            
            tableModel.addRow(row);
        }
        tblCasos.setModel(tableModel);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCasos = new javax.swing.JTable();
        btnCrearCaso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();

        tblCasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Diagnostico", "Plan tratamiento", "Examen auxiliar", "Proforma", "Doctor", "Odontograma", "Total tratamiento", "Fecha inicio", "Fecha fin"
            }
        ));
        jScrollPane1.setViewportView(tblCasos);

        btnCrearCaso.setText("Nuevo Caso");
        btnCrearCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCasoActionPerformed(evt);
            }
        });

        jLabel1.setText("NOMBRE");

        jButton2.setText("Borrar Caso");

        lblNombre.setText("jLabel2");

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jButton2)
                        .addGap(115, 115, 115)
                        .addComponent(btnCrearCaso)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnListar)
                .addGap(167, 167, 167))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombre)
                    .addComponent(btnListar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnCrearCaso))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCasoActionPerformed
        // TODO add your handling code here:
        CrearCasoPanel newframe = new CrearCasoPanel(paginaPrincipal);
        paginaPrincipal.mostrarPanel(newframe);
    }//GEN-LAST:event_btnCrearCasoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        casoControlador.ListarCasos();
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCaso;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblCasos;
    // End of variables declaration//GEN-END:variables
}
