package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Deck;
import com.revature.overcharge.dto.DeckTagsDTO;
import com.revature.overcharge.exception.AlreadyApprovedException;
import com.revature.overcharge.exception.BadParameterException;

public interface DeckService {

    public Deck addDeck(Deck d);

    public Deck getDeck(int id);

    public Deck updateDeck(Deck newDeck);

    public boolean deleteDeck(int id);

    public List<Deck> getDecksByCreatorId(int creatorId);
    
    public List<Deck> getDecksByTagId(int tagId);

    public List<Deck> getAllDecks();
    
    public List<Deck> sortDeckDescending(List<Deck> decks);

    public Deck addDeckAndCards(Deck d);

    public Deck updateDeckAndCards(Deck newDeck);

	public Deck deckApproval(int id, int status) throws BadParameterException, AlreadyApprovedException;

	public Deck setDeckTags(int id, DeckTagsDTO deckTagsDTO);

}