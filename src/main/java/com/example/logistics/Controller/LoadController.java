package com.example.logistics.Controller;

import com.example.logistics.Model.Load;
import com.example.logistics.Service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private  LoadService loadService;

    //add load details
    @PostMapping()
    public ResponseEntity<String> addLoad(@RequestBody Load load)  {
        return loadService.addLoad(load);
    }

    //get All loads details Or by shipperId (Query params)
    @GetMapping()
    public ResponseEntity<List<Load>> getLoadsByShipperId(
            @RequestParam(required = false) String shipperId)
    {
        return loadService.getLoadsByShipperId(shipperId);
    }

    //get load details by load Id
    @GetMapping("/{loadId}")
    public Load getLoadByLoadId(@PathVariable long loadId){
        return loadService.getLoadByLoadId(loadId);
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateEmployeeById(@PathVariable long loadId, @RequestBody Load load){
        return loadService.updateEmployeeById(loadId,load);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoadByLoadId(@PathVariable long loadId){
        return loadService.deleteLoadByLoadId(loadId);
    }
}
