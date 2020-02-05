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
import corbos.fieldagent.entities.Agent;
import corbos.fieldagent.entities.Assignment;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Joe
 */
@Controller
public class MainController {

    @Autowired
    AgentRepository agents;

    @Autowired
    AssignmentRepository assignments;

    @Autowired
    AgencyRepository agencies;

    @Autowired
    CountryRepository countries;

    @Autowired
    SecurityClearanceRepository securities;

    Set<ConstraintViolation<Agent>> violations = new HashSet<>();
    
    Set<ConstraintViolation<Assignment>> violation = new HashSet<>();
    
    Set<String> idViolation = new HashSet<>();

    @GetMapping("/home")
    public String displayHomePage(Model model) {
        idViolation.clear();
        violations.clear();
        violation.clear();
        model.addAttribute("agents", agents.findAll());
        return "home";
    }

    @GetMapping("/addAgent")
    public String displayAddAgentPage(Model model) {
        Agent agent = new Agent();
        model.addAttribute("agencies", agencies.findAll());
        model.addAttribute("securities", securities.findAll());
        model.addAttribute("agent", agent);
        model.addAttribute("errors", violations);
        model.addAttribute("stringErrors", idViolation);
        return "addAgent";
    }

    @PostMapping("/addAgent")
    public String addAgent(@ModelAttribute Agent agent, String string) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(agent);

       List<Agent> agentIds = agents.findAll();
       for(int i = 0; i < agentIds.size(); i++){
           if(agentIds.get(i).getIdentifier().equals(agent.getIdentifier())){
              idViolation.add("Identifier already taken.");
              return "redirect:/addAgent";
           }
       }
       
       
        
