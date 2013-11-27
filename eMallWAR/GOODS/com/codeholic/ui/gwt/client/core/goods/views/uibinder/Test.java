package com.codeholic.ui.gwt.client.core.goods.views.uibinder;

import com.codeholic.ui.gwt.shared.goods.dto.StringPair;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.SpinnerField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.DoublePropertyEditor;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.IntegerPropertyEditor;

public class Test {
	TextField goodsCode = new TextField();
	TextField goodsName = new TextField();
	SpinnerField<Integer> goodsMode = new SpinnerField<Integer>(new IntegerPropertyEditor());
	TextField goodsUnit = new TextField();
	SpinnerField<Double> goodsPrice = new SpinnerField<Double>(new DoublePropertyEditor());
	DateField goodsCreatetime = new DateField();
	
	ComboBox<StringPair> brand;
	ComboBox<StringPair> class1;
	ComboBox<StringPair> class2;
}
