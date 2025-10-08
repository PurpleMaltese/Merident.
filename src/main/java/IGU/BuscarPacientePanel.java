package IGU;

import CONTROLADOR.PacienteControlador;
import DAO.PacienteDAO;
import MODEL.PacienteModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class BuscarPacientePanel extends javax.swing.JPanel {


    public BuscarPacientePanel() {
        initComponents();
    }
    
    PacienteDAO pacienteDAO = new PacienteDAO();
    
    PacienteControlador pacienteControlador = new PacienteControlador(pacienteDAO, this);
    
    //MUESTRA LA INFO DE LOS PACIENTES EN LA TABLA
     public void actualizarTablaPacientes(List<PacienteModel> pacientes) {
        // Definir las columnas de la tabla
        String[] columnNames = {"ID","DNI", "Nombre", "Apellido", "Edad"};

        // Crear un modelo de tabla
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);  // 0 es para no incluir filas al inicio

        // Llenar el modelo con los datos de los pacientes
        for (PacienteModel paciente : pacientes) {
            Object[] row = new Object[5];  // 10 columnas para los datos de cada paciente
            row[0] = paciente.getId();
            row[1] = paciente.getDni();
            row[2] = paciente.getNombre();
            row[3] = paciente.getApellido();
            row[4] = paciente.getEdad();

            // Añadir la fila al modelo de la tabla
            tableModel.addRow(row);
        }

        // Asignar el modelo de tabla al JTable
        tblPaciente.setModel(tableModel);  // Asumiendo que jTable es el nombre del componente JTable en tu vista
     }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        btnListarTodo = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPaciente);

        btnListarTodo.setText("Listar todo");
        btnListarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListarTodo)
                                .addGap(82, 82, 82)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jButton3)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarTodo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton3)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodoActionPerformed
        pacienteControlador.listarPacientes();
    }//GEN-LAST:event_btnListarTodoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int codigo=Integer.parseInt(txtCodigo.getText());

        //hacer mas validaciones
        if(codigo>0){
            pacienteControlador.buscarPaciente(codigo);
        }else{

        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnListarTodo;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
