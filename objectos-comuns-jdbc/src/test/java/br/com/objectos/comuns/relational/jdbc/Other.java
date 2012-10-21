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

import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.common.base.Objects;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Other implements Insertable {

  private Integer id;

  private final Simple simple;

  private final String value;

  public Other(Simple simple, String value) {
    this.simple = simple;
    this.value = value;
  }

  public Other(ResultSet rs) throws SQLException {
    this.id = rs.getInt("ID");
    this.simple = new Simple(rs);
    this.value = rs.getString("VALUE");
  }

  public Integer getId() {
    return id;
  }

  public Integer getSimpleId() {
    return simple != null ? simple.getId() : null;
  }

  public String getValue() {
    return value;
  }

  @Override
  public Insert getInsert() {
    Integer simpleId = getSimpleId();

    return Insert.into("OTHER") //
        .value("SIMPLE_ID", simpleId) //
        .value("VALUE", value) //
        .onGeneratedKey(new GeneratedKeyCallback() {
          @Override
          public void set(ResultSet rs) throws SQLException {
            id = rs.next() ? rs.getInt(1) : null;
          }
        });
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this) //
        .add("id", id) //
        .add("value", simple.getString() + value) //
        .toString();
  }

}