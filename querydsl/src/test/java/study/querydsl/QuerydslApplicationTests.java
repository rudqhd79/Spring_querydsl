package study.querydsl;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.jpa.impl.JPAQueryFactory;

import study.querydsl.Entity.TestEntity;

@SpringBootTest
class QuerydslApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		TestEntity hello = new TestEntity();
		em.persist(hello);
		JPAQueryFactory query = new JPAQueryFactory(em);
		QTestEntity QHello = QHello.hello; // Querydsl Q타입 동작 확인
		TestEntity result = query.selectFrom(QHello).fetchOne();
		Assertions.assertThat(result).isEqualTo(hello);
		// lombok 동작 확인 (hello.getId())
		Assertions.assertThat(result.getId()).isEqualTo(hello.getId());
	}

}
