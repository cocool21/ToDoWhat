package processor;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Listuser;


public class ProcessUser {
private int userId;
private String userName;
private String userPassword;
public ProcessUser(){
}
public int UserLogin(String name,String password){
	userName=name;
	userPassword=password;
	EntityManager em=DBUtil.getEmFactory().createEntityManager();
	String qString="SELECT l FROM Listuser l  where l.username = :username AND l.userpassword = :userpassword";
	TypedQuery<Listuser> q=em.createQuery(qString, Listuser.class);
	q.setParameter("username", userName);
	q.setParameter("userpassword", userPassword);
	List<Listuser> users;
	Listuser user;
	long count;
	try{
		users=q.getResultList();
		if(users==null||users.isEmpty()){
			user=null;
			userId=0;
			}else{
			user=users.get(0);
			count=user.getId();
			userId=(int)count;
			}
		}finally{
			em.close();
		} 
	    
		return userId;
}
public String getUserName() {
	return userName;
}
public String getUserPassword() {
	return userPassword;
}

}
