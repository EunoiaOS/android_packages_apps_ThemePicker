/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.customization.model;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.customization.picker.SectionView;

/**
 * The interface for the behavior of section in the Customization hub.
 *
 * @param <T> the {@link SectionView} to create for the section
 */
public interface HubSectionController<T extends SectionView> {

    /** Interface for Customization hub section navigation. */
    interface HubSectionNavigationController {
        /** Navigates to the given {@code fragment}. */
        void navigateTo(Fragment fragment);
    }

    /** Interface for Customization hub section's dark mode responding to battery saver. */
    interface HubSectionBatterySaverListener {
        /** Callback when battery saver's state changed with given {@code isEnabled}. */
        void onBatterySaverStateChanged(boolean isEnabled);
    }

    /** Returns {@code true} if the Customization hub section is available. */
    boolean isAvailable(@Nullable Context context);

    /**
     * Returns a newly created {@link SectionView} for the section.
     *
     * @param context the {@link Context} to inflate view
     */
    T createView(Context context);

    /** Saves the view state for configuration changes. */
    default void onSaveInstanceState(Bundle savedInstanceState) {}

    /** Releases the controller. */
    default void release() {}
}
