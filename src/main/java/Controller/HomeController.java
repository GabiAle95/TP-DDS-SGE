package Login;
import spark.*;
import java.util.*;
import Helpers.*;
import Helpers.ViewHelper;
import Usuarios.ClienteDAO;
import Usuarios.UsuarioController;
import spark.Route;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static Helpers.RequestHelper.*;

public class HomeController {
	
	public static Route homeClientePage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        String myUser = request.session().attribute("currentUser");
        ClienteDAO dao = new ClienteDAO();
        if (dao.recuperarPorUsername(myUser).esAdmin()) {
        	
        	return ViewHelper.render(request, model, "homeAdmin.html");

        }
        else {
        	
        	return ViewHelper.render(request, model, "homeCliente.html");
        }
        
    };

}