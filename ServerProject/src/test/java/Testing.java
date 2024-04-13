import org.junit.jupiter.api.Test;

import com.donchung.server.utils.AppUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Testing {
	@Test
	public void test() {
		EntityManager em = Persistence.createEntityManagerFactory(AppUtils.PERSISTENCE_UNIT_NAME).createEntityManager();
		em.getTransaction().begin();
		System.out.println("Test");
		em.getTransaction().commit();
	}

}
