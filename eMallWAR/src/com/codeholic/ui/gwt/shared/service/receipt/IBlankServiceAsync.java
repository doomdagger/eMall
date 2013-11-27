package com.codeholic.ui.gwt.shared.service.receipt;

import com.codeholic.ui.gwt.shared.dto.BlankMessage;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IBlankServiceAsync {
	Request fetchBlankMessage(String name, AsyncCallback<BlankMessage> callback);
}
