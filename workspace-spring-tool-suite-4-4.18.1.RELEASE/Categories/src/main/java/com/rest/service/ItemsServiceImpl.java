package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.ItemFoundException;
import com.rest.exception.ItemNotFoundException;
import com.rest.model.Items;
import com.rest.repository.ItemRepository;
@Service
public class ItemsServiceImpl implements IItemService {
@Autowired
private ItemRepository irepo;
	@Override
	public Items saveItem(Items iobj) throws ItemFoundException {
		Optional<Items> saveitem=this.irepo.findById(iobj.getProductId());
		Items additem=null;
		if(saveitem.isPresent()) {
			throw new ItemFoundException();
		}else {
			additem=this.irepo.save(iobj);
		}
		return additem;
	}

	@Override
	public Items getItemById(int productId) throws ItemNotFoundException {
		Optional<Items> getitem=this.irepo.findById(productId);
		Items display=null;
		if(getitem.isPresent()) {
			display=getitem.get();
		}else {
			throw new ItemNotFoundException();
		}
		return display;
	}

	@Override
	public Items updateItemById(Items iobj, int productId) throws ItemFoundException {
		Optional<Items> upitems=this.irepo.findById(productId);
		Items additem=null;
		Items updatedata=null;
		if(upitems.isPresent()) {
			additem=upitems.get();
			additem.setCategory(iobj.getCategory());
			additem.setPrice(iobj.getPrice());
			additem.setProductname(iobj.getProductname());
			additem.setImageurl(iobj.getImageurl());
			updatedata=this.irepo.save(additem);
		}else {
			throw new ItemFoundException();
		}
		return updatedata;
	}

	@Override
	public List<Items> getAllItems() {
		return this.irepo.findAll();
	}

	@Override
	public boolean delItems(int productId) throws ItemNotFoundException {
		Optional<Items> del=this.irepo.findById(productId);
		boolean status=false;
		if(del.isPresent()) {
			this.irepo.delete(del.get());
		}else {
			throw new ItemNotFoundException();
		}
		return true;
	}

	@Override
	public List<Items> validateByCategory(String category) throws ItemNotFoundException {
		List<Items> cat=this.irepo.findByCategory(category);
		if(cat.isEmpty()) {
			throw new ItemNotFoundException();
		}
		return cat;
	}

}
