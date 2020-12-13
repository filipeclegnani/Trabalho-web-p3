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
import models.Volta;
import utils.Conecta;

/**
 *
 * @author filip
 */
public class VoltaDAO {
    private Conecta con;

    public VoltaDAO() {
        this.con = new Conecta();
    }
    
    public String cadastrarVolta(Volta obj) {
        try {
            String sql = "insert into volta "
                    + "(tipo, tempo, horaChegada, horaSaida, idParticipante, idEtapa) values"
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getTipo());
            ps.setFloat(2, obj.getTempo());
            ps.setString(3, obj.getHorachegada());
            ps.setString(4, obj.getHoraSaida());
            ps.setInt(5, obj.getIdParticipante());
            ps.setInt(6, obj.getIdEtapa());
            ps.execute();
            ps.close();
            return "Sucesso";
        } catch (SQLException e) {
            return "Erro: " + e.getMessage();
        } catch (Exception e){
            return "Erro: " + e.getMessage();
        }
    }
    
    public String alteraVolta(Volta obj){
        try {
            String sql = "update volta set "
                    + "tipo=? tempo=? horaChegada=? horaSaida=? idParticipante=? idEtapa=? where "
                    + "id=?";
            PreparedStatement ps = this.con.getPS(sql);
            ps.setString(1, obj.getTipo());
            ps.setFloat(2, obj.getTempo());
            ps.setString(3, obj.getHorachegada());
            ps.setString(4, obj.getHoraSaida());
            ps.setInt(5, obj.getIdParticipante());
            ps.setInt(6, obj.getIdEtapa());
            ps.setInt(6, obj.getId());
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
    
    public String excluirVolta(Volta obj){
        
        try {
            //1 passo  - criar o comando sql
            String sql = "delete from volta where id = ?";

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
    
    public List<Volta> listarVolta() throws SQLException {
     

            //1 passo criar a lista
            List<Volta> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from volta";
            PreparedStatement stmt = this.con.getPS(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Volta obj = new Volta();

                obj.setId(rs.getInt("id"));
                obj.setTipo(rs.getString("tipo"));
                obj.setTempo(rs.getFloat("tempo"));
                obj.setHorachegada(rs.getString("horaChegada"));
                obj.setHoraSaida(rs.getString("horaSaida"));
                obj.setIdParticipante(rs.getInt("idParticipante"));
                obj.setIdEtapa(rs.getInt("idEtapa"));
                //obj.setIdcategoria(rs.getInt("idcategoria"));

                lista.add(obj);
            }

            return lista;
    }
    
}
