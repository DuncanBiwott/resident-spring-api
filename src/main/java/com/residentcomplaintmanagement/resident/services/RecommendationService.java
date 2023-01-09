package com.residentcomplaintmanagement.resident.services;

import com.residentcomplaintmanagement.resident.model.Recommendation;
import com.residentcomplaintmanagement.resident.respository.RecomendationReposity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@Slf4j
public class RecommendationService {


    @Autowired
    RecomendationReposity recomendationReposity;

    public List<Recommendation> findAll(){

        return recomendationReposity.findAll();
    }

    public  Recommendation create(Recommendation recommendation){

        try {
            return recomendationReposity.save(recommendation);
        }catch (Exception e){

            log.error("Error Occured",e);
            return null;
        }

    }
}
