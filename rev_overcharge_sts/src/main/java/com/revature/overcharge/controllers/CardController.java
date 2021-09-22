package com.revature.overcharge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.Card;
import com.revature.overcharge.services.CardService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class CardController {
	private static final Logger log = LoggerFactory.getLogger(CardController.class);

	@Autowired
	CardService cs;

	@PostMapping(value = "/decks/{id}/cards", consumes = "application/json", produces = "application/json")
	public Card addCard(@PathVariable("id") int deckId, @RequestBody Card c) {
		return cs.addCard(deckId, c);
	}

	@GetMapping(value = "/cards/{id}")
	public Card getCard(@PathVariable("id") int id) {
		return cs.getCard(id);
	}

	@GetMapping(value = "/cards")
	public List<Card> getAllCards() {
		return cs.getAllCards();
	}

	@GetMapping(value = "/decks/{id}/cards")
	public List<Card> getCardsByDeckId(@PathVariable("id") int id) {
		return cs.getCardsByDeckId(id);
	}

	 @PutMapping(value = "/cards/{deck_id}", consumes = "application/json",
	            produces = "application/json")
	    public Card updateCard(@PathVariable("deck_id") int deckId, @RequestBody Card c) {
	    	log.trace("updateCard(): deck_id: [" + deckId +"] Card: [" + c.toString() + "]");
	        return cs.updateCard(deckId, c);
	}

	@DeleteMapping(value = "/cards/{id}")
	public boolean deleteCard(@PathVariable("id") int id) {
		return cs.deleteCard(id);
	}

}
