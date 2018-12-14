package com.pimwi.marvel.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pimwi.marvel.model.Favorite;
import com.pimwi.marvel.repository.FavoriteRepository;
import com.pimwi.marvel.service.response.Characters;
import com.pimwi.marvel.service.response.CharactersResponse;

@Service
public class CharactersService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FavoriteRepository favoriteRepository;

	@Value("${api.privatekey}")
	private String privateKey;
	
	@Value("${api.publickey}")
	private String publicKey;

	@Value("${api.path}")
	private String path;

	@Value("${api.path.endpointcharacters}")
	private String endpointcharacters;
	
	/**
	 * Get all existing marvels characters 
	 * @return List<Characters>
	 */
	public List<Characters> getAllCharacters() {
		CharactersResponse claimResponse = 
				this.restTemplate.getForObject(getUrl(), CharactersResponse.class);
						
		return claimResponse.getData().getResults();
	}

	/**
	 * Mark a character as favorite
	 * @param id of characters
	 */
	public void addCharactersToFavorite(long id) {

		Optional<Favorite> existingFavorite = favoriteRepository.findById(id);

		if (existingFavorite.isPresent()) {
			//Existing exception
		}

		Favorite favorite = new Favorite(id, true);
		favoriteRepository.save(favorite);
	}

	/**
	 * Remove character as favorite
	 * @param id of characters
	 */
	public void removeCharactersToFavorite(long id) {

		Optional<Favorite> favorite = favoriteRepository.findById(id);

		if (!favorite.isPresent()) {
			//Not found exception
		}
		
		favoriteRepository.deleteById(id);
	}
	
	public List<Favorite> getAllFavoriteCharacter() {
		return favoriteRepository.findAll();
	}
	
	private String getUrl() {
		long timeStamp = Instant.now().getEpochSecond();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] digest = md.digest((timeStamp + privateKey + publicKey).getBytes());
		
		String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
		return path + endpointcharacters + "?apikey="+ publicKey +"&ts="+ timeStamp + "&hash=" + hash;
	}
}
