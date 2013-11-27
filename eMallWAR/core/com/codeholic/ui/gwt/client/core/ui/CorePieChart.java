package com.codeholic.ui.gwt.client.core.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.Legend;
import com.sencha.gxt.chart.client.chart.series.PieSeries;
import com.sencha.gxt.chart.client.chart.series.Series.LabelPosition;
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig;
import com.sencha.gxt.chart.client.draw.Gradient;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.Stop;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextAnchor;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextBaseline;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class CorePieChart extends Composite {
	public CorePieChart() {
		initWidget(asWidget());
	}

	public interface DataPropertyAccess extends PropertyAccess<Data> {
		ValueProvider<Data, Double> data1();

		ValueProvider<Data, String> name();

		@Path("name")
		ModelKeyProvider<Data> nameKey();
	}

	private DataPropertyAccess dataPropertyAccess = GWT
			.create(DataPropertyAccess.class);

	public Widget asWidget() {
		final ListStore<Data> store = new ListStore<Data>(
				dataPropertyAccess.nameKey());
		store.addAll(getData(6, 20, 100));

		final Chart<Data> chart = new Chart<Data>();
		chart.setDefaultInsets(50);
		chart.setStore(store);
		chart.setShadowChart(true);

		Gradient slice1 = new Gradient("slice1", 45);
		slice1.addStop(new Stop(0, new RGB(148, 174, 10)));
		slice1.addStop(new Stop(100, new RGB(107, 126, 7)));
		chart.addGradient(slice1);
		Gradient slice2 = new Gradient("slice2", 45);
		slice2.addStop(new Stop(0, new RGB(17, 95, 166)));
		slice2.addStop(new Stop(100, new RGB(12, 69, 120)));
		chart.addGradient(slice2);
		Gradient slice3 = new Gradient("slice3", 45);
		slice3.addStop(new Stop(0, new RGB(166, 17, 32)));
		slice3.addStop(new Stop(100, new RGB(120, 12, 23)));
		chart.addGradient(slice3);
		Gradient slice4 = new Gradient("slice4", 45);
		slice4.addStop(new Stop(0, new RGB(255, 136, 9)));
		slice4.addStop(new Stop(100, new RGB(213, 110, 0)));
		chart.addGradient(slice4);
		Gradient slice5 = new Gradient("slice5", 45);
		slice5.addStop(new Stop(0, new RGB(255, 209, 62)));
		slice5.addStop(new Stop(100, new RGB(255, 197, 11)));
		chart.addGradient(slice5);
		Gradient slice6 = new Gradient("slice6", 45);
		slice6.addStop(new Stop(0, new RGB(166, 17, 135)));
		slice6.addStop(new Stop(100, new RGB(120, 12, 97)));
		chart.addGradient(slice6);

		final PieSeries<Data> series = new PieSeries<Data>();
		series.setAngleField(dataPropertyAccess.data1());
		series.addColor(slice1);
		series.addColor(slice2);
		series.addColor(slice3);
		series.addColor(slice4);
		series.addColor(slice5);
		series.addColor(slice6);

		TextSprite textConfig = new TextSprite();
		textConfig.setFont("Arial");
		textConfig.setTextBaseline(TextBaseline.MIDDLE);
		textConfig.setFontSize(18);
		textConfig.setTextAnchor(TextAnchor.MIDDLE);
		textConfig.setZIndex(50);

		SeriesLabelConfig<Data> labelConfig = new SeriesLabelConfig<Data>();
		labelConfig.setSpriteConfig(textConfig);
		labelConfig.setLabelPosition(LabelPosition.START);
		labelConfig.setValueProvider(dataPropertyAccess.name(),
				new StringLabelProvider<String>());

		series.setLabelConfig(labelConfig);
		series.setHighlighting(true);
		chart.addSeries(series);

		final Legend<Data> legend = new Legend<Data>();
		legend.setPosition(Position.RIGHT);
		legend.setItemHighlighting(true);
		legend.setItemHiding(true);
		series.setLegendValueProvider(dataPropertyAccess.name(),
				new LabelProvider<String>() {

					@Override
					public String getLabel(String item) {
						return item.substring(0, 3);
					}
				});
		chart.setLegend(legend);

		// Control part
		TextButton regenerateButton = new TextButton("Reload Data");
		regenerateButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				store.clear();
				store.addAll(getData(6, 20, 100));
				chart.redrawChart();
			}
		});

		ToggleButton donutButton = new ToggleButton("Donut");
		donutButton.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if (event.getValue()) {
					series.setDonut(35);
				} else {
					series.setDonut(0);
				}
				chart.redrawChart();
			}
		});

		ToggleButton animation = new ToggleButton("Animation");
		animation.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				chart.setAnimated(event.getValue());
			}
		});
		animation.setValue(true, true);

		ToggleButton shadow = new ToggleButton("Shadow");
		shadow.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				chart.setShadowChart(event.getValue());
				chart.redrawChart();
			}
		});
		shadow.setValue(true);

		ToolBar toolBar = new ToolBar();
		toolBar.add(regenerateButton);
		toolBar.add(animation);
		toolBar.add(shadow);
		toolBar.add(donutButton);

		ContentPanel panel = new FramedPanel();
		panel.getElement().getStyle().setMargin(10, Unit.PX);
		panel.setHeadingText("Pie Chart");
		panel.setCollapsible(true);
		panel.setPixelSize(620, 500);
		panel.setBodyBorder(true);

		final Resizable resizable = new Resizable(panel);
		resizable.setMinHeight(400);
		resizable.setMinWidth(400);

		panel.addExpandHandler(new ExpandHandler() {

			@Override
			public void onExpand(ExpandEvent event) {
				resizable.setEnabled(true);
			}
		});
		panel.addCollapseHandler(new CollapseHandler() {

			@Override
			public void onCollapse(CollapseEvent event) {
				resizable.setEnabled(false);
			}
		});

		new Draggable(panel, panel.getHeader()).setUseProxy(false);

		VerticalLayoutContainer layoutContainer = new VerticalLayoutContainer();

		toolBar.setLayoutData(new VerticalLayoutData(1, -1));
		layoutContainer.add(toolBar);

		chart.setLayoutData(new VerticalLayoutData(1, 1));
		layoutContainer.add(chart);

		panel.add(layoutContainer);

		return panel;
	}

	private static final String[] monthsFull = new String[] { "January",
			"February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	public static List<Data> getData(int size, double min, double scale) {
		List<Data> data = new ArrayList<Data>();
		for (int i = 0; i < size; i++) {
			data.add(new Data(monthsFull[i % monthsFull.length], Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min)), Math
					.floor(Math.max(Math.random() * scale, min))));
		}
		return data;
	}
	
	
}


