package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import ua.entity.Item;
import ua.form.ItemForm;
import ua.form.filter.ItemFilterForm;

public interface ItemService {

	//void save(int categoryId, String name, int price);
	
	void save(Item item);
	
	void save(ItemForm form);
	
	Item findByName(String name);
	
	Item findOne(int id);
	
	void delete (String name);

	List<Item> findAll();
	
	void delete (int id);

	ItemForm findForForm(int id);
	
	public Page<Item> findAll( ItemFilterForm form, Pageable pageable);

	public List<Item> findRandom(int numbersItem);
	

//	public Page<Item> findItemByCategoryId(Pageable pageable, int id);
//	
	public Page<Item> findItemByCategoryId(ItemFilterForm form, Pageable pageable, int id);
	
}
