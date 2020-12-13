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
import models.Categoria;
import utils.Conecta;

/**
 *
 * @author filip
 */
public class CategoriaDAO {
    private Conecta con;

    public CategoriaDAO() {
        this.con = new Conecta();
    }
    
    public String cadastrarCategoria(Categoria obj) {
        try {
            String sql = "insert into categoria "
                    + "(descricao) values"
                    + "(?)";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getDescricao());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String alteraCategoria(Categoria obj){
        try {
            String sql = "update categoria set "
                    + "descricao=? where "
                    + "id=?";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getDescricao());
            ps.setInt(2, obj.getId());
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
    
    public String excluirCategoria(Categoria obj){
        
        try {
            //1 passo  - criar o comando sql
            String sql = "delete from categoria where id = ?";

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
    
    public List<Categoria> listarCategoria() throws SQLException {
     

            //1 passo criar a lista
            List<Categoria> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from categoria";
            PreparedStatement stmt = this.con.getPS(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria obj = new Categoria();

                obj.setId(rs.getInt("id"));                
                obj.setDescricao(rs.getString("descricao"));  
                //obj.setIdcategoria(rs.getInt("idcategoria"));

                lista.add(obj);
            }

            return lista;
    }
}
