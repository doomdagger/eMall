package com.codeholic.ui.gwt.shared.goods.dto;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface StringPairProperties extends PropertyAccess<StringPair>{
	@Path("key")
	ModelKeyProvider<StringPair> theKey();

	@Path("value")
	LabelProvider<StringPair> valueLabel();

	ValueProvider<StringPair, String> key();

	ValueProvider<StringPair, String> value();
}
