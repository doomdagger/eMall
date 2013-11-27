package com.codeholic.ui.gwt.client.core.events;

import com.google.gwt.event.shared.GwtEvent;

public class CoreEvent extends GwtEvent<CoreHandler>{

	private static Type<CoreHandler> TYPE = new Type<CoreHandler>();
	public static com.google.gwt.event.shared.GwtEvent.Type<CoreHandler> getType() {
		return TYPE;
	}
	
	
	@Override
	protected void dispatch(CoreHandler handler) {
		handler.onCoreEvent(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<CoreHandler> getAssociatedType() {
		return TYPE;
	}
	
	
	
	protected void fire(HasCoreHandlers source) {
		source.fireEvent(new CoreEvent());
	}

}