        if (violations.isEmpty()) {
            agents.save(agent);
            return "redirect:/home";
        }
        else{
        return "redirect:/addAgent";
    }
    }

    @GetMapping("/displayAgent")
    public String displayDeleteAgentPage(Model model, String id) {
        Agent agent = agents.findById(id).orElse(null);
        List<Assignment> assignmentList = assignments.findByAgentIdentifier(id);
        model.addAttribute(assignments.findByAgentIdentifier(id));
        model.addAttribute(agents.findById(id));
        model.addAttribute("agent", agent);
        model.addAttribute("assignmentNumber", assignmentList.size());

        return "deleteAgent";
    }

    @GetMapping("/deleteAgent")
    public String deleteAgent(String id) {
        List<Assignment> assignment = assignments.findByAgentIdentifier(id);
        for (int i = 0; i < assignment.size(); i++) {
            assignments.deleteById(assignment.get(i).getAssignmentId());
        }

        agents.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/fieldAgent")
    public String displayFieldAgentPage(Model model, String id) {
        Agent agent = agents.findById(id).orElse(null);
        List<Assignment> assignment = assignments.findByAgentIdentifier(id);
        for (int i = 0; i < assignment.size(); i++) {
            assignments.findById(assignment.get(i).getAssignmentId());
        }
        
        model.addAttribute("assignment", assignment);
        model.addAttribute("agencies", agencies.findAll());
        model.addAttribute("securities", securities.findAll());
        model.addAttribute("country", countries);
        model.addAttribute("agent", agent);

        return "fieldAgent";
    }

    @PostMapping("/editAgent")
    public String displayEditAgentPage(Model model, String id) {
        Agent agent = agents.findById(id).orElse(null);
        List<Assignment> assignmentList = assignments.findByAgentIdentifier(id);
        model.addAttribute(assignments.findByAgentIdentifier(id));
        model.addAttribute(agents.findById(id));
        model.addAttribute("agent", agent);
        model.addAttribute("assignmentNumber", assignmentList.size());

        return "editAgent";
    }
    
    @GetMapping("editAgent")
    public String editAgent(@ModelAttribute Agent agent) {
         Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(agent);
        if(violations.isEmpty()) {
            agents.save(agent);
            return "redirect:/home";
        }
        return "redirect:/fieldAgent" + agent.getIdentifier();
    }

    @GetMapping("/addAssignment")
    public String displayAssignmentPage(Model model) {
        Assignment assignment = new Assignment();
        model.addAttribute("agent", agents.findAll());
        model.addAttribute("country", countries.findAll());
        model.addAttribute("assignment", assignment);
        model.addAttribute("errors", violation);
        model.addAttribute("stringErrors", idViolation);
        return "addAssignment";
    }

@PostMapping("/addAssignment")
    public String addAssignment(@ModelAttribute Assignment assignment, Agent agent) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violation = validate.validate(assignment);
        if (assignment.getStartDate() == null || assignment.getProjectedEndDate() == null) {
            System.out.println("In The Null Section");
            return "redirect:/addAssignment";
        }
        List<Assignment> assignmentList = assignments.findByAgentIdentifier(agent.getIdentifier());
        for (int i = 0; i < assignmentList.size(); i++) {
            if (assignment.getStartDate().isAfter(assignmentList.get(i).getStartDate()) && assignment.getStartDate().isBefore(assignmentList.get(i).getProjectedEndDate())) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/addAssignment";
            }
            if (assignment.getProjectedEndDate().isAfter(assignmentList.get(i).getStartDate()) && assignment.getProjectedEndDate().isBefore(assignmentList.get(i).getProjectedEndDate())) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/addAssignment";
            }
            if ((assignment.getStartDate().compareTo(assignmentList.get(i).getStartDate()) == 0) || assignment.getStartDate().compareTo(assignmentList.get(i).getProjectedEndDate()) == 0) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/addAssignment";
            }
            if ((assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getStartDate()) == 0) || assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getProjectedEndDate()) == 0) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/addAssignment";
            }
        }
        if (assignment.getStartDate().compareTo(assignment.getProjectedEndDate()) > 0) {
            idViolation.add("Start date can't be after projected end date.");
            return "redirect:/addAssignment";
        }
        if (assignment.getActualEndDate() != null && assignment.getStartDate().compareTo(assignment.getActualEndDate()) > 0) {
            idViolation.add("Start date can't be after actual end date.");
            return "redirect:/addAssignment";
        }
        if (violation.isEmpty()) {
            assignments.save(assignment);
            return "redirect:/home";
        }
        
        System.out.println("At the End Section.");
        return "redirect:/addAssignment";
    }


    @GetMapping("/deleteAssignment")
    public String deleteAssignment(int id) {

        assignments.deleteById(id);

        return "redirect:/home";
    }

    @GetMapping("/displayEditAssignment")
    public String displayEditAssignmentPage(Model model, Integer id) {

        Assignment assignment = assignments.findById(id).orElse(null);
        model.addAttribute("agent", agents.findAll());
        model.addAttribute("country", countries.findAll());
        model.addAttribute("assignment", assignment);
        model.addAttribute("errors", violation);
        model.addAttribute("stringErrors", idViolation);

        return "editAssignment";
    }

    @GetMapping("editAssignment")
    public String editAssignment(@ModelAttribute Assignment assignment, Agent agent) {
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violation = validate.validate(assignment);
        
        
        List<Assignment> assignmentList = assignments.findByAgentIdentifier(agent.getIdentifier());
        for (int i = 0; i < assignmentList.size(); i++) {
            if(assignment.getAssignmentId() != assignmentList.get(i).getAssignmentId()){
                
            
            if (assignment.getStartDate().isAfter(assignmentList.get(i).getStartDate()) && assignment.getStartDate().isBefore(assignmentList.get(i).getProjectedEndDate())) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/displayEditAssignment?id=" + assignment.getAssignmentId();
            }
            if (assignment.getProjectedEndDate().isAfter(assignmentList.get(i).getStartDate()) && assignment.getProjectedEndDate().isBefore(assignmentList.get(i).getProjectedEndDate())) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/displayEditAssignment?id=" + assignment.getAssignmentId();
            }
            if ((assignment.getStartDate().compareTo(assignmentList.get(i).getStartDate()) == 0) || assignment.getStartDate().compareTo(assignmentList.get(i).getProjectedEndDate()) == 0) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:displayEditAssignment?id=" + assignment.getAssignmentId();
            }
            if ((assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getStartDate()) == 0) || assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getProjectedEndDate()) == 0) {
                idViolation.add("Agent is already on assignment.");
                return "redirect:/displayEditAssignment?id=" + assignment.getAssignmentId();
            }
          }
        }
        
        if(assignment.getActualEndDate() == null || assignment.getStartDate() == null || assignment.getProjectedEndDate() == null) {
            return "redirect:/displayEditAssignment?id=" + assignment.getAssignmentId();
        }
        if(assignment.getStartDate().compareTo(assignment.getProjectedEndDate()) > 0 ) {
            idViolation.add("Start date can't be after project end date");
            return "redirect:/displayEditAssignment?id=" + assignment.getAssignmentId();
        }
        
        if(assignment.getStartDate().compareTo(assignment.getActualEndDate()) > 0) {
             idViolation.add("Start date can't be after end date");
            return "redirect:/displayEditAssignment?id=" + assignment.getAssignmentId();
        }
        
        if (violation.isEmpty()) {
            assignments.save(assignment);
            return "redirect:/home";
        }
        
        return "redirect:/displayEditAssignment" + assignment.getAssignmentId();
    }
  
    /*
        @GetMapping("/editAssignment")
    public String editAssignment(@ModelAttribute Assignment assignment) {

        assignments.save(assignment);

        return "redirect:/home";
    }
*/
}
