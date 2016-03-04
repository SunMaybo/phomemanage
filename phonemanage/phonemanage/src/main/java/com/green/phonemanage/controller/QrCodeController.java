package com.green.phonemanage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.phonemanage.dao.CellPhoneDao;

@Controller
public class QrCodeController {
	@Autowired
	private CellPhoneDao cellPhoneDao;
	public void setCellPhoneDao(CellPhoneDao cellPhoneDao) {
		this.cellPhoneDao = cellPhoneDao;
	}
	@RequestMapping(value = "/cellphone/qr", method = RequestMethod.GET)
public void qrCode(@RequestParam int id,HttpServletResponse response) throws IOException, SQLException{
	      // Blob blob = cellPhoneDao.findQr(id);
	       byte[] data;
	      // data= cellPhoneDao.findQr(id);
	       data=cellPhoneDao.findQr(id).getQrCode();
	        response.setContentType("image/png");
	        OutputStream stream;
			try {
				stream = response.getOutputStream();
				 stream.write(data);
			        stream.flush();
			        stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	}

}
