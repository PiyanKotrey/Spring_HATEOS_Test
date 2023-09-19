package com.example.spring_hateoas_test.api.footballer;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/footballers")
public class FootballerRestController {
    @GetMapping
    public CollectionModel<EntityModel> getAll(){
        List<Footballer> footballerList = Arrays.asList(
                new Footballer(1,"Leo Messi",10,"AMF",100),
                new Footballer(2,"Kai Havert",29,"AMF",90),
                new Footballer(3,"Karim Benzema",9,"AMF",99),
                new Footballer(4,"Neymar Jr",11,"AMF",100)
        );

        List<EntityModel> entityModelList = new ArrayList<>();
        Link seftlink=WebMvcLinkBuilder.linkTo(FootballerRestController.class)
                .slash("{id}")
                .withSelfRel();
        for (Footballer footballer:footballerList){
            EntityModel<Footballer> model = EntityModel.of(footballer);
            model.add(seftlink);
            entityModelList.add(model);
        }
        return CollectionModel.of(entityModelList, seftlink);
    }
}
