package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.RecipeDao;
import com.revature.dao.RecipeDaoImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.exceptions.RecipeNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.RUser;
import com.revature.models.Recipe;
import com.revature.services.RecipeService;


@Controller
@CrossOrigin
/**
 * @author Jonathan
 *This class is our controller for saving, deleting recipes, as well a returning recipes by user, and all recipes stored
 *in the database.
 */
public class RecipeController {
	
	private static Logger log = Logger.getRootLogger();
	private static UserDAO ud = new UserDAOImpl();
	
	
	@Autowired
	private static RecipeService rService = new RecipeService();
	
	/**
	 * Perform a GET request to /recipes/{id}, where {id} is the parameter
	 * to get all the recipes saved by the user.
	 * 
	 * @param recipeId
	 * @return
	 */
	@GetMapping("/recipes/{id}")
	@ResponseBody
	public Recipe printRecipeByRecipeId(@PathVariable("id") int recipeId) {
		
		Recipe recipe = rService.getRecipeByRecipeId(recipeId);
		
		if(recipe == null) {
			throw new RecipeNotFoundException();
		}
		
		return recipe;
		
	}
	
	/**
	 * @deprecated
	 */
	@GetMapping("recipes/users")
	public String getSearchPage() {
		return "RecipesByUser";
	}
	
	/**
	 * 
	 * Mapped to the endpoint /recipes/users. Perform a GET request and it returns the recipes saved
	 * by the user.
	 * @param userId
	 * @return List<Recipe> recipes
	 */
	@GetMapping("/recipes/users/{id}")
	@ResponseBody
	public List<Recipe> printRecipesByUserId(@PathVariable("id") int userId) {
		
		List<Recipe> recipes = rService.getAllRecipesByUserId(userId);
		
		Collections.sort(recipes,Collections.reverseOrder());
		
//		if(recipes.size() == 0) {
//			throw new UserNotFoundException();
//		}
		
		return recipes;
	}
	
	
	/**
	 * Perform a GET request to the endpoint /recipes to get all recipes stored in the database. 
	 * @return List<Recipe>
	 */
	@GetMapping("/recipes")
	@ResponseBody
	public List<Recipe> printAllRecipes() {
		List<Recipe> recipes = rService.getAllRecipes();
		Collections.sort(recipes,Collections.reverseOrder());
		return recipes;
	}
	
	/**
	 * Perform a POST request to the endpoint recipes/save with the user id and json
	 * as parameters in the body to save a recipe.
	 * @param userId
	 * @param recipeJSON
	 * @return
	 */
	@RequestMapping(value="recipes/save", method=RequestMethod.POST)
	public String saveRecipe(@RequestParam("userId") String userId, @RequestParam("JSON") String recipeJSON) {
		
		Recipe recipe = new Recipe();
		recipe.setrecipeJSON(recipeJSON);
		RUser user = ud.getUserByUserId(Integer.parseInt(userId));
		
		if(user == null) {
			throw new UserNotFoundException();
		}
		
		recipe.setUser(user);
		rService.saveRecipe(recipe);
		
		return "redirect:/recipes";
		
	}
	
	/**
	 * Perform a POST request to the endpoint /recipes/delete with the recipe ID as a parameter
	 * to delete a recipe. 
	 * @param recipeId
	 * @return
	 */
	@RequestMapping(value="recipes/delete", method=RequestMethod.POST)
	public String deleteRecipe(@RequestParam("recipeId") String recipeId) {
		
		Recipe recipe = rService.getRecipeByRecipeId(Integer.parseInt(recipeId));
		
		if(recipe == null) {
			throw new RecipeNotFoundException();
		}
		
		rService.deleteRecipe(recipe);
		
		return "redirect:/recipes";
		
	}
	
	/**
	 * @deprecated
	 */
	@RequestMapping(value="recipes/save", method=RequestMethod.GET)
	public String getSaveRecipe() {
		return "SaveRecipe";
	}
	
	/**
	 * @deprecated
	 */
	@RequestMapping(value="recipes/delete", method=RequestMethod.GET)
	public String getDeleteRecipe() {
		return "DeleteRecipe";
	}
	
}
