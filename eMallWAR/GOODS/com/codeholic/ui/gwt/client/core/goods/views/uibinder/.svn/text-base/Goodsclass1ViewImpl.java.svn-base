package com.codeholic.ui.gwt.client.core.goods.views.uibinder;

import java.util.ArrayList;
import java.util.List;

import com.codeholic.ui.gwt.client.core.goods.presenters.Goodsclass1Presenter;
import com.codeholic.ui.gwt.client.core.goods.ui.BrandProperties;
import com.codeholic.ui.gwt.client.core.goods.views.Goodsclass1View;
import com.codeholic.ui.gwt.client.core.user.ui.PairProperties;
import com.codeholic.ui.gwt.client.core.user.ui.Resources;
import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTBrandService;
import com.codeholic.ui.gwt.shared.goods.service.IGWTBrandServiceAsync;
import com.codeholic.ui.gwt.shared.user.dto.Pair;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Popup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanelHelper;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class Goodsclass1ViewImpl extends Composite implements Goodsclass1View{

	private static Goodsclass1ViewImplUiBinder uiBinder = GWT
			.create(Goodsclass1ViewImplUiBinder.class);

	private Goodsclass1Presenter presenter;
	
	interface Goodsclass1ViewImplUiBinder extends
			UiBinder<Widget, Goodsclass1ViewImpl> {
	}
	@UiField
	SimplePanel parentPanel;

	public Goodsclass1ViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Goodsclass1Presenter presenter) {
		this.presenter = presenter;
	}

	
	/*
	 * create tool bar 创建一个tool bar
	 */
	public Widget createToolBar() {
		ToolBar toolBar = new ToolBar();

		TextButton singleAddButton = new TextButton("添加品牌");
		singleAddButton.setIcon(Resources.IMAGES.add());

		TextButton batchAddButton = new TextButton("批量添加品牌");
		batchAddButton.setIcon(Resources.IMAGES.folder());

		
		singleAddButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				popup.setAutoHide(false);
				popup.show();
			}
		});
		
		toolBar.add(singleAddButton);
		toolBar.add(batchAddButton);

		toolBar.setLayoutData(new VerticalLayoutData(1, -1));

		return toolBar;
	}

	/*
	 * 创建Add Brand
	 */
	Popup popup = new Popup();

	public Widget createAddPanel() {
		FramedPanel panel = new FramedPanel();
		panel.setHeadingText("添加品牌");
		panel.setWidth(350);
		panel.setBodyStyle("background: none; padding: 5px");

		VerticalLayoutContainer p = new VerticalLayoutContainer();
		panel.add(p);

		ListStore<Pair> countryStore = new ListStore<Pair>(pairProperties.theKey());
		ListStore<Pair> levelStore = new ListStore<Pair>(pairProperties.theKey());
		ListStore<Pair> popStore = new ListStore<Pair>(pairProperties.theKey());

		PairProperties pairProperties = GWT.create(PairProperties.class);
		Pair pair1 = new Pair(0, "中国");
		Pair pair2 = new Pair(1, "日本");
		Pair pair3 = new Pair(2, "美国");
		countryStore.add(pair1);
		countryStore.add(pair2);
		countryStore.add(pair3);

		pair1 = new Pair(0, "特级");
		pair2 = new Pair(1, "一级");
		pair3 = new Pair(2, "二级");
		levelStore.add(pair1);
		levelStore.add(pair2);
		levelStore.add(pair3);

		pair1 = new Pair(0, "流行");
		pair2 = new Pair(1, "普通");
		pair3 = new Pair(2, "罕见");
		popStore.add(pair1);
		popStore.add(pair2);
		popStore.add(pair3);
		
		final TextField brandCode = new TextField();
		final TextField brandName = new TextField();
		final ComboBox<Pair> brandCountry = new ComboBox<Pair>(countryStore, pairProperties.valueLabel());
		final ComboBox<Pair> brandLevel = new ComboBox<Pair>(levelStore, pairProperties.valueLabel());
		final ComboBox<Pair> brandPop = new ComboBox<Pair>(popStore, pairProperties.valueLabel());
		final TextArea brandDesc = new TextArea();
		final TextArea brandCmment = new TextArea();

		brandCountry.setTriggerAction(TriggerAction.ALL);
		brandCountry.setForceSelection(true);
		brandLevel.setTriggerAction(TriggerAction.ALL);
		brandLevel.setForceSelection(true);
		brandPop.setTriggerAction(TriggerAction.ALL);
		brandPop.setForceSelection(true);
		
		p.add(new FieldLabel(brandCode, "品牌编码"), new VerticalLayoutData(1,
				-1));
		p.add(new FieldLabel(brandName, "品牌名称"), new VerticalLayoutData(1,
				-1));
		p.add(new FieldLabel(brandCountry, "所在国家"), new VerticalLayoutData(1,
				-1));
		p.add(new FieldLabel(brandLevel, "品牌等级"), new VerticalLayoutData(1,
				-1));
		p.add(new FieldLabel(brandPop, "品牌流行指数"), new VerticalLayoutData(1,
				-1));
		p.add(new FieldLabel(brandDesc, "品牌描述"), new VerticalLayoutData(1,
				-1));
		p.add(new FieldLabel(brandCmment, "品牌评论"), new VerticalLayoutData(1,
				-1));
		
		
		TextButton addButton = new TextButton("添加");
		TextButton cancelButton = new TextButton("取消");

		addButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				BrandDto brandDto = new BrandDto();
				brandDto.setBrandCmment(brandCmment.getText());
				brandDto.setBrandCode(brandCode.getText());
				brandDto.setBrandCountry(brandCountry.getValue().getKey());
				brandDto.setBrandDesc(brandDesc.getText());
				brandDto.setBrandLevel(brandLevel.getValue().getKey());
				brandDto.setBrandName(brandName.getText());
				brandDto.setBrandPop(brandPop.getValue().getKey());
				//presenter.onAddBrand(brandDto);
				popup.setAutoHide(true);
				popup.hide();
				brandCode.setText("");
				brandName.setText("");
			}
		});

		cancelButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				popup.setAutoHide(true);
				popup.hide();

			}
		});

		panel.addButton(addButton);
		panel.addButton(cancelButton);

		return panel;
	}

	/*
	 * 创建Form Panel
	 */

	private static final int COLUMN_FORM_WIDTH = 900;

	TextField brandCode = new TextField();
	TextField brandName = new TextField();
	ComboBox<Pair> brandCountry;
	ComboBox<Pair> brandLevel;
	ComboBox<Pair> brandPop;
	TextArea brandDesc = new TextArea();
	TextArea brandCmment = new TextArea();

	BrandDto currentBrand = null;
	PairProperties pairProperties = GWT.create(PairProperties.class);
	ListStore<Pair> countryStore = new ListStore<Pair>(pairProperties.theKey());
	ListStore<Pair> levelStore = new ListStore<Pair>(pairProperties.theKey());
	ListStore<Pair> popStore = new ListStore<Pair>(pairProperties.theKey());

	public void applyView(BrandDto brandDto) {
		if (brandDto != null)
			currentBrand = brandDto;
		brandCode.setText(currentBrand.getBrandCode());
		brandName.setText(currentBrand.getBrandName());
		brandDesc.setText(currentBrand.getBrandDesc());
		brandCmment.setText(currentBrand.getBrandCmment());

		int country = brandDto.getBrandCountry();
		int level = brandDto.getBrandLevel();
		int pop = brandDto.getBrandPop();
		brandCountry.setValue(countryStore.get(country), true);
		brandLevel.setValue(levelStore.get(level), true);
		brandPop.setValue(popStore.get(pop), true);

	}

	public Widget createForm() {
		FramedPanel panel = new FramedPanel();
		panel.setHeadingText("所选品牌");
		panel.setWidth("100%");
		// panel.getElement().getStyle().setPadding(10, Unit.PX);

		HtmlLayoutContainer con = new HtmlLayoutContainer(getTableMarkup());
		panel.setWidget(con);

		int cw = (COLUMN_FORM_WIDTH / 5) - 12;

		brandCode.setReadOnly(false);
		brandCode.setAllowBlank(false);
		brandCode.setWidth(cw);
		con.add(new FieldLabel(brandCode, "品牌编码"), new HtmlData(".code"));

		brandName.setAllowBlank(false);
		brandName.setWidth(cw);
		con.add(new FieldLabel(brandName, "品牌名称"), new HtmlData(".name"));

		Pair pair1 = new Pair(0, "中国");
		Pair pair2 = new Pair(1, "日本");
		Pair pair3 = new Pair(2, "美国");
		countryStore.add(pair1);
		countryStore.add(pair2);
		countryStore.add(pair3);

		pair1 = new Pair(0, "特级");
		pair2 = new Pair(1, "一级");
		pair3 = new Pair(2, "二级");
		levelStore.add(pair1);
		levelStore.add(pair2);
		levelStore.add(pair3);

		pair1 = new Pair(0, "流行");
		pair2 = new Pair(1, "普通");
		pair3 = new Pair(2, "罕见");
		popStore.add(pair1);
		popStore.add(pair2);
		popStore.add(pair3);

		brandCountry = new ComboBox<Pair>(countryStore,
				pairProperties.valueLabel());
		brandCountry.setWidth(cw);
		brandCountry.setForceSelection(true);
		brandCountry.setTriggerAction(TriggerAction.ALL);
		con.add(new FieldLabel(brandCountry, "所属国家"), new HtmlData(".country"));

		brandLevel = new ComboBox<Pair>(levelStore, pairProperties.valueLabel());
		brandLevel.setWidth(cw);
		brandLevel.setForceSelection(true);
		brandLevel.setTriggerAction(TriggerAction.ALL);
		con.add(new FieldLabel(brandLevel, "品牌等级"), new HtmlData(".level"));

		brandPop = new ComboBox<Pair>(popStore, pairProperties.valueLabel());
		brandPop.setWidth(cw);
		brandPop.setForceSelection(true);
		brandPop.setTriggerAction(TriggerAction.ALL);
		con.add(new FieldLabel(brandPop, "品牌流行指数"), new HtmlData(".pop"));

		brandDesc.setAllowBlank(false);
		brandDesc.setWidth((int) (cw * 2.5));
		brandDesc.setHeight(100);
		brandDesc.addValidator(new MinLengthValidator(10));
		con.add(new FieldLabel(brandDesc, "品牌描述"), new HtmlData(".desc"));

		brandCmment.setAllowBlank(false);
		brandCmment.setWidth((int) (cw * 2.5));
		brandCmment.setHeight(100);
		brandCmment.addValidator(new MinLengthValidator(10));
		con.add(new FieldLabel(brandCmment, "品牌评价"), new HtmlData(".comment"));

		TextButton resetButton = new TextButton("Reset");
		TextButton saveButton = new TextButton("Save");
		TextButton deleteButton = new TextButton("Delete");

		resetButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				applyView(null);
			}
		});

		saveButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				if (currentBrand == null
						|| currentBrand.getBrandId().equals(""))
					return;
				currentBrand.setBrandCmment(brandCmment.getText());
				currentBrand.setBrandCode(brandCode.getText());
				currentBrand.setBrandCountry(brandCountry.getValue().getKey());
				currentBrand.setBrandDesc(brandDesc.getText());
				currentBrand.setBrandLevel(brandLevel.getValue().getKey());
				currentBrand.setBrandName(brandName.getText());
				currentBrand.setBrandPop(brandPop.getValue().getKey());
				//presenter.onSaveBrand(currentBrand);
			}
		});

		deleteButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				if (currentBrand.getBrandId().equals(""))
					return;
				//presenter.onDeleteBrand(currentBrand.getBrandId());
				currentBrand = null;
			}
		});

		panel.addButton(resetButton);
		panel.addButton(saveButton);
		panel.addButton(deleteButton);

		// need to call after everything is constructed
		List<FieldLabel> labels = FormPanelHelper.getFieldLabels(panel);
		for (FieldLabel lbl : labels) {
			lbl.setLabelAlign(LabelAlign.TOP);
		}

		return panel;
	}

	private native String getTableMarkup() /*-{
		return [
				'<table width=100% cellpadding=0 cellspacing=5>',
				'<tr><td class=code width=20%></td><td class=name width=20%></td><td class=country width=20%></td><td class=level width=20%></td><td class=pop width=20%></td></tr>',
				'<tr><td class=desc colspan=2></td><td class=comment colspan=3></td></tr>',
				'</table>'

		].join("");
	}-*/;

	/*
	 * 创建Grid表格
	 */
	BrandProperties props = GWT.create(BrandProperties.class);
	ListStore<BrandDto> gridStore = new ListStore<BrandDto>(props.key());
	Grid<BrandDto> grid;

	public Widget createGrid() {
		final IGWTBrandServiceAsync service = GWT
				.create(IGWTBrandService.class);

		RpcProxy<PagingLoadConfig, PagingLoadResult<BrandDto>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<BrandDto>>() {
			@Override
			public void load(PagingLoadConfig loadConfig,
					AsyncCallback<PagingLoadResult<BrandDto>> callback) {
				service.getBrands(loadConfig, callback);
			}
		};

		final PagingLoader<PagingLoadConfig, PagingLoadResult<BrandDto>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<BrandDto>>(
				proxy);
		loader.setRemoteSort(true);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, BrandDto, PagingLoadResult<BrandDto>>(
				gridStore));

		final PagingToolBar toolBar = new PagingToolBar(50);
		toolBar.getElement().getStyle().setProperty("borderBottom", "none");
		toolBar.bind(loader);

		IdentityValueProvider<BrandDto> identity = new IdentityValueProvider<BrandDto>();
		final CheckBoxSelectionModel<BrandDto> sm = new CheckBoxSelectionModel<BrandDto>(
				identity) {
			@Override
			protected void onRefresh(RefreshEvent event) {
				// this code selects all rows when paging if the header checkbox
				// is selected
				if (isSelectAllChecked()) {
					selectAll();
				}
				super.onRefresh(event);
			}
		};

		ColumnConfig<BrandDto, String> codeColumnConfig = new ColumnConfig<BrandDto, String>(
				props.brandCode(), 160, "品牌编码");
		ColumnConfig<BrandDto, String> nameColumnConfig = new ColumnConfig<BrandDto, String>(
				props.brandName(), 150, "品牌名称");
		ColumnConfig<BrandDto, Integer> countrycColumnConfig = new ColumnConfig<BrandDto, Integer>(
				props.brandCountry(), 150, "所在国家");
		ColumnConfig<BrandDto, Integer> leveColumnConfig = new ColumnConfig<BrandDto, Integer>(
				props.brandLevel(), 150, "品牌等级");
		ColumnConfig<BrandDto, Integer> popColumnConfig = new ColumnConfig<BrandDto, Integer>(
				props.brandPop(), 150, "品牌流行指数");

		List<ColumnConfig<BrandDto, ?>> l = new ArrayList<ColumnConfig<BrandDto, ?>>();
		l.add(sm.getColumn());
		l.add(codeColumnConfig);
		l.add(nameColumnConfig);
		l.add(countrycColumnConfig);
		l.add(leveColumnConfig);
		l.add(popColumnConfig);

		ColumnModel<BrandDto> cm = new ColumnModel<BrandDto>(l);

		grid = new Grid<BrandDto>(gridStore, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						loader.load();
					}
				});
			}
		};
		grid.setWidth("100%");
		grid.setSelectionModel(sm);

		grid.getView().setForceFit(true);
		grid.setLoadMask(true);
		grid.setLoader(loader);

		FramedPanel cp = new FramedPanel();
		cp.setCollapsible(true);
		cp.setHeadingText("品牌列表");
		cp.setWidth("100%");
		cp.setHeight(500);
		cp.addStyleName("margin-10");

		VerticalLayoutContainer con = new VerticalLayoutContainer();
		con.setBorders(true);
		con.add(grid, new VerticalLayoutData(1, 1));
		con.add(toolBar, new VerticalLayoutData(1, -1));
		cp.setWidget(con);

		grid.addRowClickHandler(getGridRowClickHandler());
		return cp;
	}

	public RowClickHandler getGridRowClickHandler() {
		return new RowClickHandler() {

			@Override
			public void onRowClick(RowClickEvent event) {
				int i = event.getRowIndex();
				BrandDto brandDto = gridStore.get(i);
				Info.display("所选品牌", brandDto.getBrandName());
				applyView(brandDto);
			}
		};
	}

	
	
	@Override
	public void reloadGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearForm() {
		// TODO Auto-generated method stub
		
	}

}
