package com.codeholic.ui.gwt.client.core.goods.views.uibinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.codeholic.ui.gwt.client.core.goods.presenters.GoodsPresenter;
import com.codeholic.ui.gwt.client.core.goods.ui.GoodsProperties;
import com.codeholic.ui.gwt.client.core.goods.views.GoodsView;
import com.codeholic.ui.gwt.client.core.user.ui.Resources;
import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.codeholic.ui.gwt.shared.goods.dto.GoodsDto;
import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass1Dto;
import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass2Dto;
import com.codeholic.ui.gwt.shared.goods.dto.StringPair;
import com.codeholic.ui.gwt.shared.goods.dto.StringPairProperties;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsService;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Popup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent.ParseErrorHandler;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.FormPanelHelper;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.DoublePropertyEditor;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.IntegerPropertyEditor;
import com.sencha.gxt.widget.core.client.form.SpinnerField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class GoodsViewImpl extends Composite implements GoodsView {

	private static GoodsViewImplUiBinder uiBinder = GWT
			.create(GoodsViewImplUiBinder.class);

	private GoodsPresenter presenter;

	interface GoodsViewImplUiBinder extends UiBinder<Widget, GoodsViewImpl> {
	}

	@UiField
	SimplePanel parentPanel;

	public GoodsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		VerticalPanel subPanel = new VerticalPanel();
		subPanel.setWidth("100%");
		subPanel.setHeight("100%");
		subPanel.add(createForm());
		subPanel.add(createToolBar());
		subPanel.add(createGrid());
		
		popup.add(createAddPanel());
		new Draggable(popup, popup).setUseProxy(false);
		
		parentPanel.add(subPanel);
	}

	@Override
	public void setPresenter(GoodsPresenter presenter) {
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
		panel.setHeadingText("添加商品");
		panel.setWidth(350);
		panel.setBodyStyle("background: none; padding: 5px");

		VerticalLayoutContainer p = new VerticalLayoutContainer();
		panel.add(p);

		StringPairProperties pairProperties = GWT
				.create(StringPairProperties.class);
		ListStore<StringPair> brandStore = new ListStore<StringPair>(
				pairProperties.theKey());
		ListStore<StringPair> class1Store = new ListStore<StringPair>(
				pairProperties.theKey());
		ListStore<StringPair> class2Store = new ListStore<StringPair>(
				pairProperties.theKey());
		
		final TextField goodsCode = new TextField();
		final TextField goodsName = new TextField();
		final SpinnerField<Integer> goodsMode = new SpinnerField<Integer>(
				new IntegerPropertyEditor());
		final TextField goodsUnit = new TextField();
		final SpinnerField<Double> goodsPrice = new SpinnerField<Double>(
				new DoublePropertyEditor());
		final DateField goodsCreatetime = new DateField();

		final ComboBox<StringPair> brand = new ComboBox<StringPair>(brandStore, pairProperties.valueLabel());
		final ComboBox<StringPair> class1= new ComboBox<StringPair>(class1Store, pairProperties.valueLabel());
		final ComboBox<StringPair> class2= new ComboBox<StringPair>(class2Store, pairProperties.valueLabel());

		goodsCode.setReadOnly(false);
		goodsCode.setAllowBlank(false);
		p.add(new FieldLabel(goodsCode, "商品编码"));

		goodsName.setAllowBlank(false);
		p.add(new FieldLabel(goodsName, "商品名称"));

		goodsMode.setIncrement(1);
		goodsMode.setMinValue(1);
		goodsMode.setMaxValue(10000);
		goodsMode.setAllowNegative(false);
		goodsMode.setAllowBlank(false);
		goodsMode.getPropertyEditor().setFormat(NumberFormat.getFormat("0"));
		p.add(new FieldLabel(goodsMode, "商品规格"));

		goodsUnit.setAllowBlank(false);
		p.add(new FieldLabel(goodsUnit, "计价单位"));

		goodsPrice.setIncrement(5d);
		goodsPrice.setMinValue(0d);
		goodsPrice.setMaxValue(1000000000d);
		goodsPrice.setAllowNegative(false);
		goodsPrice.setAllowBlank(false);
		goodsPrice.getPropertyEditor().setFormat(NumberFormat.getFormat("0.0"));
		p.add(new FieldLabel(goodsMode, "商品价格"));

		goodsCreatetime.addParseErrorHandler(new ParseErrorHandler() {
			@Override
			public void onParseError(ParseErrorEvent event) {
				Info.display("Parse Error", event.getErrorValue()
						+ " could not be parsed as a date");
			}
		});
		goodsCreatetime.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				String v = event.getValue() == null ? "nothing"
						: DateTimeFormat
								.getFormat(PredefinedFormat.DATE_MEDIUM)
								.format(event.getValue());
				Info.display("Selected", "You selected " + v);
			}
		});
		//goodsCreatetime.addValidator(new MinDateValidator(new Date()));
		p.add(new FieldLabel(goodsCreatetime, "商品创建日期"));

		
		
		
		brand.setForceSelection(true);
		brand.setTriggerAction(TriggerAction.ALL);
		p.add(new FieldLabel(brand, "品牌"));

		class1.setForceSelection(true);
		class1.setTriggerAction(TriggerAction.ALL);
		p.add(new FieldLabel(class1, "一级分类"));

		class2.setForceSelection(true);
		class2.setTriggerAction(TriggerAction.ALL);
		p.add(new FieldLabel(class2, "二级分类"));


		TextButton addButton = new TextButton("添加");
		TextButton cancelButton = new TextButton("取消");

		addButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				GoodsDto currentGoods = new GoodsDto();
				currentGoods.setGoodsCode(goodsCode.getText());
				currentGoods.setGoodsName(goodsName.getText());
				currentGoods.setGoodsMode(goodsMode.getValue());
				currentGoods.setGoodsUnit(goodsUnit.getText());
				currentGoods.setGoodsPrice(goodsPrice.getValue());
				currentGoods.setGoodsCreatetime(goodsCreatetime.getValue());

				BrandDto brandDto = new BrandDto();
				brandDto.setBrandId(brand.getValue().getKey());
				currentGoods.setBrand(brandDto);
				
				Goodsclass1Dto class1dto = new Goodsclass1Dto();
				class1dto.setGclass1Id(class1.getValue().getKey());
				currentGoods.setClass1(class1dto);
				
				Goodsclass2Dto class2dto = new Goodsclass2Dto();
				class2dto.setGclass2Id(class2.getValue().getKey());
				currentGoods.setClass2(class2dto);
				
				presenter.onAddGoods(currentGoods);
				popup.setAutoHide(true);
				popup.hide();
				goodsCode.setText("");
				goodsName.setText("");
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

	TextField goodsCode = new TextField();
	TextField goodsName = new TextField();
	SpinnerField<Integer> goodsMode = new SpinnerField<Integer>(
			new IntegerPropertyEditor());
	TextField goodsUnit = new TextField();
	SpinnerField<Double> goodsPrice = new SpinnerField<Double>(
			new DoublePropertyEditor());
	DateField goodsCreatetime = new DateField();

	ComboBox<StringPair> brand;
	ComboBox<StringPair> class1;
	ComboBox<StringPair> class2;

	GoodsDto currentGoods = null;
	StringPairProperties pairProperties = GWT
			.create(StringPairProperties.class);
	ListStore<StringPair> brandStore = new ListStore<StringPair>(
			pairProperties.theKey());
	ListStore<StringPair> class1Store = new ListStore<StringPair>(
			pairProperties.theKey());
	ListStore<StringPair> class2Store = new ListStore<StringPair>(
			pairProperties.theKey());

	public void applyView(GoodsDto GoodsDto) {
		if (GoodsDto != null)
			currentGoods = GoodsDto;
		goodsCode.setText(currentGoods.getGoodsCode());
		goodsCreatetime.setValue(currentGoods.getGoodsCreatetime());
		goodsMode.setValue(currentGoods.getGoodsMode());
		goodsName.setText(currentGoods.getGoodsName());
		goodsPrice.setValue(currentGoods.getGoodsPrice());
		goodsUnit.setText(currentGoods.getGoodsUnit());

		BrandDto brandDto = GoodsDto.getBrand();
		Goodsclass1Dto goodsclass1Dto = GoodsDto.getClass1();
		Goodsclass2Dto goodsclass2Dto = GoodsDto.getClass2();

		StringPair brandPair = new StringPair(brandDto.getBrandId(),
				brandDto.getBrandName());
		StringPair goodsclass1Pair = new StringPair(
				goodsclass1Dto.getGclass1Id(), goodsclass1Dto.getGclass1Name());
		StringPair goodsclass2Pair = new StringPair(
				goodsclass2Dto.getGclass2Id(), goodsclass2Dto.getGclass2Name());

		brand.setValue(brandPair, true);
		class1.setValue(goodsclass1Pair, true);
		class2.setValue(goodsclass2Pair, true);

	}

	public Widget createForm() {
		FramedPanel panel = new FramedPanel();
		panel.setHeadingText("所选商品");
		panel.setWidth("100%");
		// panel.getElement().getStyle().setPadding(10, Unit.PX);

		HtmlLayoutContainer con = new HtmlLayoutContainer(getTableMarkup());
		panel.setWidget(con);

		int cw = (COLUMN_FORM_WIDTH / 5) - 12;

		goodsCode.setReadOnly(false);
		goodsCode.setAllowBlank(false);
		goodsCode.setWidth(cw);
		con.add(new FieldLabel(goodsCode, "商品编码"), new HtmlData(".code"));

		goodsName.setAllowBlank(false);
		goodsName.setWidth(cw);
		con.add(new FieldLabel(goodsName, "商品名称"), new HtmlData(".name"));

		goodsMode.setIncrement(1);
		goodsMode.setMinValue(1);
		goodsMode.setMaxValue(10000);
		goodsMode.setAllowNegative(false);
		goodsMode.setAllowBlank(false);
		goodsMode.getPropertyEditor().setFormat(NumberFormat.getFormat("0"));
		con.add(new FieldLabel(goodsMode, "商品规格"), new HtmlData(".name"));

		goodsUnit.setAllowBlank(false);
		goodsUnit.setWidth(cw);
		con.add(new FieldLabel(goodsUnit, "计价单位"), new HtmlData(".name"));

		goodsPrice.setIncrement(5d);
		goodsPrice.setMinValue(0d);
		goodsPrice.setMaxValue(1000000000d);
		goodsPrice.setAllowNegative(false);
		goodsPrice.setAllowBlank(false);
		goodsPrice.getPropertyEditor().setFormat(NumberFormat.getFormat("0.0"));
		con.add(new FieldLabel(goodsMode, "商品价格"), new HtmlData(".name"));

		goodsCreatetime.addParseErrorHandler(new ParseErrorHandler() {
			@Override
			public void onParseError(ParseErrorEvent event) {
				Info.display("Parse Error", event.getErrorValue()
						+ " could not be parsed as a date");
			}
		});
		goodsCreatetime.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				String v = event.getValue() == null ? "nothing"
						: DateTimeFormat
								.getFormat(PredefinedFormat.DATE_MEDIUM)
								.format(event.getValue());
				Info.display("Selected", "You selected " + v);
			}
		});
		//goodsCreatetime.addValidator(new MinDateValidator(new Date()));
		con.add(new FieldLabel(goodsCreatetime, "商品创建日期"), new HtmlData(".name"));

		
		
		brand = new ComboBox<StringPair>(brandStore,
				pairProperties.valueLabel());
		brand.setWidth(cw);
		brand.setForceSelection(true);
		brand.setTriggerAction(TriggerAction.ALL);
		con.add(new FieldLabel(brand, "品牌"), new HtmlData(".country"));

		class1 = new ComboBox<StringPair>(class1Store,
				pairProperties.valueLabel());
		class1.setWidth(cw);
		class1.setForceSelection(true);
		class1.setTriggerAction(TriggerAction.ALL);
		con.add(new FieldLabel(class1, "一级分类"), new HtmlData(".level"));

		class2 = new ComboBox<StringPair>(class2Store,
				pairProperties.valueLabel());
		class2.setWidth(cw);
		class2.setForceSelection(true);
		class2.setTriggerAction(TriggerAction.ALL);
		con.add(new FieldLabel(class2, "二级分类"), new HtmlData(".pop"));

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
				if (currentGoods == null
						|| currentGoods.getGoodsId().equals(""))
					return;
				currentGoods.setGoodsCode(goodsCode.getText());
				currentGoods.setGoodsName(goodsName.getText());
				currentGoods.setGoodsMode(goodsMode.getValue());
				currentGoods.setGoodsUnit(goodsUnit.getText());
				currentGoods.setGoodsPrice(goodsPrice.getValue());
				currentGoods.setGoodsCreatetime(goodsCreatetime.getValue());

				BrandDto brandDto = new BrandDto();
				brandDto.setBrandId(brand.getValue().getKey());
				currentGoods.setBrand(brandDto);
				
				Goodsclass1Dto class1dto = new Goodsclass1Dto();
				class1dto.setGclass1Id(class1.getValue().getKey());
				currentGoods.setClass1(class1dto);
				
				Goodsclass2Dto class2dto = new Goodsclass2Dto();
				class2dto.setGclass2Id(class2.getValue().getKey());
				currentGoods.setClass2(class2dto);
				
				presenter.onSaveGoods(currentGoods);
			}
		});

		deleteButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				if (currentGoods.getGoodsId().equals(""))
					return;
				presenter.onDeleteGoods(currentGoods.getGoodsId());
				currentGoods = null;
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
	GoodsProperties props = GWT.create(GoodsProperties.class);
	ListStore<GoodsDto> gridStore = new ListStore<GoodsDto>(props.key());
	Grid<GoodsDto> grid;

	public Widget createGrid() {
		final IGWTGoodsServiceAsync service = GWT
				.create(IGWTGoodsService.class);

		RpcProxy<PagingLoadConfig, PagingLoadResult<GoodsDto>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<GoodsDto>>() {
			@Override
			public void load(PagingLoadConfig loadConfig,
					AsyncCallback<PagingLoadResult<GoodsDto>> callback) {
				service.getGoods(loadConfig, callback);
			}
		};

		final PagingLoader<PagingLoadConfig, PagingLoadResult<GoodsDto>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<GoodsDto>>(
				proxy);
		loader.setRemoteSort(true);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, GoodsDto, PagingLoadResult<GoodsDto>>(
				gridStore));

		final PagingToolBar toolBar = new PagingToolBar(50);
		toolBar.getElement().getStyle().setProperty("borderBottom", "none");
		toolBar.bind(loader);

		IdentityValueProvider<GoodsDto> identity = new IdentityValueProvider<GoodsDto>();
		final CheckBoxSelectionModel<GoodsDto> sm = new CheckBoxSelectionModel<GoodsDto>(
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

		
		ColumnConfig<GoodsDto, String> brandIdColumnConfig = new ColumnConfig<GoodsDto, String>(
				props.brandId(), 160, "品牌编码");
		ColumnConfig<GoodsDto, String> class1IdColumnConfig = new ColumnConfig<GoodsDto, String>(
				props.class1Id(), 160, "一级分类编码");
		ColumnConfig<GoodsDto, String> class2IdColumnConfig = new ColumnConfig<GoodsDto, String>(
				props.class2Id(), 160, "二级分类编码");
		ColumnConfig<GoodsDto, String> goodsCodeColumnConfig = new ColumnConfig<GoodsDto, String>(
				props.goodsCode(), 150, "商品编码");
		ColumnConfig<GoodsDto, Date> goodsCreatetimeColumnConfig = new ColumnConfig<GoodsDto, Date>(
				props.goodsCreatetime(), 160, "商品创建时间");
		ColumnConfig<GoodsDto, Integer> goodsModeColumnConfig = new ColumnConfig<GoodsDto, Integer>(
				props.goodsMode(), 160, "商品规格");
		ColumnConfig<GoodsDto, String> goodsNameColumnConfig = new ColumnConfig<GoodsDto, String>(
				props.goodsName(), 150, "商品名称");
		ColumnConfig<GoodsDto, Double> goodsPriceColumnConfig = new ColumnConfig<GoodsDto, Double>(
				props.goodsPrice(), 150, "商品价格");
		ColumnConfig<GoodsDto, String> goodsUnitColumnConfig = new ColumnConfig<GoodsDto, String>(
				props.goodsUnit(), 150, "商品计价单位");
		ColumnConfig<GoodsDto, Byte> goodsValidColumnConfig = new ColumnConfig<GoodsDto, Byte>(
				props.goodsValid(), 150, "商品合格");

		List<ColumnConfig<GoodsDto, ?>> l = new ArrayList<ColumnConfig<GoodsDto, ?>>();
		l.add(sm.getColumn());
		l.add(brandIdColumnConfig);
		l.add(class1IdColumnConfig);
		l.add(class2IdColumnConfig);
		l.add(goodsCodeColumnConfig);
		l.add(goodsCreatetimeColumnConfig);
		l.add(goodsModeColumnConfig);
		l.add(goodsNameColumnConfig);
		l.add(goodsPriceColumnConfig);
		l.add(goodsUnitColumnConfig);
		l.add(goodsValidColumnConfig);

		ColumnModel<GoodsDto> cm = new ColumnModel<GoodsDto>(l);

		grid = new Grid<GoodsDto>(gridStore, cm) {
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
		cp.setHeadingText("商品列表");
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
				GoodsDto GoodsDto = gridStore.get(i);
				Info.display("所选商品", GoodsDto.getGoodsName());
				applyView(GoodsDto);
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

	@Override
	public void fillBrandCombo(ArrayList<BrandDto> brandDtos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillClass1Combo(ArrayList<Goodsclass1Dto> goodsclass1Dtos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillClass2Combo(ArrayList<Goodsclass2Dto> goodsclass2Dtos) {
		// TODO Auto-generated method stub
		
	}

}
