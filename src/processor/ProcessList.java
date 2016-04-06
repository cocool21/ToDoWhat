package processor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Listuser;
import model.ToDoList;


public class ProcessList {
private int userId;
private int listId;
private String item;
private Date deadline;
private List<ToDoList> list=null;
ToDoList row=new ToDoList();
public ProcessList(){
}
public int getId(){
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select l from ToDoList l";
	TypedQuery<ToDoList> q = em.createQuery(qString, model.ToDoList.class);
	try {

		list = q.getResultList();
		if (list == null || list.isEmpty())
			list = null;

	} catch (Exception e) {
		System.out.println(e);
	} finally {

		em.close();
		return list.size();
	}
}
public void AddItem(int userId,String item, Date deadline){
	this.userId=userId;
	this.item=item;
	this.deadline=deadline;
	this.listId=getId()+1;
	ProcessStatus ps=new ProcessStatus();
	BigDecimal userid=new BigDecimal(userId);
	row.setId((long)listId);
	row.setUserid(userid);
	row.setItem(item);
	row.setDeadline(deadline);
	ps.AddStatus(listId);
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

public List getList(int userId){
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select p from ToDoList p where p.userid= :userid ORDER BY p.id ASC";
	TypedQuery<ToDoList> q = em.createQuery(qString, model.ToDoList.class);
	q.setParameter("userid", userId);
	try {

		list = q.getResultList();
		if (list == null || list.isEmpty())
			list = null;

	} catch (Exception e) {
		System.out.println(e);
	} finally {

		em.close();
		return list;
	}
}

public int getUserId() {
	return userId;
}

public int getListId() {
	return listId;
}

public String getItem() {
	return item;
}

public Date getDeadline() {
	return deadline;
}

}
