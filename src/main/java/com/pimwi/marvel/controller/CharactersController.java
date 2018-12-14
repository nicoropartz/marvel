package com.pimwi.marvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pimwi.marvel.model.Favorite;
import com.pimwi.marvel.service.CharactersService;
import com.pimwi.marvel.service.response.Characters;

@RestController
public class CharactersController {

	@Autowired
	private CharactersService characterService;

	
	@GetMapping("/characters")
	public List<Characters> getAllCharacter() {
		return characterService.getAllCharacters();
	}
	
	@GetMapping("/characters/{id}/favorite/remove")
	public void removefavorite(
			@PathVariable(value = "id") long idCharacters) {
		characterService.removeCharactersToFavorite(idCharacters);
	}

	@GetMapping("/characters/{id}/favorite/add")
	public void addFavorite(
			@PathVariable(value = "id") long idCharacters) {
		characterService.addCharactersToFavorite(idCharacters);
	}

	@GetMapping("/characters/favorite")
	public List<Favorite> getAllFavorite() {
		return characterService.getAllFavoriteCharacter();
	}
}
