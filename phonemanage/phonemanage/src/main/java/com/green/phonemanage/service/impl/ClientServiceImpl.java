package com.green.phonemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.green.phonemanage.dao.ClientDao;
import com.green.phonemanage.model.Client;
import com.green.phonemanage.service.IClientService;
import com.green.util.UUIDGenerator;

public class ClientServiceImpl implements IClientService {
	@Autowired
	private ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/*
	 * 锟斤拷涌突锟斤拷锟较�
	 * 
	 * @param:锟酵伙拷锟斤拷息
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.green.phonemanage.service.IClientService#add(com.green.phonemanage.
	 * model.Client)
	 */
	public void add(Client client) throws Exception {
		Integer id = null;
	//	id = clientDao.findByIdCard(client.getIdCard());
	 if( client.getId()>0) {
			client.setCode(UUIDGenerator.uuid());// 娣诲姞瀹㈡埛缂栧彿
			clientDao.update(client);
		}else{
			client.setCode(UUIDGenerator.uuid());// 娣诲姞瀹㈡埛缂栧彿
			clientDao.add(client);
		}
	}

}
