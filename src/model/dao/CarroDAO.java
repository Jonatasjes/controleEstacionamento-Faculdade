/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author jesja
 */
public class CarroDAO {
    
    public void create(Carro c) {
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            
            stmt = con.prepareStatement("INSERT INTO carros (marca,placa,cor,horaEntrada,horaSaida)VALUES(?,?,?,?,?)");
            stmt.setString(1, c.getMarca());
            stmt.setString(2, c.getPlaca());
            stmt.setString(3, c.getCor());
            stmt.setInt(4, c.getHoraEntrada());
            stmt.setInt(5, c.getHoraSaida());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        } finally {
        
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    

    public List<Carro> read() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Carro> carros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM carros");
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
            
                Carro carro = new Carro();
                
                carro.setMarca(rs.getString("marca"));
                carro.setPlaca(rs.getString("placa"));
                carro.setCor(rs.getString("cor"));
                carro.setHoraEntrada(rs.getInt("horaEntrada"));
                carro.setHoraSaida(rs.getInt("horaSaida"));
                
                carros.add(carro);
            
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return carros;
    
    }
    
    
    public void update(Carro c, String p) {
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            
            stmt = con.prepareStatement("UPDATE carros SET marca = ?,placa = ?,cor = ?,horaEntrada = ?,horaSaida = ? WHERE placa = ?");
            stmt.setString(1, c.getMarca());
            stmt.setString(2, c.getPlaca());
            stmt.setString(3, c.getCor());
            stmt.setInt(4, c.getHoraEntrada());
            stmt.setInt(5, c.getHoraSaida());
            
            stmt.setString(6, p);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ ex);
        } finally {
        
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void delete(Carro c) {
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            
            stmt = con.prepareStatement("DELETE FROM carros WHERE placa = ?");

            stmt.setString(1, c.getPlaca());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ ex);
        } finally {
        
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
}
