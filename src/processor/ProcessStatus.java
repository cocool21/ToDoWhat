package processor;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Status;

public class ProcessStatus {
private int listId;
private String status="0";
public ProcessStatus(){
}
public int updateStatus(int listId) {
	this.listId=listId;
	status="1";
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	EntityTransaction trans = em.getTransaction();
	String qString = "update Status s set s.status = :status "
			+ "where s.id = :id";
	TypedQuery<Status> q = em.createQuery(qString, model.Status.class);
	q.setParameter("status", status);
	q.setParameter("id", (long)listId);
	int count = 0;

	try {
		trans.begin();
		count = q.executeUpdate();
		trans.commit();

	} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
	} finally {

		em.close();
		System.out.println("Item "+listId+" is set as done");
		return count;
	}
}
public void AddStatus(int listId){
	Status row=new Status();
	row.setId(listId);
	row.setStatus("0");
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	EntityTransaction trans = em.getTransaction();
	trans.begin();
	try {
	em.persist(row);
	trans.commit();
	} catch (Exception e) {
	System.out.println(e);
	trans.rollback();
	} finally {
	em.close();
	}
	    
}
public String GetStatus(int listId){
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select s from Status s where s.id = :id";
	TypedQuery<Status> q = em.createQuery(qString, model.Status.class);
	q.setParameter("id", listId);
	List<Status> ss = null;

	try {

		ss = q.getResultList();
		if (ss == null || ss.isEmpty())
			ss = null;

	} catch (Exception e) {
		System.out.println(e);
	} finally {

		em.close();
		System.out.println("Finished");
		Status status=ss.get(0);
		return status.getStatus();
	}
}


}
