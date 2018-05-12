package com.darrenforsythe.jpa.unidirectional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.darrenforsythe.jpa.unidirectional.repository.ParentEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class PersistenceServiceTest {

	@Autowired
	private PersistenceService persistenceService;

	@Test
	public void testRelationship() {
		Parent parent = new Parent();
		parent.setTitle("One");
		parent.setContent("I am one");
		parent.setChildren(Arrays.asList(createChild(1), createChild(2)));
		ParentEntity entity = persistenceService.save(parent);
		assertThat(entity.getChildren()).hasSize(2);
		assertThat(persistenceService.getChildrenByParentId(entity.getChildren().get(0).getId())).hasSize(2);

		parent = new Parent();
		parent.setTitle("Two");
		parent.setContent("I am Two");
		parent.setChildren(Arrays.asList(createChild(1), createChild(2), createChild(3)));
		entity = persistenceService.save(parent);
		assertThat(entity.getChildren()).hasSize(3);
		assertThat(persistenceService.getChildrenByParentId(entity.getChildren().get(0).getId())).hasSize(3);
	}

	private Child createChild(int page) {
		Child child = new Child();
		child.setPage(page);

		return child;
	}

}
