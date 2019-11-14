package de.sparkasse.tilgungsplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public String index() {
        return "index";
    }
}
