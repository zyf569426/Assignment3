import Models.LiftRide;
import Models.Status;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SkierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String urlPath = request.getPathInfo();

        // check we have a URL!
        if (urlPath == null || urlPath.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("missing parameters");
            return;
        }

        String[] urlParts = urlPath.split("/");
        // and now validate url path and return the response status code
        // (and maybe also some value if input is valid)

        if (!isUrlValid(urlParts)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("incorrect parameters");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            // do any sophisticated processing with urlParts which contains all the url params
            // TODO: process url params in `urlParts`
            response.getWriter().write("It works!");
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
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        try {
            String urlPath = request.getPathInfo();
            // check we have a URL!
            if (urlPath == null || urlPath.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("missing parameters");
                return;
            }

            String[] urlParts = urlPath.split("/");

            if (!isUrlValid(urlParts)) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getOutputStream().println("incorrect parameters");
            } else {
                response.setStatus(HttpServletResponse.SC_OK);
                // do any sophisticated processing with urlParts which contains all the url params
                // TODO: process url params in `urlParts`
                StringBuilder sb = new StringBuilder();
                String s;
                while ((s = request.getReader().readLine()) != null) {
                    sb.append(s);
                }
                LiftRide liftRide = (LiftRide) gson.fromJson(sb.toString(), LiftRide.class);
                Status status = new Status();
                // TODO some validation here
                if (liftRide.getLiftID() != null && liftRide.getTime() != null) {
                    status.setSuccess(true);
                    status.setDescription("Success, lift data successfully update");
                } else {
                    status.setSuccess(false);
                    status.setDescription("Fail");
                }
                response.getOutputStream().println(gson.toJson(status));
                response.getOutputStream().println(gson.toJson(liftRide));
                response.getOutputStream().flush();
                response.getOutputStream().println("It works!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Status status = new Status(false, ex.getMessage());
            response.getOutputStream().print(gson.toJson(status));
            response.getOutputStream().flush();
        }
    }
}
