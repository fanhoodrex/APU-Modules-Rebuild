package cf.mrzhs.controller;

import cf.mrzhs.dto.PageDTO;
import cf.mrzhs.pojo.User;
import cf.mrzhs.provider.CheckProvider;
import cf.mrzhs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    @Autowired
    private CheckProvider checkProvider;
    @Autowired
    private QuestionService questionService;

    @GetMapping({"/","/index.html","/index"})
    public String indexPage(Model m,
                            HttpServletRequest request,
                            @RequestParam(name="page", defaultValue = "1") Integer page,
                            @RequestParam(name = "size", defaultValue = "5") Integer size){
//        因为前端渲染页面需要用户头像的url,但是Question对象模型没有,需要用它的DTO模型
        PageDTO pageDTO = questionService.IndexList(page,size);
        
        m.addAttribute("allPage",pageDTO);
        return "index";
    }
    
    @GetMapping("/clear")
    public String clearCookie(HttpServletRequest request,
                              HttpServletResponse response){
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/index";
    }
}
