/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Piloto;
import utils.Conecta;

/**
 *
 * @author filip
 */
public class PilotoDAO {
    private Conecta con;

    public PilotoDAO() {
        this.con = new Conecta();
    }
    
    public String cadastrarPiloto(Piloto obj) {
        try {
            String sql = "insert into piloto "
                    + "(nome, email, cpf, dataNascimento, cidade, uf, modelo_moto, cilindrada, marca) values"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getCpf());
            ps.setDate(4, obj.getDataNascimento());
            ps.setString(5, obj.getCidade());
            ps.setString(6, obj.getUf());
            ps.setString(7, obj.getModelo_moto());
            ps.setString(8, obj.getCilindrada());
            ps.setString(9, obj.getMarca());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String alteraPiloto(Piloto obj){
        try {
            String sql = "update piloto set "
                    + "nome=? email=? cpf=? datanascimento=? cidade=? uf=? modelo_moto=? cilindrada=? marca=? where "
                    + "id=?";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getCpf());
            ps.setDate(4, obj.getDataNascimento());
            ps.setString(5, obj.getCidade());
            ps.setString(6, obj.getUf());
            ps.setString(7, obj.getModelo_moto());
            ps.setString(8, obj.getCilindrada());
            ps.setString(9, obj.getMarca());
            ps.setInt(10, obj.getId());
            //ps.setInt(2, obj.getIdcategoria());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String excluirPiloto(Piloto obj){
        
        try {
            //1 passo  - criar o comando sql
            String sql = "delete from piloto where id = ?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = this.con.getPS(sql);
            //stmt.setInt(1, obj.getIdcategoria());
            stmt.setInt(1, obj.getId());
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            return "Excluido com Sucesso!";

        } catch (SQLException erro) {
            return "Erro: " + erro;

        }
    }
    
    public List<Piloto> listarPiloto() throws SQLException {
     

            //1 passo criar a lista
            List<Piloto> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from piloto";
            PreparedStatement stmt = this.con.getPS(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Piloto obj = new Piloto();

                obj.setId(rs.getInt("id"));                
                obj.setNome(rs.getString("nome"));       
                obj.setNome(rs.getString("email"));  
                obj.setCpf(rs.getString("cpf"));
                obj.setDataNascimento(rs.getDate("dataNascimento"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));
                obj.setModelo_moto(rs.getString("modelo_moto"));
                obj.setCilindrada(rs.getString("cilindrada"));
                obj.setMarca(rs.getString("marca"));
                //obj.setIdcategoria(rs.getInt("idcategoria"));

                lista.add(obj);
            }

            return lista;
    }
    
}
