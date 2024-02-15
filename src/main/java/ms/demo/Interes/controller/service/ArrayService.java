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


    public Map testService(Long id, String[] elementos) {
        Map<String, String> count=new HashMap<>();
        Optional<ArrayEntity> data =arrayRepository.findById(id);
        String[] arr=data.orElseThrow().getArr();

        for (String e:arr){
            if (e==elementos[0]){
                count.put(e, elementos[0]);
            }
            if (e==elementos[1]){
                count.put(e, elementos[1]);
            }
        }

    return count;
    }
}
