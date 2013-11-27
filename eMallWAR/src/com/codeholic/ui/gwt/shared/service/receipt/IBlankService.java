package com.codeholic.ui.gwt.shared.service.receipt;

import com.codeholic.ui.gwt.shared.dto.BlankMessage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("blank")
public interface IBlankService extends RemoteService{
	BlankMessage fetchBlankMessage(String name);
}
