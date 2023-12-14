package rvt;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    
   @GetMapping(value = "/")
    String index(@RequestParam(name="name", required=false, defaultValue="null") String name, Model model) {
        CsvManager manager = new CsvManager(CsvManager.CSV_FILE);
        ArrayList<HashMap> hobbies = manager.getAllHobbies();

        model.addAttribute("hobbies", hobbies);


        String myName = "Daniel";
        ArrayList<String> hikingitem = new ArrayList<String>();
        hikingitem.add("water");
        hikingitem.add("piens");
        hikingitem.add("nazis");
        
        
        model.addAttribute("name", myName);
        model.addAttribute("hikingitems", hikingitem);



        return "index";
    }
}
    