class Data {
	private String name;
	private double data1;
	private double data2;
	private double data3;
	private double data4;
	private double data5;
	private double data6;
	private double data7;
	private double data8;
	private double data9;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getData1() {
		return data1;
	}
	public void setData1(double data1) {
		this.data1 = data1;
	}
	public double getData2() {
		return data2;
	}
	public void setData2(double data2) {
		this.data2 = data2;
	}
	public double getData3() {
		return data3;
	}
	public void setData3(double data3) {
		this.data3 = data3;
	}
	public double getData4() {
		return data4;
	}
	public void setData4(double data4) {
		this.data4 = data4;
	}
	public double getData5() {
		return data5;
	}
	public void setData5(double data5) {
		this.data5 = data5;
	}
	public double getData6() {
		return data6;
	}
	public void setData6(double data6) {
		this.data6 = data6;
	}
	public double getData7() {
		return data7;
	}
	public void setData7(double data7) {
		this.data7 = data7;
	}
	public double getData8() {
		return data8;
	}
	public void setData8(double data8) {
		this.data8 = data8;
	}
	public double getData9() {
		return data9;
	}
	public void setData9(double data9) {
		this.data9 = data9;
	}
	public Data(String name, double data1, double data2, double data3,
			double data4, double data5, double data6, double data7,
			double data8, double data9) {
		super();
		this.name = name;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
		this.data5 = data5;
		this.data6 = data6;
		this.data7 = data7;
		this.data8 = data8;
		this.data9 = data9;
	}
	
	
}
