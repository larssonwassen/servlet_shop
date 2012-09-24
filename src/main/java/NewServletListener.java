
import edu.chl.hajo.shop.core.Shop;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author xclose
 */
public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger.getAnonymousLogger().log(Level.INFO,"Putting Shop in application scope");
        sce.getServletContext().setAttribute("shop", Shop.INSTANCE);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       
    }
}
