package com.example.carouselpicker_harmonyos.slice;

import CarouselPicker.CarouselViewAdapter;
import com.example.carouselpicker_harmonyos.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.text.Font;
import java.util.ArrayList;
import java.util.List;
public class MainAbilitySlice extends AbilitySlice {
    private static final String TAG = "MainAbilitySlice";
    private Component imageCarousel;
    private Component textCarousel;
    private Component mixCarousel;
    private Component tvSelected;

    @Override
    protected void onStart(Intent intent) {
        super.setUIContent(ResourceTable.Layout_ability_main);
        imageCarousel = findComponentById(ResourceTable.Id_imageCarousel);
        textCarousel = findComponentById(ResourceTable.Id_textCarousel);
        mixCarousel = findComponentById(ResourceTable.Id_mixCarousel);
        tvSelected = findComponentById(ResourceTable.Id_tvSelectedItem);

        List<CarouselPicker.PickerItem> imageItems = new ArrayList<>();
        imageItems.add(new CarouselPicker.DrawableItem(ResourceTable.Media_i1));
        imageItems.add(new CarouselPicker.DrawableItem(ResourceTable.Media_i2));
        imageItems.add(new CarouselPicker.DrawableItem(ResourceTable.Media_i3));
        imageItems.add(new CarouselPicker.DrawableItem(ResourceTable.Media_i4));
        CarouselViewAdapter imageAdapter = new CarouselViewAdapter(this, imageItems, 0);
        imageCarousel.setAdapter(imageAdapter);

        List<CarouselPicker.PickerItem> textItems = new ArrayList<>();
        textItems.add(new CarouselPicker.TextItem("hi", 20,
                getResources().getColor(ResourceTable.Color_holo_green_light), Font.MONOSPACE,
                CarouselPicker.TextItem.FontStyle.BOLD_ITALIC));
        textItems.add(new CarouselPicker.TextItem("hi", 20,
                Font.SANS_SERIF, CarouselPicker.TextItem.FontStyle.NORMAL));
        textItems.add(new CarouselPicker.TextItem("hi", 20,
                Font.SERIF, CarouselPicker.TextItem.FontStyle.ITALIC));
        textItems.add(new CarouselPicker.TextItem("hi", 20));
        CarouselViewAdapter textAdapter = new CarouselViewAdapter(this, textItems, 0);
        textCarousel.setAdapter(textAdapter);
        // set default color
        textAdapter.setTextColor(getResources().getColor(ResourceTable.Color_holo_green_light));

        List<CarouselPicker.PickerItem> mixItems = new ArrayList<>();
        mixItems.add(new CarouselPicker.DrawableItem(ResourceTable.Media_i1));
        mixItems.add(new CarouselPicker.TextItem("hi", 20));
        mixItems.add(new CarouselPicker.DrawableItem(ResourceTable.Media_i2));
        mixItems.add(new CarouselPicker.TextItem("hi", 20));

        CarouselViewAdapter mixAdapter = new CarouselViewAdapter(this, mixItems, 0);
        mixAdapter.setTextColor(getResources().getColor(ResourceTable.Color_colorPrimary));
        mixCarousel.setAdapter(mixAdapter);

        imageCarousel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvSelected.setText("Selected item in image carousel is  : "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        textCarousel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvSelected.setText("Selected item in text carousel is  : "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mixCarousel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvSelected.setText("Selected item in mix carousel is  : " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onActive() {  }

            @Override
            public void onForeground(Intent intent) {  }
        }
