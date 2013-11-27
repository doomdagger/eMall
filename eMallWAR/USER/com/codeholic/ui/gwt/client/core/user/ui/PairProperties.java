package com.codeholic.ui.gwt.client.core.user.ui;

import com.codeholic.ui.gwt.shared.user.dto.Pair;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface PairProperties extends PropertyAccess<Pair>{
	@Path("key")
	ModelKeyProvider<Pair> theKey();

	@Path("value")
	LabelProvider<Pair> valueLabel();

	ValueProvider<Pair, Integer> key();

	ValueProvider<Pair, String> value();
	
}
