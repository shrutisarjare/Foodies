package in.foodapp.foodies.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.foodapp.foodies.io.FoodRequest;
import in.foodapp.foodies.io.FoodResponse;
import in.foodapp.foodies.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/foods")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping
    public FoodResponse addFood(@RequestPart("food") String foodString, @RequestPart("file")MultipartFile file){
        ObjectMapper objectMapper=new ObjectMapper();
        FoodRequest request=null;
        try{
           request= objectMapper.readValue(foodString,FoodRequest.class);

        }catch(JsonProcessingException ex){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid json format");
        }
        return foodService.addFood(request,file);
    }
    @GetMapping
    public List<FoodResponse> readFoods(){
        return foodService.readFoods();
    }
    @GetMapping("/{id}")
    public FoodResponse readFood(@PathVariable String id){
        return foodService.readFood(id);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteFile(@PathVariable String id){
        foodService.deleteFood(id);

    }
}
