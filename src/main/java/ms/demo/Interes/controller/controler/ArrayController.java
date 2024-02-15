package ms.demo.Interes.controller.controler;
import ms.demo.Interes.controller.entity.ArrayEntity;
import ms.demo.Interes.controller.service.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ArrayController {
    @Autowired
    ArrayService arrayService;
    @GetMapping("/ok")
    public String hello(){
        return "ok";
    }

    @PostMapping("/array")
    public  String saveArray(@RequestBody ArrayEntity arr){
        arrayService.saveArray(arr);
        return "creado";
    }
    @GetMapping("/allArray")
    public List<ArrayEntity> buscarTados(){
       return arrayService.allArrays();
    }
    @GetMapping("/logic/{id}")
    public Map testController(@PathVariable Long id, @RequestBody String[] elementos){
        System.out.println("elementos = " + elementos);
        return arrayService.testService(id, elementos);
    }

}
