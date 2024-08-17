package org.gampiot.robok.theme;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.LayoutRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder class to create a Theme Chooser Dialog
 *
 * @param context Context to use
 * @return ThemeChooserDialogBuilder
 */
public class ThemeChooserDialogBuilder {

    public final Context context;
    public MaterialAlertDialogBuilder builder;
    public ColorAdapter colorAdapter;
    public final Theme[] themes = Theme.values();

    public ThemeChooserDialogBuilder(Context context) {
        this.context = context;
        createDialog();
    }

    public void createDialog() {
        LayoutRecyclerviewBinding binding = LayoutRecyclerviewBinding.inflate(LayoutInflater.from(context));
        ThemeEngine themeEngine = ThemeEngine.getInstance(context);
        List<Integer> colorArray = new ArrayList<>();
        for (Theme theme : themes) {
            colorArray.add(theme.getPrimaryColor());
        }
        colorAdapter = new ColorAdapter(colorArray);
        colorAdapter.setCheckedPosition(themeEngine.getStaticTheme());
        binding.recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        binding.recyclerView.setAdapter(colorAdapter);

        builder = new MaterialAlertDialogBuilder(context).setView(binding.getRoot());
    }

    /**
     * Set title of the Dialog using the given string resource id
     *
     * @param res id of string resource
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setTitle(@StringRes int res) {
        builder.setTitle(res);
        return this;
    }

    /**
     * Set icon for the Dialog using the given drawable resource id
     *
     * @param iconId id of drawable resource
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setIcon(@DrawableRes int iconId) {
        builder.setIcon(iconId);
        return this;
    }

    /**
     * Set positive button text and a listener to be invoked when the positive button of the dialog is pressed
     *
     * @param text The text to display in the positive button
     * @param listener The OnClickListener to use when the button is clicked.
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setPositiveButton(String text, OnClickListener listener) {
        builder.setPositiveButton(
            text,
            (dialog, which) -> {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    int checkedPosition = colorAdapter.getCheckedPosition();
                    listener.onClick(checkedPosition, themes[checkedPosition]);
                }
            }
        );
        return this;
    }

    /**
     * Set positive button text and a listener to be invoked when the positive button of the dialog is pressed
     *
     * @param res id of string resource
     * @param listener The OnClickListener to use when the button is clicked.
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setPositiveButton(@StringRes int res, OnClickListener listener) {
        setPositiveButton(context.getString(res), listener);
        return this;
    }

    /**
     * Set negative button text
     *
     * @param text The text to display in the negative button
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setNegativeButton(String text) {
        builder.setNegativeButton(text, null);
        return this;
    }

    /**
     * Set negative button text
     *
     * @param res id of string resource
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setNegativeButton(@StringRes int res) {
        builder.setNegativeButton(res, null);
        return this;
    }

    /**
     * Set neutral button text and a listener to be invoked when the neutral button of the dialog is pressed
     *
     * @param text The text to display in the neutral button
     * @param listener The OnClickListener to use when the button is clicked.
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setNeutralButton(String text, OnClickListener listener) {
        builder.setNeutralButton(
            text,
            (dialog, which) -> {
                if (which == DialogInterface.BUTTON_NEUTRAL) {
                    int checkedPosition = colorAdapter.getCheckedPosition();
                    Theme theme = themes[checkedPosition];
                    listener.onClick(checkedPosition, theme);
                }
            }
        );
        return this;
    }

    /**
     * Set neutral button text and a listener to be invoked when the neutral button of the dialog is pressed
     *
     * @param res id of string resource
     * @param listener The OnClickListener to use when the button is clicked.
     * @return This Builder object to allow for chaining of calls to set methods
     */
    public ThemeChooserDialogBuilder setNeutralButton(@StringRes int res, OnClickListener listener) {
        setNeutralButton(context.getString(res), listener);
        return this;
    }

    /** Creates and return an {@link AlertDialog} */
    public AlertDialog create() {
        return builder.create();
    }

    public interface OnClickListener {
        void onClick(int position, Theme theme);
    }
}
