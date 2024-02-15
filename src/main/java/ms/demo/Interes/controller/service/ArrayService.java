package ms.demo.Interes.controller.service;

import ms.demo.Interes.controller.entity.ArrayEntity;
import ms.demo.Interes.controller.repository.ArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArrayService {

    @Autowired
    ArrayRepository arrayRepository;

    public void saveArray(ArrayEntity arr) {
        arrayRepository.save(arr);
    }

    public List<ArrayEntity> allArrays() {
       return (List<ArrayEntity>) arrayRepository.findAll();
    }


    public Map testService(Long id, List<String> elementos ) {
        Map<String, String> count=new HashMap<>();
        Optional<ArrayEntity> data =arrayRepository.findById(id);
        String[] arr=data.orElseThrow().getArr();
        System.out.println(" =-------------- ");
        System.out.println("elementos 0 = " + elementos.get(0));
        System.out.println("elementos 1 = " + elementos.get(1));
//        System.out.println(elementos.get(3));
        for (String e:arr){
            System.out.println("e = " + e);
            for (int j=0; j<elementos.size(); j++){
                if (e.contains(elementos.get(j))){
                    count.put(e, elementos.get(j));
                }

            }
        }

    return count;
    }
}
