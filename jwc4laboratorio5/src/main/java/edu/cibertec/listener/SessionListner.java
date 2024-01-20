/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package edu.cibertec.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author jpere
 */
public class SessionListner implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SE CREO LA SESION: " +se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SE DESTRUYO LA SESION: " +se.getSession().getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
       System.out.println("SE AGREGO UN ATRIBUO A LA SESION: " +event.getName());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("SE REMOVIO UN ATRIBUO A LA SESION: " +event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("SE REMPLAZO UN ATRIBUO A LA SESION: " +event.getName());
    }
}
