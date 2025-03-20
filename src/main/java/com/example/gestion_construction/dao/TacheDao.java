package com.example.gestion_construction.dao;

import com.example.gestion_construction.model.Tache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TacheDao {
    private Connection conn;
    public TacheDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_construction","root","");
            System.out.println("Connected to the database ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }

    public void ajouterTache(Tache tache) {
        String sql ="insert into tache (nomT, descriptionT, dateDebutT, dateFinT) values (?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,tache.getNomT());
            ps.setString(2,tache.getDescriptionT());
            ps.setString(3,tache.getDateDebutT());
            ps.setString(4,tache.getDateFinT());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tache> afficherTaches() {
        List<Tache> listTaches = new ArrayList<Tache>();
        String sql = "select * from tache";
        try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet result = ps.executeQuery()){
            while(result.next()){
                Tache tache = new Tache();
                tache.setNomT(result.getString("nomT"));
                tache.setDescriptionT(result.getString("descriptionT"));
                tache.setDateDebutT(result.getString("dateDebutT"));
                tache.setDateFinT(result.getString("dateFinT"));
                listTaches.add(tache);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaches;
    }

    public Tache getTacheById(int idT){
        Tache tache = null;
        String sql = "select * from projet where idT = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet result= ps.executeQuery()){
            ps.setInt(1,idT);
            while(result.next()){
                tache = new Tache();
                tache.setNomT(result.getString("nomT"));
                tache.setDescriptionT(result.getString("descriptionT"));
                tache.setDateDebutT(result.getString("dateDebutT"));
                tache.setDateFinT(result.getString("dateFinT"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tache;
    }

    public void modifierTache(Tache tache) {
        String sql = "UPDATE tache set nomT=?, descriptionT=?, dateDebutT=?, dateFinT=? WHERE idT = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,tache.getNomT());
            ps.setString(2,tache.getDescriptionT());
            ps.setString(3,tache.getDateDebutT());
            ps.setString(4,tache.getDateFinT());
            ps.setInt(6,tache.getIdT());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supprimerTache(int idT) {
        String sql = "delete from tache where idT = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,idT);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
