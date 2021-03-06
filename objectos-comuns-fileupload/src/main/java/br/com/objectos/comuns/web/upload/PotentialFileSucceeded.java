/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.comuns.web.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import com.google.common.io.OutputSupplier;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class PotentialFileSucceeded implements PotentialFile {

  private final UploadedFile file;

  public PotentialFileSucceeded(UploadedFile file) {
    this.file = file;
  }

  @Override
  public UploadedFile get() throws UploadRequestException {
    return file;
  }

  @Override
  public UploadedFile saveAndGet() throws UploadRequestException {
    InputStream input = null;
    try {

      input = file.openStream();
      File tempFile = File.createTempFile("uploaded-file-", ".tmp");
      OutputSupplier<FileOutputStream> out = Files.newOutputStreamSupplier(tempFile);
      ByteStreams.copy(input, out);
      return new UploadedFileTemp(tempFile, file);

    } catch (IOException e) {

      throw new UploadRequestException(e);

    } finally {

      Closeables.closeQuietly(input);

    }
  }

}