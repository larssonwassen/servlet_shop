/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author xclose
 */
@WebListener()
public class HttpListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       Logger.getAnonymousLogger().log(Level.INFO, "Http session created. sessionId: "+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Logger.getAnonymousLogger().log(Level.INFO, "Http session destroyed. sessionId: "+se.getSession().getId());
    }
}
