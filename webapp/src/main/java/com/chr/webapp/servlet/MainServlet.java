package com.chr.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class MainServlet extends HttpServlet {
    private String atributoCompartido = "sin modificar";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        if(req.getParameter("var") != null){
            //Si el atributo es modifica por un usuario por medio de la url
            //sera modificado para todos los usuarios
            atributoCompartido = req.getParameter("var");
        }
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset=\"UTF8\">");
        out.print("<title>Home</title>");

        out.print("<body>");
        out.print("<h1>");
        out.print(atributoCompartido);
        out.print("</h1>");

        out.print("</head>");
    }
}
