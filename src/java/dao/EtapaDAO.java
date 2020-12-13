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
import models.Etapa;
import utils.Conecta;

/**
 *
 * @author filip
 */
public class EtapaDAO {
    private Conecta con;

    public EtapaDAO() {
        this.con = new Conecta();
    }
    
    public String cadastrarEtapa(Etapa obj) {
        try {
            String sql = "insert into etapa "
                    + "(localizacao, cidade, uf, distancia, idCampeonato) values"
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getLocalizacao());
            ps.setString(2, obj.getCidade());
            ps.setString(3, obj.getUf());
            ps.setFloat(4, obj.getDistancia());
            ps.setInt(5, obj.getIdCampeonato());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String alteraEtapa(Etapa obj){
        try {
            String sql = "update etapa set "
                    + "localizacao=?, cidade=?, uf=?, distancia=?, idCampeonato=? where "
                    + "id=?";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getLocalizacao());
            ps.setString(2, obj.getCidade());
            ps.setString(3, obj.getUf());
            ps.setFloat(4, obj.getDistancia());
            ps.setInt(5, obj.getIdCampeonato());
            ps.setInt(6, obj.getId());
            //ps.setString(1, obj.getDescricao());
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
    
    public String excluirEtapa(Etapa obj){
        
        try {
            //1 passo  - criar o comando sql
            String sql = "delete from etapa where id = ?";

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
    
    public List<Etapa> listarEtapa() throws SQLException {
     

            //1 passo criar a lista
            List<Etapa> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from etapa";
            PreparedStatement stmt = this.con.getPS(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Etapa obj = new Etapa();

                obj.setId(rs.getInt("id"));  
                obj.setLocalizacao(rs.getString("localizacao"));    
                obj.setCidade(rs.getString("cidade"));             
                obj.setUf(rs.getString("uf"));   
                obj.setDistancia(rs.getFloat("distancia"));    
                obj.setIdCampeonato(rs.getInt("idCampeonato"));      
                //obj.setDescricao(rs.getString("descricao"));  
                //obj.setIdcategoria(rs.getInt("idcategoria"));

                lista.add(obj);
            }

            return lista;
    }
}
