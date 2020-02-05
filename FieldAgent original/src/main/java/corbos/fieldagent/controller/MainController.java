/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.controller;

import corbos.fieldagent.data.AgencyRepository;
import corbos.fieldagent.data.AgentRepository;
import corbos.fieldagent.data.AssignmentRepository;
import corbos.fieldagent.data.CountryRepository;
import corbos.fieldagent.data.SecurityClearanceRepository;
import corbos.fieldagent.entities.Agency;
import corbos.fieldagent.entities.Agent;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joe
 */
public class MainController {
    @Autowired
    AgentRepository agents;
    
    @Autowired
    AgencyRepository agencies;

    @Autowired
    AssignmentRepository assignments;
    
    @Autowired
    CountryRepository countries;
    
    @Autowired
    SecurityClearanceRepository securityClearance;
    

    @GetMapping("/viewAgents")
    public String viewInventory(Integer id, Model model) {
        Store store = stores.findById(id).orElse(null);
        List<Product> productList = products.findByStore(store);
        model.addAttribute("store", store);
        model.addAttribute("products", productList);
        return "inventory";
    }
    
}
