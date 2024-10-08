package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;
import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Book book = new Book();
            book.setAuthor("김영한");
            book.setName("JPA");

            em.persist(book);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
