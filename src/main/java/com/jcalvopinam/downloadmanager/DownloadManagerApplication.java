/*
 * MIT License
 *
 * Copyright (c) 2018. JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.downloadmanager;

import java.util.List;

import com.jcalvopinam.downloadmanager.core.Manager;
import com.jcalvopinam.downloadmanager.domain.File;
import com.jcalvopinam.downloadmanager.domain.FileResource;
import com.jcalvopinam.downloadmanager.utils.Commons;
import com.jcalvopinam.downloadmanager.utils.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina
 */
public class DownloadManagerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadManagerApplication.class);

    public static void main(String[] args) {
        final String welcomeMessage = Commons.drawBox("Welcome to DownloadManager");
        LOGGER.info("\n{}", welcomeMessage);

        FileResource fileResource = FileResource.of(args);

        List<File> files = InputData.readFile(fileResource.checkAndGetInput());
        Manager.INSTANCE.download(files, fileResource.checkAndGetOutput());
    }

}
