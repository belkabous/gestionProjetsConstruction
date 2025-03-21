package com.example.gestion_construction.controller;

import com.example.gestion_construction.dao.TacheDao;
import com.example.gestion_construction.model.Tache;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tache-servlet")
public class TacheServlet extends HttpServlet {
        private TacheDao tacheDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        tacheDao = new TacheDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("insert-tache")){
            ajouterTache(req,resp);
        } else if (action.equals("update-tache")) {
            editTache(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("all-taches")){
            getTaches(req,resp);
        } else if (action.equals("delete-tache")){
            deleteTache(req,resp);
        } else if (action.equals("ajouter-tache")) {
            req.getRequestDispatcher("tacheForm.jsp").forward(req, resp);
        } else if (action.equals("edit-tache")) {
            int idT = Integer.parseInt(req.getParameter("idT"));
            Tache tache = tacheDao.getTacheById(idT);
            req.setAttribute("tache", tache);
            req.getRequestDispatcher("tacheUpdate.jsp").forward(req, resp);
        }
    }

    private void editTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idT = Integer.parseInt(req.getParameter("idT"));
        String nomT = req.getParameter("nomT");
        String descriptionT = req.getParameter("descriptionT");
        String dateDebutT = req.getParameter("dateDebutT");
        String dateFinT = req.getParameter("dateFinT");
            Tache tache = new Tache(nomT, descriptionT, dateDebutT, dateFinT);
            tache.setIdT(idT);
            tacheDao.modifierTache(tache);
            resp.sendRedirect("tache-servlet?action=all-taches");
    }

    private void ajouterTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomT = req.getParameter("nomT");
        String descriptionT = req.getParameter("descriptionT");
        String dateDebutT = req.getParameter("dateDebutT");
        String dateFinT = req.getParameter("dateFinT");
        Tache tache = new Tache(nomT, descriptionT, dateDebutT, dateFinT);
        tacheDao.ajouterTache(tache);
        resp.sendRedirect("tache-servlet?action=all-taches");
    }

    private void deleteTache(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idT = Integer.parseInt(req.getParameter("idT"));
        tacheDao.supprimerTache(idT);
        resp.sendRedirect("tache-servlet?action=all-taches");
    }

    private void getTaches(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Tache> taches = tacheDao.afficherTaches();
    req.setAttribute("listTaches", taches);
    req.getRequestDispatcher("tacheList.jsp").forward(req,resp);
    }
}
