package com.example.gestion_construction.controller;

import com.example.gestion_construction.dao.ProjetDao;
import com.example.gestion_construction.model.Projet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/ProjetServlet")
public class ProjetServlet extends HttpServlet {

    private ProjetDao projectDao;

    @Override
    public void init() throws ServletException {
         projectDao = new ProjetDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("insert")){
            ajouterProjet(req, resp);
        }else if (action.equals("update")){
            editProjet(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action.equals("all-projects")){
            getProjects(req,resp);
        } else if (action.equals("delete-projet")){
            deleteProjet(req,resp);
        } else if (action.equals("ajouter-projet")) {
            req.getRequestDispatcher("projetForm.jsp").forward(req, resp);
        } else if (action.equals("edit-projet")){
            int idP = Integer.parseInt(req.getParameter("idP"));
            Projet projet = projectDao.getProjetById(idP);
            req.setAttribute("projet", projet);
            req.getRequestDispatcher("editProjet.jsp").forward(req, resp);
        }


    }

    private void editProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idP=Integer.parseInt(req.getParameter("idP"));
       String nomP = req.getParameter("nomP");
       String descriptionP = req.getParameter("descriptionP");
       String dateDebutP = req.getParameter("dateDebutP");
       String dateFinP = req.getParameter("dateFinP");
       Float budget = Float.parseFloat(req.getParameter("budget"));
        Projet projet = new Projet(nomP,descriptionP,dateDebutP,dateFinP,budget);
        projet.setIdP(idP);
        projectDao.modifierProjet(projet);
        resp.sendRedirect("ProjetServlet?action=all-projects");

    }

    private void ajouterProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomP = req.getParameter("nomP");
        String descriptionP = req.getParameter("descriptionP");
        String dateDebutP = req.getParameter("dateDebutP");
        String dateFinP = req.getParameter("dateFinP");
        Float budget = Float.parseFloat(req.getParameter("budget"));
        Projet projet = new Projet(nomP,descriptionP,dateDebutP,dateFinP,budget);
        projectDao.ajouterProjet(projet);
        resp.sendRedirect("ProjetServlet?action=all-projects");
    }

    private void deleteProjet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idP = Integer.parseInt(req.getParameter("idP"));
        projectDao.supprimerProjet(idP);
        resp.sendRedirect("ProjetServlet?action=all-projects");
    }

    private void getProjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Projet> projets = projectDao.afficherProjet();
        req.setAttribute("listProjets", projets);
        req.getRequestDispatcher("projetList.jsp").forward(req, resp);
    }


}
