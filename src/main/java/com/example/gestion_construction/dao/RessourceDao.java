package com.example.gestion_construction.dao;

import com.example.gestion_construction.model.Ressource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RessourceDao {
    private Connection conn;
    public RessourceDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_construction","root","");
            System.out.println("Connected to the database ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }

    public void ajouterRessource(Ressource ressource){
        String sql = "insert into ressource(nomR, type, quantite) values(?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, ressource.getNomR());
            ps.setString(2, ressource.getType());
            ps.setFloat(3, ressource.getQuantite());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ressource> afficherRessource(){
        List<Ressource> listressources = new ArrayList<Ressource>();
        String sql = "select * from ressource";
        try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet result = ps.executeQuery()){
            while(result.next()){
                Ressource ressource = new Ressource();
                ressource.setIdR(result.getInt("idR"));
                ressource.setNomR(result.getString("nomR"));
                ressource.setType(result.getString("type"));
                ressource.setQuantite(result.getFloat("quantite"));
                listressources.add(ressource);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listressources;
    }

    public Ressource getRessourceById(int idR){
        Ressource ressource = null;
        String sql = "select * from ressource where idR = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idR);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                ressource = new Ressource();
                ressource.setIdR(result.getInt("idR"));
                ressource.setNomR(result.getString("nomR"));
                ressource.setType(result.getString("type"));
                ressource.setQuantite(result.getFloat("quantite"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ressource;
    }

    public void modifierRessource(Ressource ressource){
        String sql = "UPDATE ressource SET nomR = ?, type = ?, quantite = ? WHERE idR = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, ressource.getNomR());
            ps.setString(2, ressource.getType());
            ps.setFloat(3, ressource.getQuantite());
            ps.setInt(4,ressource.getIdR());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void supprimerRessource(int idR){
        String sql = "DELETE FROM ressource WHERE idR = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,idR);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
