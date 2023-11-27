package clayton.eduard.oulhostbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView andView = new ModelAndView();
        andView.setViewName("index.html");
        return andView;
    }

}