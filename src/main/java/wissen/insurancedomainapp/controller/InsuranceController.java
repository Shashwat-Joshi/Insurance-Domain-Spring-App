package wissen.insurancedomainapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wissen.insurancedomainapp.models.Insurance;
import wissen.insurancedomainapp.repository.IInsuranceRepository;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    IInsuranceRepository insuranceRepository;

    @GetMapping("/get")
    public List<Insurance> getAllInsurance() {
        List<Insurance> insuranceList = insuranceRepository.findAll();
        return insuranceList;
    }

    @GetMapping("/get/{id}")
    public Object getInsuranceByID(@PathVariable int id) {
        Optional<Insurance> insurance = insuranceRepository.findById(id);
        if(insurance.isPresent()) {
            return insurance.get();
        }
        return "404: Insurance with Policy ID: " + id + " not found";
    }

    @PostMapping("/insert")
    public List<Insurance> insertInsurance(@RequestBody List<Insurance> insuranceList) {
        for(Insurance i : insuranceList)
            System.out.println(i);
        List<Insurance> savedList = insuranceRepository.saveAll(insuranceList);
        return savedList;
    }

    @PutMapping("/update")
    public Object updateInsurance(@RequestBody Insurance insurance) {
        int id = insurance.getPolicyId();
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(id);
        if(optionalInsurance.isPresent()) {
            Insurance insuranceToUpdate = optionalInsurance.get();
            insuranceToUpdate.setName(insurance.getName());
            insuranceToUpdate.setPolicyAmt(insurance.getPolicyAmt());
            insuranceToUpdate.setEmi(insurance.getEmi());
            return insuranceRepository.save(insuranceToUpdate);
        }
        return "404: Insurance with Policy ID: " + id + " not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInsurance(@PathVariable int id) {
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(id);
        if(optionalInsurance.isPresent()) {
            insuranceRepository.deleteById(id);
            return "Insurance with Policy ID: " + id + " deleted successfully";
        }
        return "404: Insurance with Policy ID: " + id + " not found";
    }
}
