package com.example.gestion_construction.controller;

import com.example.gestion_construction.dao.RessourceDao;
import com.example.gestion_construction.model.Ressource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ressource-servlet")
public class RessourceServelt extends HttpServlet {

    private RessourceDao ressourceDao;

    @Override
    public void init() throws ServletException {
        ressourceDao = new RessourceDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("all-ressources")) {
            getRessource(req, resp);
        } else if (action.equals("delete-ressource")) {
            deleteRessource(req, resp);
        } else if (action.equals("ajouter-ressource")) {
            req.getRequestDispatcher("ressourceForm.jsp").forward(req, resp);
        } else if (action.equals("edit-ressource")) {
            int idR = Integer.parseInt(req.getParameter("idR"));
            Ressource ressource = ressourceDao.getRessourceById(idR);
            req.setAttribute("ressource", ressource);
            req.getRequestDispatcher("ressourceEdit.jsp").forward(req, resp);
        }

    }

    private void editRessource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idR=Integer.parseInt(req.getParameter("idR"));
        String nomR = req.getParameter("nomR");
        String type = req.getParameter("type");
        float quantite = Float.parseFloat(req.getParameter("quantite"));
        Ressource ressource = new Ressource(nomR,type,quantite);
        ressource.setIdR(idR);
        ressourceDao.modifierRessource(ressource);
        resp.sendRedirect("ressource-servlet?action=all-ressources");

    }

    private void ajouterRessource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomR = req.getParameter("nomR");
        String type = req.getParameter("type");
        float quantite = Float.parseFloat(req.getParameter("quantite"));
        Ressource ressource = new Ressource(nomR,type,quantite);
        ressourceDao.ajouterRessource(ressource);
        resp.sendRedirect("ressource-servlet?action=all-ressources");
    }

    private void deleteRessource(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idR = Integer.parseInt(req.getParameter("idR"));
        ressourceDao.supprimerRessource(idR);
        resp.sendRedirect("ressource-servlet?action=all-ressources");
    }

    private void getRessource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ressource> ressources = ressourceDao.afficherRessource();
        req.setAttribute("listRessources", ressources);
        req.getRequestDispatcher("ressourceList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("insert-ressource")) {
            ajouterRessource(req, resp);
        }else if (action.equals("update-ressource")){
            editRessource(req,resp);
        }
    }
}

