package com.codecoy.caribbean.Listeners;

import com.codecoy.caribbean.dataModel.TourismSlider;

public interface OnSliderLoadListeners {
    public void onSliderLoaded(TourismSlider tourismSlider);
    public void onNotFound();
    public void onFailure(String e);
}
