package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void findByTitletest() {
		Category categorytest1 = categoryRepository.findByName("Romance");
		assertThat(categorytest1).isNotNull();
	}
	
	@Test
	public void createCategorytest() {
		Category categorytest2 = new Category("Action");
		categoryRepository.save(categorytest2);
		assertThat(categorytest2.getId()).isNotNull();
	}
	@Test
	@Transactional
	public void deleteCategorytest() {
		long deletedcategory = categoryRepository.deleteByName("Romance");
		assertThat(deletedcategory).isEqualTo(1);
	}

}
