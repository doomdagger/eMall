package com.codeholic.ui.gwt.client.core;

import com.codeholic.ui.gwt.client.core.dict.places.DictPlace;
import com.codeholic.ui.gwt.client.core.goods.places.BrandPlace;
import com.codeholic.ui.gwt.client.core.goods.places.GoodsPlace;
import com.codeholic.ui.gwt.client.core.goods.places.Goodsclass1Place;
import com.codeholic.ui.gwt.client.core.goods.places.Goodsclass2Place;
import com.codeholic.ui.gwt.client.core.places.BlankPlace;
import com.codeholic.ui.gwt.client.core.shop.places.ShopPlace;
import com.codeholic.ui.gwt.client.core.user.places.UserPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/*
 * 此类中可继续添加history token
 */

@WithTokenizers({ BlankPlace.Tokenizer.class, DictPlace.Tokenizer.class,
		UserPlace.Tokenizer.class, ShopPlace.Tokenizer.class,
		BrandPlace.Tokenizer.class, Goodsclass1Place.Tokenizer.class,
		Goodsclass2Place.Tokenizer.class, GoodsPlace.Tokenizer.class })
public interface ICorePlacesHistoryMapper extends PlaceHistoryMapper {

}
