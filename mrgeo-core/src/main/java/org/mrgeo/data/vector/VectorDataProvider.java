/*
 * Copyright 2009-2014 DigitalGlobe, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package org.mrgeo.data.vector;

import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.RecordWriter;

import java.io.IOException;

public abstract class VectorDataProvider
{
  private String resourceName;

  public VectorDataProvider(final String input)
  {
    resourceName = input;
  }

  public String getResourceName()
  {
    return resourceName;
  }

  /**
   * Return an instance of a class that can read metadata for this resource.
   * 
   * @return
   */
  public abstract VectorMetadataReader getMetadataReader();

  /**
   * Return an instance of a class that can write metadata for this resource.
   * 
   * @return
   */
  public abstract VectorMetadataWriter getMetadataWriter();

  public abstract VectorReader getVectorReader() throws IOException;

  /**
   * Return an instance of a VectorReader class to be used for reading vector data. This
   * method may be invoked by callers regardless of whether they are running within a
   * map/reduce job or not.
   * 
   * @return
   * @throws IOException 
   */
  public abstract VectorReader getVectorReader(VectorReaderContext context) throws IOException;

  public abstract VectorWriter getVectorWriter();

  public abstract VectorWriter getVectorWriter(VectorWriterContext context);

  /**
   * Return an instance of a RecordReader class to be used in map/reduce jobs for reading
   * vector data.
   * 
   * @return
   */
  public abstract RecordReader<VectorKey, VectorValue> getRecordReader();

  /**
   * Return an instance of a RecordWriter class to be used in map/reduce jobs for writing
   * vector data.
   * 
   * @return
   */
  public abstract RecordWriter<VectorKey, VectorValue> getRecordWriter();

  /**
   * Return an instance of an InputFormat class to be used in map/reduce jobs for processing
   * vector data.
   * 
   * @return
   */
  public abstract VectorInputFormatProvider getVectorInputFormatProvider(
    final VectorInputFormatContext context);

  /**
   * Return an instance of an OutputFormat class to be used in map/reduce jobs for producing
   * vector data.
   * 
   * @return
   */
  public abstract VectorOutputFormatProvider getVectorOutputFormatProvider(
    final VectorOutputFormatContext context);

  public abstract void delete() throws IOException;
  public abstract void move(String toResource) throws IOException;
}
