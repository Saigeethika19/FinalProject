package com.main.services;

import java.util.List;

import com.main.entity.FoodItem;

public interface FoodItemService
{
//	create
	FoodItem createFoodItem(FoodItem foodItem);
	
	
//	Get Single Food
	List<FoodItem> getFoodItemByCategory(String category);
//	Get FoodItem By Id
	FoodItem getFoodItemById(Integer foodItemId);
//	For Update the Food Item
	FoodItem updateFoodItem(FoodItem postDto,Integer FoodItemId);
	
	List<FoodItem>saveMultipleFoodItem(List<FoodItem>foodItems);

}
