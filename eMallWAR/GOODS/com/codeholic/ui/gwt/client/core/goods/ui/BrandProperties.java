package com.codeholic.ui.gwt.client.core.goods.ui;

import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface BrandProperties extends PropertyAccess<BrandDto>{
	@Path("brandId")
	ModelKeyProvider<BrandDto> key();

	@Path("brandName")
	LabelProvider<BrandDto> nameLabel();

	ValueProvider<BrandDto, String> brandId();

	ValueProvider<BrandDto, String> brandCmment();
	
	ValueProvider<BrandDto, String> brandCode();
	
	ValueProvider<BrandDto, Integer> brandCountry();
	
	ValueProvider<BrandDto, String> brandDesc();

	ValueProvider<BrandDto, Integer> brandLevel();
	
	ValueProvider<BrandDto, String> brandName();
	
	ValueProvider<BrandDto, Integer> brandPop();

}
