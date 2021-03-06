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

package org.mrgeo.data.tsv;

import org.mrgeo.data.csv.CsvGeometryOutputStreamOld;

import java.io.OutputStream;


/**
 * It is assumed that all CSV files are in WGS84.
 * 
 * @author jason.surratt
 * 
 */
public class TsvGeometryOutputStreamOld extends CsvGeometryOutputStreamOld
{

  public TsvGeometryOutputStreamOld(OutputStream os)
  {
    super(os, "\t");
  }

}
