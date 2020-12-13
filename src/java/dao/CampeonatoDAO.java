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
import models.Campeonato;
import utils.Conecta;

/**
 *
 * @author filip
 */
public class CampeonatoDAO {
    private Conecta con;

    public CampeonatoDAO() {
        this.con = new Conecta();
    }
    
    public String cadastrarCampeonato(Campeonato obj) {
        try {
            String sql = "insert into campeonato "
                    + "(nome, datainicio, datafim, regulamento) values"
                    + "(?, ?, ?, ?)";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getNome());
            ps.setDate(2, obj.getDatainicio());
            ps.setDate(3, obj.getDatafim());
            ps.setBlob(4, obj.getRegulamento());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String alteraCampeonato(Campeonato obj){
        try {
            String sql = "update campeonato set "
                    + "nome=? datainicio=? datafim=? regulamento=? where "
                    + "id=?";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getNome());
            ps.setDate(2, obj.getDatainicio());
            ps.setDate(3, obj.getDatafim());
            ps.setBlob(4, obj.getRegulamento());
            ps.setInt(5, obj.getId());
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
    
    public String excluirCampeonato(Campeonato obj){
        
        try {
            //1 passo  - criar o comando sql
            String sql = "delete from campeonato where id = ?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = this.con.getPS(sql);
            stmt.setInt(1, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            return "Excluido com Sucesso!";

        } catch (SQLException erro) {
            return "Erro: " + erro;

        }
    }
    
    public List<Campeonato> listarCampeonato() throws SQLException {
     

            //1 passo criar a lista
            List<Campeonato> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from campeonato";
            PreparedStatement stmt = this.con.getPS(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Campeonato obj = new Campeonato();

                obj.setId(rs.getInt("id"));                
                obj.setNome(rs.getString("nome"));  
                obj.setDatainicio(rs.getDate("datainicio"));
                obj.setDatafim(rs.getDate("datafim"));
                obj.setRegulamento(rs.getBlob("regulamento"));
                //obj.setIdcategoria(rs.getInt("idcategoria"));

                lista.add(obj);
            }

            return lista;
    }
}
