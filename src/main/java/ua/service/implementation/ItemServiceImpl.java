package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;
import ua.form.ItemForm;
import ua.repository.ItemRepository;
import ua.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public void save(Item item) {
		//Item item = new Item();
	//	Category category =  categoryRepository.findOne(item.getCategory().getId());
		//item.setCategory(category);
//		item.setName(name);
//		item.setPrice(price);
		itemRepository.save(item);
		
//		Category category = new Category();
//		category.setName(nameCategory);
//		categoryRepository.save(category);
//		item.setCategory(category);
//		item.setName(name);
//		item.setPrice(price);
//		itemRepository.save(item);
//		System.out.println(name);
//		System.out.println(nameCategory);
//		//dorobutu z categorijamu
	}

	@Override
	public Item findByName(String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public Item findOne(int id) {
		return itemRepository.findOne(id);
	}
	
	@Override
	public void delete(String name) {
		itemRepository.delete(name);
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public void delete(int id) {
		itemRepository.delete(id);
	}

	@Override
	public void save(ItemForm form) {
			Item item = new Item();
			item.setCategory(form.getCategory());
			item.setName(form.getName());
			item.setPrice(Integer.parseInt(form.getPrice()));
			item.setId(form.getId());
			itemRepository.save(item);
	}
	
	@Override
	public ItemForm findForForm(int id) {
		Item item = itemRepository.findOneCategoryInited(id);
		ItemForm form = new ItemForm();
		form.setId(item.getId());
		form.setCategory(item.getCategory());
		form.setPrice(String.valueOf(item.getPrice()));
		form.setName(item.getName());
		return form;
	}
	
}

