package com.rest.services;

import java.util.List;

import com.rest.exception.ItemFoundException;
import com.rest.exception.ItemNotFoundException;
import com.rest.model.Items;

public interface IItemService {
	public Items saveItem(Items iobj)throws ItemFoundException;
	public Items getItemById(int productId)throws ItemNotFoundException;
	public Items updateItemsById(Items iobj,int productId)throws ItemFoundException;
	public List<Items> getAllItems();
	public boolean delItems(int productId)throws ItemNotFoundException;
}
