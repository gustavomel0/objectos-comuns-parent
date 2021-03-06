/*
 * Copyright 2011 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.comuns.relational.jdbc;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import br.com.objectos.comuns.relational.search.ConfigurationException;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class AnsiUpdateBuilder extends AbstractJdbcSQLFunction implements UpdateBuilder {

  @Override
  public UpdateAlias update(String table) {
    JdbcUpdateAlias update = new JdbcUpdateAlias(table);
    if (containsKey(UpdateAlias.class)) {
      throw new ConfigurationException("aliases were already defined.");
    }
    putElement(UpdateAlias.class, update);
    return update;
  }

  @Override
  public UpdateSetter set(String colName, BigDecimal value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, Boolean value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, java.util.Date value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, DateTime value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, Double value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, Float value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, Integer value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, LocalDate value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, Long value) {
    return addValue(colName, value);
  }

  @Override
  public UpdateSetter set(String colName, String value) {
    return addValue(colName, value);
  }

  protected UpdateSet newUpdateSet(String colName, Object val) {
    return new AnsiUpdateSet(colName, val);
  }

  private UpdateSetter addValue(String colName, Object val) {
    putElement(UpdateSet.class, newUpdateSet(colName, val));
    return this;
  }

}