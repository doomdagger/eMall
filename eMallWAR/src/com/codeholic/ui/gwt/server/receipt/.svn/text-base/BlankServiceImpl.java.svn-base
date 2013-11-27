package com.codeholic.ui.gwt.server.receipt;

import com.codeholic.ui.gwt.shared.dto.BlankMessage;
import com.codeholic.ui.gwt.shared.service.receipt.IBlankService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BlankServiceImpl extends RemoteServiceServlet implements IBlankService{

	private static final long serialVersionUID = 4560942281035357662L;

	@Override
	public BlankMessage fetchBlankMessage(String name) {
		BlankMessage message = new BlankMessage();
		message.setName(name);
		int number = (int)(Math.random()*2);
		if(number==0)
			message.setMessage("Hi, Bitch = = Fuck you, GWT");
		else
			message.setMessage("Fuck!!!!!!!!");
		return message;
	}

}
