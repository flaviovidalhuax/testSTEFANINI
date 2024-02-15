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
        int num=1;
        Map<String,Integer> count=new HashMap<>();
        Optional<ArrayEntity> data =arrayRepository.findById(id);
        String[] arr=data.orElseThrow().getArr();
        for (String e:arr){
            System.out.println("e = " + e);
            for (int j=0; j<elementos.size(); j++){
                count.put(elementos.get(j), num);
                if (elementos.get(j).contains(e)){
                    if(count.get(e)>0){
                        num=count.get(e)+1;
                        count.put(elementos.get(j), num);
                    }else {
                        num=1;
                    }
                    num=1;
                }
            }

        }

    return count;
    }
}
