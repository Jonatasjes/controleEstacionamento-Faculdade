/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author jesja
 */
public class CarroTableModel extends AbstractTableModel {
    
    private List<Carro> dados = new ArrayList<>();
    private String[] colunas = {"Marca","Placa","Cor","Hora de Entrada","Hora de Saída"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex) {
            case 0:
                return dados.get(rowIndex).getMarca();
            case 1:
                return dados.get(rowIndex).getPlaca();
            case 2:
                return dados.get(rowIndex).getCor();
            case 3:
                return dados.get(rowIndex).getHoraEntrada();
            case 4:
                return dados.get(rowIndex).getHoraSaida();
        }
        
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    
        switch(columnIndex) {
            case 0:
                dados.get(rowIndex).setMarca( (String) aValue );
                break;
            case 1:
                dados.get(rowIndex).setPlaca( (String) aValue );
                break;
            case 2:
                dados.get(rowIndex).setCor( (String) aValue );
                break;
            case 3:
                dados.get(rowIndex).setHoraEntrada( Integer.parseInt( (String) aValue ));
                break;
            case 4:
                dados.get(rowIndex).setHoraSaida( Integer.parseInt( (String) aValue ) );
                break;
        }
        
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    
    }
    
    public void addRow(Carro c) {
        this.dados.add(c);
        this.fireTableDataChanged();
    
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
