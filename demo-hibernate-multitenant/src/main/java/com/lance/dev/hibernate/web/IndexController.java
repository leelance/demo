package com.lance.dev.hibernate.web;

import com.lance.dev.hibernate.common.ContextHolder;
import com.lance.dev.hibernate.service.MarriageEnumService;
import com.lance.dev.hibernate.service.UserService;
import com.lance.dev.hibernate.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lance
 * @since 2015/2/13 13:12.
 */
@Controller
public class IndexController {
    @Autowired
    private MarriageEnumService marriageEnumService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = {"/", "index"})
    public String index(HttpServletRequest request) {
        request.setAttribute("marries",marriageEnumService.findAll());
        return "index.jsp";
    }

    @RequestMapping("change/{name}")
    public String changeTenant(@PathVariable String name) {
        ContextHolder.setContext(name);
        userServiceImpl.setTenantId(name);
        //redirect.addFlashAttribute("marries",marriageEnumService.findAll());
        return "redirect:/index";
    }
}
