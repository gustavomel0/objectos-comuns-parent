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
public class Duo implements Insertable {

  private Integer id;

  private final String a;
  private final String b;

  public Duo(String a, String b) {
    this.a = a;
    this.b = b;
  }

  public Duo(ResultSet rs) throws SQLException {
    this.id = rs.getInt("D.ID");
    this.a = rs.getString("D.TYPE");
    this.b = rs.getString("D.KEY");
  }

  @Override
  public Insert getInsert() {
    return Insert.into("COMUNS_RELATIONAL.DUO")

        .value("TYPE", a)
        .value("KEY", b)

        .onGeneratedKey(new GeneratedKeyCallback() {
          @Override
          public void set(ResultSet rs) throws SQLException {
            id = rs.next() ? rs.getInt(1) : null;
          }
        });
  }

  public Integer getId() {
    return id;
  }

  public String getA() {
    return a;
  }

  public String getB() {
    return b;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this) //
        .add("id", id) //
        .add("a", a) //
        .add("b", b) //
        .toString();
  }

}