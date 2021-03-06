/*
 * Copyright (C) 2017 Hazuki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.hazuki.yuzubrowser;

import android.app.Application;
import android.os.Environment;

import java.io.File;

import jp.hazuki.yuzubrowser.settings.data.AppData;
import jp.hazuki.yuzubrowser.utils.ErrorReport;
import jp.hazuki.yuzubrowser.utils.Logger;

public class BrowserApplication extends Application {
    private static final String TAG = "BrowserApplication";
    public static final String PERMISSION_MYAPP_SIGNATURE = "jp.hazuki.yuzubrowser.permission.myapp.signature";
    private static BrowserApplication instance;
    private static boolean needLoad;

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.d(TAG, "onCreate()");
        instance = this;
        needLoad = false;
        ErrorReport.initialize(this);
        AppData.load(this);
        ErrorReport.setDetailedLog(AppData.detailed_log.get());
    }

    public static File getExternalUserDirectory() {
        return new File(Environment.getExternalStorageDirectory() + File.separator + "YuzuBrowser" + File.separator);
    }

    public static BrowserApplication getInstance() {
        return instance;
    }

    public static boolean isNeedLoad() {
        return needLoad;
    }

    public static void setNeedLoad(boolean needLoad) {
        BrowserApplication.needLoad = needLoad;
    }
}
