package com.example.gestion_construction.dao;

import com.example.gestion_construction.model.Projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjetDao {

    private Connection conn;
     public ProjetDao() {
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_construction","root","");
             System.out.println("Connected to the database ");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Failed to connect to database");
         }
     }

  public void ajouterProjet(Projet projet) {
         String sql = "insert into projet(nomP, descriptionP, dateDebutP, dateFinP, budget) values(?,?,?,?,?)";
         try(PreparedStatement ps = conn.prepareStatement(sql)){

             ps.setString(1,projet.getNomP());
             ps.setString(2,projet.getDescriptionP());
             ps.setString(3,projet.getDateDebutP());
             ps.setString(4,projet.getDateFinP());
             ps.setDouble(5,projet.getBudget());
             ps.executeUpdate();

         }catch (Exception e){
             e.printStackTrace();
         }
  }

  public List<Projet> afficherProjet() {
         List<Projet> listProjets = new ArrayList<Projet>();
         String sql = "select * from projet";
         try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet result = ps.executeQuery()){
             while(result.next()){
                 Projet projet = new Projet();
                 projet.setIdP(result.getInt("idP"));
                 projet.setNomP(result.getString("nomP"));
                 projet.setDescriptionP(result.getString("descriptionP"));
                 projet.setDateDebutP(result.getString("dateDebutP"));
                 projet.setDateFinP(result.getString("dateFinP"));
                 projet.setBudget(result.getDouble("budget"));
                 listProjets.add(projet);

             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return listProjets;
  }

  public Projet getProjetById(int idP){
         Projet projet = null;
         String sql = "select * from projet where idP = ?";
         try(PreparedStatement ps = conn.prepareStatement(sql);){
             ps.setInt(1,idP);
             ResultSet result= ps.executeQuery();
             if(result.next()){
                 projet = new Projet();
                 projet.setIdP(result.getInt("idP"));
                 projet.setNomP(result.getString("nomP"));
                 projet.setDescriptionP(result.getString("descriptionP"));
                 projet.setDateDebutP(result.getString("dateDebutP"));
                 projet.setDateFinP(result.getString("dateFinP"));
                 projet.setBudget(result.getDouble("budget"));

             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return projet;
  }

  public void modifierProjet(Projet projet) {
         String sql = "UPDATE projet set nomP=?, descriptionP=?, dateDebutP=?, dateFinP=?, budget=? WHERE idP = ?";
         try(PreparedStatement ps = conn.prepareStatement(sql)){
             ps.setString(1,projet.getNomP());
             ps.setString(2,projet.getDescriptionP());
             ps.setString(3,projet.getDateDebutP());
             ps.setString(4,projet.getDateFinP());
             ps.setDouble(5,projet.getBudget());
             ps.setInt(6,projet.getIdP());
             ps.executeUpdate();

         } catch (Exception e) {
             e.printStackTrace();
         }
  }

  public void supprimerProjet(int idP) {
         String sql = "delete from projet where idP = ?";
         try(PreparedStatement ps = conn.prepareStatement(sql)){
             ps.setInt(1,idP);
             ps.executeUpdate();

         } catch (Exception e) {
             e.printStackTrace();
         }
  }

}
