/*package com.kgfsl.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class Session_ShareService {
	
@Autowired
	private Session_ShareDaoImpl dao;

public void setSession_Share_Dao(Session_ShareDaoImpl dao){
	this.dao = dao;
}

@Transactional
public String create(Session_share_Model ss){
	return this.dao.create(ss);
}
@Transactional
public List fetchall(){
	return this.dao.fetchAll();
	
}

public String session() {

	return this.dao.session();
}

}
*/