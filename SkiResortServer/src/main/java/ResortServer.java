import Model.Status;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResortServer", value = "/ResortServer")
public class ResortServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String urlPath = req.getPathInfo();

        // check we have a URL!
        if (urlPath == null || urlPath.isEmpty()) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.getWriter().write("missing parameters");
            return;
        }

        String[] urlParts = urlPath.split("/");
        // and now validate url path and return the response status code
        // (and maybe also some value if input is valid)

        if (!isUrlValid(urlParts)) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.getWriter().write("incorrect parameters");
        } else {
            res.setStatus(HttpServletResponse.SC_OK);
            // do any sophisticated processing with urlParts which contains all the url params
            // TODO: process url params in `urlParts`
            res.getWriter().write("It works!");
        }
    }

    private boolean isUrlValid(String[] urlPath) {
        // TODO: validate the request url path according to the API spec
        // urlPath  = "/1/seasons/2019/day/1/skier/123"
        // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]
        if(urlPath.length != 8) {
            return false;
        } else if(!urlPath[0].equals("")) {
            return false;
        } else if(urlPath[1].equals("")) {
            return false;
        } else if (!urlPath[2].equals("seasons")) {
            return false;
        } else if (urlPath[3].equals("") ||
                Integer.parseInt(urlPath[3]) > 2022 || Integer.parseInt(urlPath[3]) < 2000) {
            return false;
        } else if (!urlPath[4].equals("day")) {
            return false;
        }  else if ( urlPath[5].equals("")  ||
                Integer.parseInt(urlPath[5]) > 366 || Integer.parseInt(urlPath[5]) < 1) {
            return false;
        } else if (!urlPath[6].equals("skier")) {
            return false;
        } else if (urlPath[7].equals("") || Integer.parseInt(urlPath[7]) < 0) {
            return false;
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // POST request pass from url or json?????
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }

//            LiftData liftData = (LiftData) gson.fromJson(sb.toString(), LiftData.class);
            Status status = new Status();
            // TODO some validation here
//            if ()) {
//                status.setSuccess(true);
//                status.setDescription("Success, lift data successfully update");
//            } else {
//                status.setSuccess(false);
//                status.setDescription("Fail");
//            }
            response.getOutputStream().print(gson.toJson(status));
            response.getOutputStream().flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            Status status = new Status(false, ex.getMessage());
            response.getOutputStream().print(gson.toJson(status));
            response.getOutputStream().flush();
        }
    }
}
