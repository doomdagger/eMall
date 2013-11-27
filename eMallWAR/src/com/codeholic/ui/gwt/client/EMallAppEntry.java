package com.codeholic.ui.gwt.client;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserService;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EMallAppEntry implements EntryPoint, EMallAppPresenter {

	// private GWTStoreInfoServiceAsync storeInfoServiceAsync =
	// GWT.create(GWTStoreInfoService.class);

	@Override
	public void onModuleLoad() {
		/*
		 * final TextField field = new TextField();
		 * 
		 * ToolTipConfig config = new ToolTipConfig(); config.setHideDelay(100);
		 * config.setBodyHtml("<strong>Enter your name here</strong>");
		 * field.setToolTipConfig(config);
		 * 
		 * field.setEmptyText("Enter your name Here");
		 * 
		 * 
		 * TextButton button = new TextButton("Hit Me");
		 * button.addSelectHandler(new SelectHandler() {
		 * 
		 * @Override public void onSelect(SelectEvent event) {
		 * sendMsgToServer(); }
		 * 
		 * private void sendMsgToServer(){ final String text =
		 * field.getCurrentValue(); if(text==null||text.equals("")){
		 * Info.display("Warn", "Why not give me your name?"); }else{
		 * 
		 * StoreInfoDto storeInfoDto = new StoreInfoDto();
		 * storeInfoDto.setStoreName(text);
		 * storeInfoDto.setStoreCode("2013092902");
		 * storeInfoDto.setStoreCountry(2); storeInfoDto.setStorePrvi(1);
		 * storeInfoDto.setStoreRegion(2);
		 * 
		 * storeInfoServiceAsync.addStore(storeInfoDto, new
		 * AsyncCallback<Boolean>() {
		 * 
		 * @Override public void onSuccess(Boolean result) { MessageBox box;
		 * if(result){ box = new
		 * MessageBox("Success","<strong>Store Name: "+text+"</strong>"); }else
		 * { box = new
		 * MessageBox("Fail","<strong>Cannot Create Store</strong>"); }
		 * box.show(); }
		 * 
		 * @Override public void onFailure(Throwable arg0) {
		 * Info.display("Fail", "There must be something wrong!"); } }); } }
		 * 
		 * }); ContentPanel panel = new FramedPanel();
		 * panel.setHeadingText("Welcome come to the Test Sample");
		 * //panel.setPixelSize(200, 100);
		 * panel.getElement().getStyle().setMargin(10, Unit.PX);
		 * panel.setCollapsible(true); panel.setBounds(200, 200, 250, 100);
		 * panel.setBodyBorder(true);
		 * 
		 * 
		 * final Resizable resizable = new Resizable(panel, Dir.S,Dir.E,Dir.SE);
		 * resizable.setMaxHeight(400); resizable.setMaxWidth(250);
		 * resizable.setMinHeight(60); resizable.setMinWidth(150);
		 * 
		 * panel.addCollapseHandler(new CollapseHandler() {
		 * 
		 * @Override public void onCollapse(CollapseEvent event) {
		 * resizable.setEnabled(false); } });
		 * 
		 * panel.addExpandHandler(new ExpandHandler() {
		 * 
		 * @Override public void onExpand(ExpandEvent event) {
		 * resizable.setEnabled(true); } });
		 * 
		 * new Draggable(panel,panel.getHeader()).setUseProxy(true);
		 * 
		 * 
		 * VerticalLayoutContainer layoutContainer = new
		 * VerticalLayoutContainer();
		 * 
		 * field.setLayoutData(new VerticalLayoutData(1,1));
		 * layoutContainer.add(field);
		 * 
		 * button.setLayoutData(new VerticalLayoutData(1, -1));
		 * layoutContainer.add(button);
		 * 
		 * panel.add(layoutContainer);
		 * 
		 * 
		 * RootPanel.get().add(panel);
		 */
		// LMenuViewImpl menu = new LMenuViewImpl();
		// DockLayoutPanel panel = new DockLayoutPanel(Unit.PX);
		// CoreBlankPanel blankPanel = new CoreBlankPanel();
		// panel.addWest(menu, 230);
		// panel.add(blankPanel);
		// RootLayoutPanel rPanel = RootLayoutPanel.get();
		// rPanel.add(new EMallAppLoginPanel());

		eMallAppLoginPanel = new EMallAppLoginPanel();
		eMallAppLoginPanel.setPresenter(this);

		rootLayoutPanel.add(eMallAppLoginPanel);
	}

	private IGWTUserServiceAsync serviceAsync = GWT
			.create(IGWTUserService.class);
	private RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
	private EMallAppLoginPanel eMallAppLoginPanel;

	@Override
	public void onLogin() {
		User user = eMallAppLoginPanel.getUser();

		// serviceAsync.login(user, new AsyncCallback<Boolean>(){
		//
		// @Override
		// public void onFailure(Throwable arg0) {
		// Info.display("失败", "用户名或密码错误，请重试");
		// }
		//
		// @Override
		// public void onSuccess(Boolean value) {
		// if(value){
		// rootLayoutPanel.remove(0);
		// rootLayoutPanel.add(new EMallAppPanel());
		// }else{
		// Info.display("失败", "用户名或密码错误，请重试");
		// }
		//
		// }
		//
		// });

		rootLayoutPanel.remove(0);
		rootLayoutPanel.add(new EMallAppPanel());

	}
}
