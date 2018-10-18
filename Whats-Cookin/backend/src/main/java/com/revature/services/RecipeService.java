package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.RecipeDao;
import com.revature.dao.RecipeDaoImpl;
import com.revature.models.RUser;
import com.revature.models.Recipe;

@Service
public class RecipeService {
	
	private RecipeDao rd = new RecipeDaoImpl();

	public RecipeService() {
		super();
	}
	
	public List<Recipe> getAllRecipes(){
		return rd.getAllRecipes();
	}
	
	public Recipe getRecipeByRecipeId(int recipeId) {
		return rd.getRecipeByRecipeId(recipeId);
	}
	
	public List<Recipe> getAllRecipesByUserId(int userId) {
		return rd.getAllRecipesByUserId(userId);
	}
	
	public List<Recipe> getAllRecipesByUser(RUser user){
		return rd.getAllRecipesByUser(user);
	}
	
	public String saveRecipe(Recipe recipe) {
		if(rd.saveRecipe(recipe) > 0) {
			return "Success";
		}else {
			return "Failed";
		}
	}
	
	public void persisRecipe(Recipe recipe) {
		rd.persistRecipe(recipe);
	}
	
	public Recipe mergeRecipe(Recipe recipe) {
		return rd.mergeRecipe(recipe);
	}
	
	public void updateRecipe(Recipe recipe) {
		rd.updateRecipe(recipe);
	}
	
	public Recipe loadRecipe(int recipeId) {
		return rd.loadRecipe(recipeId);
	}
	
	public void deleteRecipe(Recipe recipe) {
		rd.deleteRecipe(recipe);
	}
	

	

}
