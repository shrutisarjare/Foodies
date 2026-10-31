package in.foodapp.foodies.service;

import in.foodapp.foodies.io.FoodRequest;
import in.foodapp.foodies.io.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {
   String  uploadFile(MultipartFile file);
   FoodResponse addFood(FoodRequest request,MultipartFile file);
   List<FoodResponse> readFoods();
   FoodResponse readFood(String id);
   boolean  deleteFile(String filename);
   void deleteFood(String id);
}
