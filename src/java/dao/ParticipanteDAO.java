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
import models.Participante;
import utils.Conecta;

/**
 *
 * @author filip
 */
public class ParticipanteDAO {
    private Conecta con;

    public ParticipanteDAO() {
        this.con = new Conecta();
    }
    
    public String cadastrarParticipante(Participante obj) {
        try {
            String sql = "insert into participante "
                    + "(idPiloto, idCampeonato, idCategoria) values"
                    + "(?, ?, ?)";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setInt(1, obj.getIdPiloto());
            ps.setInt(2, obj.getIdCampeonato());
            ps.setInt(3, obj.getIdCategoria());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String alteraParticipante(Participante obj){
        try {
            String sql = "update participante set "
                    + "idPiloto=? idCampeonato=? idCategoria=?where "
                    + "id=?";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setInt(1, obj.getIdPiloto());
            ps.setInt(2, obj.getIdCampeonato());
            ps.setInt(3, obj.getIdCategoria());
            ps.setInt(4, obj.getId());
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
    
    public String excluirParticipante(Participante obj){
        
        try {
            //1 passo  - criar o comando sql
            String sql = "delete from participante where id = ?";

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
    
    public List<Participante> listarParticipante() throws SQLException {
     

            //1 passo criar a lista
            List<Participante> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from participante";
            PreparedStatement stmt = this.con.getPS(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Participante obj = new Participante();

                obj.setId(rs.getInt("id"));
                obj.setId(rs.getInt("idPiloto"));
                obj.setId(rs.getInt("idCampeonato"));
                obj.setId(rs.getInt("idCategoria"));
                //obj.setIdcategoria(rs.getInt("idcategoria"));

                lista.add(obj);
            }

            return lista;
    }
    
}
