package com.codecoy.caribbean.listeners;

import com.codecoy.caribbean.dataModel.ShopCategoryModel;

import java.util.List;

public interface OnCategoriesLoadListeners {
    public void onCategoriesLoaded(List<ShopCategoryModel> categoryModels);
    public void onEmpty();
    public void onFailure(String e);
}
