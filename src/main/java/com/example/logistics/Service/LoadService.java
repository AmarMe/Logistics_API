package com.example.logistics.Service;

import com.example.logistics.Model.Load;
import com.example.logistics.Repository.LoadDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class LoadService {
    @Autowired
    private  LoadDao loadDao;

    public ResponseEntity<String> addLoad(Load load)  {
         loadDao.save(load);
         return ResponseEntity.ok("loads details added successfully");
    }

    public ResponseEntity<List<Load>> getLoadsByShipperId(String shipperId) {
        List<Load> loadList;
        if(shipperId!=null && !shipperId.isEmpty()) {
            loadList = loadDao.findByShipperId(shipperId);
            if (!loadList.isEmpty())
                return new ResponseEntity<>(loadList,HttpStatus.OK);
            else
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ShipperId "+shipperId+" not exists");
        }
        loadList = loadDao.findAll();
        if (!loadList.isEmpty())
            return new ResponseEntity<>(loadList,HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There are no loads exists");
    }


    public Load getLoadByLoadId(long loadId) {
        return loadDao.findById(loadId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Load Id " + loadId + " not exists"));
    }

    @Transactional
    public ResponseEntity<Load> updateEmployeeById(long loadId, Load load) {
        Load loadDetails=loadDao.findById(loadId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Load Id "+loadId+" not exists"));
        if(load.getLoadingPoint()!=null)
            loadDetails.setLoadingPoint(load.getLoadingPoint());
        if(load.getUnloadingPoint()!=null)
            loadDetails.setUnloadingPoint(load.getUnloadingPoint());
        if(load.getProductType()!=null)
            loadDetails.setProductType(load.getProductType());
        if(load.getTruckType()!=null)
            loadDetails.setTruckType(load.getTruckType());
        if(load.getNoOfTrucks()!=null)
            loadDetails.setNoOfTrucks(load.getNoOfTrucks());
        if(load.getWeight()!=null)
            loadDetails.setWeight(load.getWeight());
        if(load.getComment()!=null)
            loadDetails.setComment(load.getComment());
        if(load.getDate()!=null)
            loadDetails.setDate(load.getDate());

        return new ResponseEntity<>(loadDetails,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLoadByLoadId(long loadId){
        boolean loadDetails=loadDao.existsById(loadId);
        if(!loadDetails)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Load Id "+loadId+" not exists");
        try {
            loadDao.deleteById(loadId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error deleting Load"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
