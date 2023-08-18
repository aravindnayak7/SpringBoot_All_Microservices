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
public class ItemServiceImpl implements IItemService {
	@Autowired
	private ItemRepository irep;
	@Override
	public Items saveItem(Items iobj) throws ItemFoundException {
		Optional<Items> save=this.irep.findById(iobj.getProductId());
		Items saveinfo=null;
		if(save.isPresent()) {
			System.out.println("Item already exists");
			throw new ItemFoundException();
			
		}else {
			saveinfo=this.irep.save(iobj);
		}
		return saveinfo;
	}

	@Override
	public Items getItemById(int productId) throws ItemNotFoundException {
		Optional<Items> getitem=this.irep.findById(productId);
		Items display=null;
		if(getitem.isPresent()) {
			display=getitem.get();
		}else {
			throw new ItemNotFoundException();
		}
		return display;
	}

	@Override
	public Items updateItemsById(Items iobj, int productId) throws ItemNotFoundException {
		Optional<Items> updateitm=this.irep.findById(productId);
		Items getinfo=null;
		Items updatedinfo=null;
		if(updateitm.isPresent()) {
			getinfo=updateitm.get();
			getinfo.setAddress(iobj.getAddress());
			getinfo.setCategory(iobj.getCategory());
			getinfo.setDate(iobj.getDate());
			getinfo.setMobilenum(iobj.getMobilenum());
			getinfo.setMobilenum(iobj.getPincode());
			getinfo.setPrice(iobj.getProductId());
			getinfo.setProductname(iobj.getProductname());
			updatedinfo = this.irep.save(getinfo);
		}else {
			throw new ItemNotFoundException();
		}
		return updatedinfo;
	}

	@Override
	public List<Items> getAllItems() {
		return this.irep.findAll();
	}

	@Override
	public boolean delItems(int productId) throws ItemNotFoundException {
		boolean status=false;
		Optional<Items> delitm=this.irep.findById(productId);
		if(delitm.isPresent()) {
			this.irep.delete(delitm.get());
		}else {
			throw new ItemNotFoundException();
		}
		return true;
	}

}
