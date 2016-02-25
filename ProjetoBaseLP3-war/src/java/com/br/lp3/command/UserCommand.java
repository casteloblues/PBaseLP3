package com.br.lp3.command;

import com.br.lp3.DAO.UserLP3DAO;
import com.br.lp3.entities.UserLP3;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCommand implements Command {
    
    public HttpServletRequest request;
    public HttpServletResponse response;
    public String returnPage = "index.jsp";
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch(action){
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String check = request.getParameter("checkSave"); //on ou off 
                
                UserLP3DAO uDao = new UserLP3DAO();
                UserLP3 user = uDao.readByUsername(username);
                
                if(user != null && user.getPassword().equals(password)){
                    request.getSession().setAttribute("username", username);
                    returnPage = "index.jsp";
      
                    if ("on".equals(check)){
                        //salvar no cookie a partir daqui
                        Cookie c = new Cookie("usernameCookie", username);
                        c.setMaxAge(60*60*24*7); //em segundos, salvando o cookie por uma semana
                        response.addCookie(c);
                        
                        Cookie c2 = new Cookie("passwordCookie", password);
                        c2.setMaxAge(60*60*24*7);
                        response.addCookie(c2); 
                    } else {
                        //zerar cookie a partir daqui do jeito porco kk 
                        Cookie c = new Cookie("usernameCookie", "");
                        c.setMaxAge(0); //em segundos, salvando o cookie por uma semana
                        response.addCookie(c);
                        
                        Cookie c2 = new Cookie("passwordCookie", "");
                        c2.setMaxAge(0);
                        response.addCookie(c2);
                    }
                } else {
                    request.getSession().setAttribute("errormsg", "usuário inexistente ou senha incorreta");
                    returnPage = "login.jsp";
                }
                break;
                
            case "logout":
                request.getSession().setAttribute("username", null);
                returnPage = "index.jsp";
                break;
                
//            case "cookies":
//                Cookie[] cookies = request.getCookies();
//                
//                for (Cookie cookie : cookies) {
//                    if(cookie.getName().equals("usernameCookie")){
//                        request.getSession().setAttribute("usernameC", cookie.getValue());
//                    } else if(cookie.getName().equals("passwordCookie")){
//                        request.getSession().setAttribute("passwordC", cookie.getValue());
//                    }
//                } 
//                
//                returnPage = "login.jsp";
//                break;
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
}
